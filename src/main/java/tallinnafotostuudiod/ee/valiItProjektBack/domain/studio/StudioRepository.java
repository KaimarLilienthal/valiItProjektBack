package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudioRepository extends JpaRepository<Studio, Integer> {
    @Query("select s from Studio s where s.status = ?1 and (s.id = ?2 or ?2 = 0)")
    List<Studio> findByStatusAndId(String status, Integer id);
    @Query("select s from Studio s where (s.district.id = ?1 or ?1 = 0) and s.status = ?2")
    List<Studio> findAllStudiosBy(Integer districtId, String status);

    @Query("select s from Studio s where s.ownerUser.id = ?1 and s.status = ?2 order by s.name")
    List<Studio> findStudiosBy(Integer ownerUserId, String status);

    @Query("select (count(s) > 0) from Studio s where s.url = ?1")
    boolean existsBy(String url);

    @Query("select s from Studio s where s.id = ?1 and s.status = ?2")
    Studio getStudioBy(Integer studioId, String status);

}