package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  @Resource
    private BookingRepository bookingRepository;

  public void addBooking(Booking booking) {
    bookingRepository.save(booking);
  }

  public Booking getBookingInformation(Integer bookingId) {
    Booking booking = bookingRepository.findById(bookingId).get();
    return booking;
  }


}
