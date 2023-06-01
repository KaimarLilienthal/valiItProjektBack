package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExtraBookingRepository extends JpaRepository<ExtraBooking, Integer> {
    @Query("select e from ExtraBooking e where e.booking.id = ?1 order by e.extra.id")
    List<ExtraBooking> findExtraBookingsBy(Integer bookingId);

}