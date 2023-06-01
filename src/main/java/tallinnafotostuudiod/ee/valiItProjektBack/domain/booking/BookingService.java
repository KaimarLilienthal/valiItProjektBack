package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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


  public List<Booking> getBookingsBy(Integer studioId, LocalDate selectedDate) {
   return bookingRepository.findBookingsBy(studioId, selectedDate);
  }
}
