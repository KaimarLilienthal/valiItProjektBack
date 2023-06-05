package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HourRepository extends JpaRepository<Hour, Integer> {
    @Query("select h from Hour h where h.booking.id = ?1 order by h.start")
    List<Hour> findHoursBy(Integer bookingId);

}