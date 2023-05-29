package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query("select (count(a) > 0) from Availability a where a.startDate <= ?1 and a.endDate >= ?2")
    boolean existsByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);






    @Query("select a from Availability a where a.studio.id = ?1")
    Availability findByStudioId();

    @Query("select a from Availability a where a.studio.id = ?1")
    List<Availability> findAvailabilitiesBy(Integer id);


}