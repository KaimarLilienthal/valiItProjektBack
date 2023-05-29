package tallinnafotostuudiod.ee.valiItProjektBack.business.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.StudiosService;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioGeneralInfo;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.Availability;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.AvailabilityService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;

@Service
public class BookingsService {

    @Resource
    private AvailabilityService availabilityService;

    @Resource
    private AvailabilityMapper availabilityMapper;

    @Resource
    private StudioService studioService;

    public void addBookingAvailability(Integer studioId, AvailabilityRequest availabilityRequest) {
        // todo: otsi studioId abil ülesse studio objekt
        Studio studio = studioService.getUserActiveStudio(studioId);
        Availability availability = availabilityMapper.toAvailability(availabilityRequest);
        // todo: pane setteriga studio objekt külge (andmebaasis on meil foreign key number, Javas on objekt)

        availability.setStudio(studio);


        availabilityService.addAvailability(availability);
    }
}
