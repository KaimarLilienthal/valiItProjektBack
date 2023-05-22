package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("select d from District d order by d.name")
    List<District> findAllDistricts();

}