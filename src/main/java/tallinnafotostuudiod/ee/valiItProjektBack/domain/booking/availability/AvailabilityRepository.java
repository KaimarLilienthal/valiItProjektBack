package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query("select a from Availability a where a.studio.id = ?1")
    Availability findByStudioId();

    @Query("select a from Availability a where a.studio.id = ?1")
    List<Availability> findAvailabilitiesBy(Integer id);


}