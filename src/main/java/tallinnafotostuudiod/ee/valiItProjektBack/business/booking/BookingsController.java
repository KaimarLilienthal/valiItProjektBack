package tallinnafotostuudiod.ee.valiItProjektBack.business.booking;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityHourDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityInfoDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.BookingDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingsController {

    @Resource
    private BookingsService bookingsService;

    @PostMapping("/availability")
    public void addBookingAvailability(@RequestParam Integer studioId, @RequestBody AvailabilityRequest availabilityRequest) {
        bookingsService.addBookingAvailability(studioId, availabilityRequest);
    }

    @GetMapping("/availability")
    public List<AvailabilityInfoDto> getStudioAvailabilities(@RequestParam Integer studioId) {
        List<AvailabilityInfoDto> studioAvailabilities = bookingsService.getStudioAvailabilities(studioId);
        return studioAvailabilities;
    }

    @DeleteMapping("availability")
    public void deleteStudioAvailability(@RequestParam Integer availabilityId) {
        bookingsService.deleteStudioAvailability(availabilityId);
    }

    @GetMapping("availability/studio-times")
    public List<AvailabilityHourDto> getStudioAvailableHours(@RequestParam Integer studioId, @RequestParam LocalDate selectedDate){
       return bookingsService.getStudioAvailableHours(studioId, selectedDate);

    }

    @PostMapping("studio-booking")
    public void saveSelectedBooking(@RequestParam Integer studioId, @RequestBody BookingDto bookingDto){
        bookingsService.saveSelectedBooking(studioId, bookingDto);

    }

}
