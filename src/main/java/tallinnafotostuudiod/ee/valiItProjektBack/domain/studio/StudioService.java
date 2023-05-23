package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.validation.ValidationService;

import java.util.List;
import java.util.Optional;

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

    public void findExistsUrlBy(String url) {
        boolean urlExists = studioRepository.existsBy(url);
        ValidationService.validateUrlIsAvailable(urlExists);
    }

    public Optional<Studio> getUserActiveStudio(Integer studioId) {
        Optional<Studio> studio = studioRepository.findById(studioId);
        return studio;
    }
}
