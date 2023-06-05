package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Transactional
    @Modifying
    @Query("delete from Booking b where b.studio = ?1")
    int deleteByStudio(Studio studio);
    @Query("select b from Booking b where b.studio.id = ?1 and b.date = ?2")
    List<Booking> findBookingsBy(Integer studioId, LocalDate date);



}