package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraService;

import java.util.List;

@Service
public class ExtrasService {

    @Resource
    private ExtraService extraService;
    @Resource
    private ExtraMapper extraMapper;
    @Resource
    private StudioService studioService;


    public List<ExtraDto> findAllExtras() {
        List<Extra> extras = extraService.findAllExtras();
        List<ExtraDto> extrasDto = extraMapper.toExtrasDto(extras);
        return extrasDto;
    }
}
