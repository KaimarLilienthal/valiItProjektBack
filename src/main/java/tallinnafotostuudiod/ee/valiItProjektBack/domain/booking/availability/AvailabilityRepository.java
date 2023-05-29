package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query("select a from Availability a where a.studio.id = ?1")
    Availability findByStudio_Id();

}