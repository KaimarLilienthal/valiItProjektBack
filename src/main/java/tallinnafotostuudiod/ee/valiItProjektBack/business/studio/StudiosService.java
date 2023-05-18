package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;

import java.util.List;

@Service
public class StudiosService {

    @Resource
    private StudioService studioService;




    public void findUserStudios(Integer userId) {
        List<Studio> studios = studioService.findUserActiveStudios(userId);

    }
}
