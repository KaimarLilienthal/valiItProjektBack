package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Resource
    private StudioRepository studioRepository;

    public List<Studio> findUserActiveStudios(Integer userId) {
        List<Studio> studios = studioRepository.findStudiosBy(userId, "A");
        return studios;
    }


    public void addStudio(Studio studio) {
        studioRepository.save(studio);
    }
}
