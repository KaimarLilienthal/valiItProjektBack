package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourService {

    @Resource
    private HourRepository hourRepository;

    public void addBookingHours(List<Hour> hours) {
        hourRepository.saveAll(hours);
    }


    public List<Hour> getBookingHoursBy(Integer bookingId) {
        List<Hour> hours = hourRepository.findHoursBy(bookingId);
        return hours;
    }
}

