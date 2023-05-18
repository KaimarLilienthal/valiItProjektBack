package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;

import java.util.List;

@Service
public class StudiosService {

    @Resource
    private StudioService studioService;

    @Resource
    private StudioMapper studioMapper;


    public List<StudioDto> findUserStudios(Integer userId) {
        List<Studio> studios = studioService.findUserActiveStudios(userId);
        List<StudioDto> studioDtos = studioMapper.toStudioDtos(studios);
        return studioDtos;
    }
}
