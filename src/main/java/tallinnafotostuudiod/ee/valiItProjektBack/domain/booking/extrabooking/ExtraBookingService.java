package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraBookingService {

    @Resource
    private ExtraBookingRepository extraBookingRepository;

    public void addExtraBookings(List<ExtraBooking> extraBookings) {
        extraBookingRepository.saveAll(extraBookings);
    }

    public List<ExtraBooking> findExtraBookings(Integer bookingId) {
       return extraBookingRepository.findExtraBookingsBy(bookingId);
    }

}
