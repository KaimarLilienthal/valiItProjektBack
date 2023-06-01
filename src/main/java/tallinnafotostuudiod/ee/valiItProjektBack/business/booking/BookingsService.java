package tallinnafotostuudiod.ee.valiItProjektBack.business.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraBookingDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.BookingMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.BookingService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.Availability;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking.ExtraBooking;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking.ExtraBookingMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking.ExtraBookingService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour.Hour;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour.HourMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour.HourService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingsService {

    @Resource
    private AvailabilityService availabilityService;

    @Resource
    private AvailabilityMapper availabilityMapper;

    @Resource
    private StudioService studioService;

    @Resource
    private BookingMapper bookingMapper;

    @Resource
    private BookingService bookingService;

    @Resource
    private HourService hourService;

    @Resource
    private HourMapper hourMapper;

    @Resource
    private ExtraBookingMapper extraBookingMapper;

    @Resource
    private ExtraService extraService;

    @Resource
    private ExtraBookingService extraBookingService;


    public void addBookingAvailability(Integer studioId, AvailabilityRequest availabilityRequest) {
        availabilityService.studioAvailabilityExists(availabilityRequest.getStartDate());

        // todo: otsi studioId abil ülesse studio objekt
        Studio studio = studioService.getUserActiveStudio(studioId);
        Availability availability = availabilityMapper.toAvailability(availabilityRequest);
        // todo: pane setteriga studio objekt külge (andmebaasis on meil foreign key number, Javas on objekt)

        availability.setStudio(studio);


        availabilityService.addAvailability(availability);
    }

    public List<AvailabilityInfoDto> getStudioAvailabilities(Integer studioId) {
        List<Availability> availabilities = availabilityService.allStudioAvailabilities(studioId);
        List<AvailabilityInfoDto> availabilitiesInfoDto = availabilityMapper.toAvailabilitiesDto(availabilities);
        return availabilitiesInfoDto;


    }

    public void deleteStudioAvailability(Integer availabilityId) {
        availabilityService.deleteStudioAvailabilityBy(availabilityId);
    }

    public List<AvailabilityHourDto> getStudioAvailableHours(Integer studioId, LocalDate selectedDate) {
        Availability availability = availabilityService.findStudioAvailability(studioId, selectedDate);

        List<AvailabilityHourDto> hourDtos = new ArrayList<>();

        if (availability == null) {
            return hourDtos;
        }
        Integer startHour = availability.getStartHour();
        Integer endHour = availability.getEndHour();

        for (int hour = startHour; hour < endHour; hour++) {
            AvailabilityHourDto availabilityHour = new AvailabilityHourDto(hour);
            hourDtos.add(availabilityHour);
        }

        return hourDtos;

    }

    @Transactional
    public Integer saveSelectedBooking(Integer studioId, BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        Studio studio = studioService.getUserActiveStudio(studioId);
        booking.setStudio(studio);
        booking.setTotalPrice(0);
        bookingService.addBooking(booking);

        List<Hour> hours = createHours(bookingDto, booking);
        //  hourService -> hourRepository -> saveAll(hours)
        hourService.addBookingHours(hours);


        int totalPrice = calculateHoursTotalPrice(studio, hours);


        List<ExtraBooking> extraBookings = new ArrayList<>();

        for (StudioExtraDto studioExtraDto : bookingDto.getStudioExtras()) {
            if (studioExtraDto.getIsSelected()) {
                totalPrice += studioExtraDto.getExtraPrice();

                ExtraBooking extraBooking = new ExtraBooking();
                extraBooking.setBooking(booking);
                extraBooking.setPrice(studioExtraDto.getExtraPrice());
                //  extraService -> extraRepository
                //  -> findExtraBy(extraId)
                Extra extra = extraService.findExtraBy(studioExtraDto.getExtraId());
                //  extraBooking.setExtra(extra);
                extraBooking.setExtra(extra);
                extraBookings.add(extraBooking);
            }
        }

        // todo:
        // todo studioExtraService -> studioExtraRepository -> saveAll(extraBookings)

        extraBookingService.addExtraBookings(extraBookings);

        booking.setTotalPrice(totalPrice);
        bookingService.addBooking(booking);
        return booking.getId();
    }

    private static int calculateHoursTotalPrice(Studio studio, List<Hour> hours) {
        int hoursSize = hours.size();
        int totalPrice = hoursSize * studio.getHourPrice();
        return totalPrice;
    }

    private static List<Hour> createHours(BookingDto bookingDto, Booking booking) {
        List<Hour> hours = new ArrayList<>();
        for (AvailabilityHourDto selectedTimeDto : bookingDto.getSelectedTimes()) {
            if (selectedTimeDto.getIsSelected()) {
                Hour hour = new Hour();
                hour.setBooking(booking);
                hour.setStart(selectedTimeDto.getStartHour());
                hours.add(hour);
            }
        }
        return hours;
    }

    public BookingInfoDto getBookingInformation(Integer bookingId) {
        Booking booking = bookingService.getBookingInformation(bookingId);

        BookingInfoDto bookingDto = bookingMapper.toBookingDto(booking);
        List<Hour> hours = hourService.getBookingHoursBy(bookingId);
        List<HourDto> hoursDto = hourMapper.toHoursDto(hours);
        bookingDto.setHours(hoursDto);


        List<ExtraBooking> extraBookings = extraBookingService.findExtraBookings(bookingId);
        List<ExtraBookingDto> dtos = extraBookingMapper.toDtos(extraBookings);
        bookingDto.setExtraBookings(dtos);

        return bookingDto;
    }


}

