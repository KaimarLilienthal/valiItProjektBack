package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Resource
    private AvailabilityRepository availabilityRepository;


    public Availability findAvailabilityBy(Integer studioId) {
        Availability availability = availabilityRepository.findByStudio_Id();
        return availability;
    }

    public void addAvailability(Availability availability) {
        availabilityRepository.save(availability);
    }
}

