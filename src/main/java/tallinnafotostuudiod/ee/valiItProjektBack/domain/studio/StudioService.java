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

    public Studio getUserActiveStudio(Integer studioId) {
        return studioRepository.findById(studioId).get();
    }

    public void deleteUserActiveStudio(Integer studioId) {
        studioRepository.deleteById(studioId);
    }


    public List<Studio> findAllAreaStudios(Integer districtId) {
        List<Studio> studio = studioRepository.findStudiosBy(districtId);
        return studio;
    }


    public Optional<Studio> findUserStudioHourPrice(Integer studioId) {
        Optional<Studio> hourPrice = studioRepository.findById(studioId);
        return hourPrice;
    }

    public Studio getStudioId(Integer studioId) {
        return studioRepository.getStudioBy(studioId, "A");
    }
}

