package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query("select (count(a) > 0) from Availability a where a.studio.id = ?1 and a.startDate <= ?2 and a.endDate >= ?2")
    boolean existsByStudio_IdAndStartDateAndEndDate(Integer id, LocalDate startDate, LocalDate endDate);

    @Query("select a from Availability a where a.studio.id = ?1")
    Availability findByStudioId();

    @Query("select a from Availability a where a.studio.id = ?1")
    List<Availability> findAvailabilityBy(Integer id);

    @Query("select a from Availability a where a.studio.id = ?1 and a.startDate <= ?2 and a.endDate >= ?3")
    Availability findAvailabilityBy(Integer studioId, LocalDate startDate, LocalDate endDate);

}