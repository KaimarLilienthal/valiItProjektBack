package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraRepository;
import tallinnafotostuudiod.ee.valiItProjektBack.validation.ValidationService;

import java.util.List;

@Service
public class ExtraService {

    @Resource
    private ExtraRepository extraRepository;
    private final StudioExtraRepository studioExtraRepository;

    public ExtraService(StudioExtraRepository studioExtraRepository) {
        this.studioExtraRepository = studioExtraRepository;
    }

    public List<Extra> findAllExtras() {
        List<Extra> extras = extraRepository.findAll();
        return extras;
    }

    public Extra getExtraId(Integer extraId) {
        Extra extra = extraRepository.findById(extraId).get();
        return extra;
    }

    public void findExistExtraBy(Integer studioId, Integer extraId) {
        boolean extraExists = studioExtraRepository.existsBy(studioId, extraId);
        ValidationService.validateExtraIsAvailable(extraExists);
    }

    public Extra findExtraBy(Integer extraId) {
        Extra extra = extraRepository.findById(extraId).get();
        return extra;
    }

}
