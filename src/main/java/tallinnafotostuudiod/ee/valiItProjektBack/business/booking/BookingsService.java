package tallinnafotostuudiod.ee.valiItProjektBack.business.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityInfoDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.Availability;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;

import java.util.List;

@Service
public class BookingsService {

    @Resource
    private AvailabilityService availabilityService;

    @Resource
    private AvailabilityMapper availabilityMapper;

    @Resource
    private StudioService studioService;

    public void addBookingAvailability(Integer studioId, AvailabilityRequest availabilityRequest) {
        availabilityService.studioAvailabilityExists(availabilityRequest.getStartDate(), availabilityRequest.getEndDate());

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
}
