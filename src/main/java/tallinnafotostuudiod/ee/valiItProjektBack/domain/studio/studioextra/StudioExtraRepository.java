package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudioExtraRepository extends JpaRepository<StudioExtra, Integer> {
    @Query("select s from StudioExtra s where s.studio.id = ?1")
    List<StudioExtra> findByStudio_Id(Integer id);
}


