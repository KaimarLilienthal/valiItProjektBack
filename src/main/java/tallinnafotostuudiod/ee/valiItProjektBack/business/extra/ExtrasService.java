package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraService;

import java.util.List;

@Service
public class ExtrasService {

    @Resource
    private ExtraService extraService;
    @Resource
    private ExtraMapper extraMapper;
    @Resource
    private StudioExtraService studioExtraService;
    @Resource
    private StudioExtraMapper studioExtraMapper;


    public List<Extra> findAllExtras() {
        List<Extra> extras = extraService.findAllExtras();
        return extras;
    }

    public List<StudioExtraDto> findAllSelectedExtrasWithPrice(Integer studioId) {
        List<StudioExtra> extras = studioExtraService.findAllExtras(studioId);
        List<StudioExtraDto> studioExtraDtos = studioExtraMapper.toExtrasDto(extras);
        return studioExtraDtos;

    }
}
