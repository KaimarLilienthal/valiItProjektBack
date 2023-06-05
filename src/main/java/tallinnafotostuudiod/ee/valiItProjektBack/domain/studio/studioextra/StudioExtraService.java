package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

import java.util.List;

@Service
public class StudioExtraService {

    @Resource
    private StudioExtraRepository studioExtraRepository;

    public List<StudioExtra> findAllExtras(Integer studioId) {
        List<StudioExtra> extras = studioExtraRepository.findByStudio_Id(studioId);
        return extras;
    }

    public void deleteSelectedExtra(Integer studioId, Integer extraId) {
        StudioExtra studioExtraId = studioExtraRepository.findByStudio_IdAndExtra_Id(studioId, extraId);
        studioExtraRepository.delete(studioExtraId);
    }

}

