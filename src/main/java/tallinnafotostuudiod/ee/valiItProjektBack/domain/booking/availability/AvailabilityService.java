package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.validation.ValidationService;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityService {

    @Resource
    private AvailabilityRepository availabilityRepository;


    public Availability findAvailabilityBy(Integer studioId) {
        Availability availability = availabilityRepository.findByStudioId();
        return availability;
    }

    public void addAvailability(Availability availability) {
        availabilityRepository.save(availability);
    }


    public List<Availability> allStudioAvailabilities(Integer studioId) {
        List<Availability> availabilities = availabilityRepository.findAvailabilitiesBy(studioId);
        return availabilities;


    }

    public void deleteStudioAvailabilityBy(Integer availabilityId) {
        availabilityRepository.deleteById(availabilityId);
    }

    public void studioAvailabilityExists(LocalDate startDate) {
        boolean availabilityExists = availabilityRepository.existsByStartDateBetweenPreviousDates(startDate);
        ValidationService.validateStartDateIsAvailable(availabilityExists);

    }
}

