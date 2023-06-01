package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("select b from Booking b where b.studio.id = ?1 and b.date = ?2")
    List<Booking> findBookingsBy(Integer studioId, LocalDate date);

}