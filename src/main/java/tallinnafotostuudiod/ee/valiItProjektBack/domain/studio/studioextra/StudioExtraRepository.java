package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;

import java.util.List;

public interface StudioExtraRepository extends JpaRepository<StudioExtra, Integer> {
    @Query("select s from StudioExtra s where s.studio.id = ?1 and s.extra.id = ?2")
    StudioExtra findByStudio_IdAndExtra_Id(Integer id, Integer id1);



    @Query("select s from StudioExtra s where s.studio.id = ?1")
    List<StudioExtra> findByStudio_Id(Integer id);



    @Override
    void deleteById(Integer integer);
}


