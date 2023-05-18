package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudioRepository extends JpaRepository<Studio, Integer> {
    @Query("select s from Studio s where s.ownerUser.id = ?1 and s.status = ?2 order by s.name")
    List<Studio> findStudiosBy(Integer ownerUserId, String status);




}