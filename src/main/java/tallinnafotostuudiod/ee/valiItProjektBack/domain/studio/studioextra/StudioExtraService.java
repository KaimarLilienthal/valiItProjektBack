package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioExtraService {


    @Resource
    private StudioExtraRepository studioExtraRepository;

    public List<StudioExtra> findAllExtras(Integer studioId) {
        List<StudioExtra> extras = studioExtraRepository.findByStudio_Id(studioId);
        return extras;

    }
}

