package tallinnafotostuudiod.ee.valiItProjektBack.business.booking;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;

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
    public List<AvailabilityRequest> getStudioAvailabilities(@RequestParam Integer studioId) {
        List<AvailabilityRequest> studioAvailabilities = bookingsService.getStudioAvailabilities(studioId);
        return studioAvailabilities;


    }

}
