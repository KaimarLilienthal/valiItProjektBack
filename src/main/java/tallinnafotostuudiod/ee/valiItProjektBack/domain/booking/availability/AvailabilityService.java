package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import jakarta.annotation.Resource;
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
        List<Availability> availabilities = availabilityRepository.findAvailabilityBy(studioId);
        return availabilities;


    }

    public void deleteStudioAvailabilityBy(Integer availabilityId) {
        availabilityRepository.deleteById(availabilityId);
    }

    public void studioAvailabilityExists(Integer studioId, LocalDate startDate) {
        boolean availabilityExists = availabilityRepository.existsByStudio_IdAndStartDateAndEndDate(studioId, startDate,startDate);
        ValidationService.validateStartDateIsAvailable(availabilityExists);

    }

    public Availability findStudioAvailability(Integer studioId, LocalDate selectedDate) {
        return availabilityRepository.findAvailabilityBy(studioId, selectedDate, selectedDate);
    }
}

