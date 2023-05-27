package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraSimpleDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.StudioService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.ExtraService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraRepository;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtraService;

import java.util.List;

@Service
public class ExtrasService {

    @Resource
    private ExtraService extraService;
    @Resource
    private StudioExtraService studioExtraService;
    @Resource
    private StudioExtraMapper studioExtraMapper;
    @Resource
    private StudioService studioService;
    private final StudioExtraRepository studioExtraRepository;

    public ExtrasService(StudioExtraRepository studioExtraRepository) {
        this.studioExtraRepository = studioExtraRepository;
    }


    public List<Extra> findAllExtras() {
        List<Extra> extras = extraService.findAllExtras();
        return extras;
    }

    public List<StudioExtraDto> findAllSelectedExtrasWithPrice(Integer studioId) {
        List<StudioExtra> extras = studioExtraService.findAllExtras(studioId);
        List<StudioExtraDto> studioExtraDtos = studioExtraMapper.toExtrasDto(extras);
        return studioExtraDtos;

    }

    public void deleteExtra(Integer studioId, Integer extraId) {
        studioExtraService.deleteSelectedExtra(studioId, extraId);
    }

    public void addStudioPricedExtras(StudioExtraSimpleDto studioExtraSimpleDto) {
        extraService.findExistExtraBy(studioExtraSimpleDto.getStudioId(), studioExtraSimpleDto.getExtraId());
        StudioExtra studioExtra = studioExtraMapper.toStudioExtraEntity(studioExtraSimpleDto);

        Studio studio = studioService.getStudioId(studioExtraSimpleDto.getStudioId());
        studioExtra.setStudio(studio);

        Extra extra = extraService.getExtraId(studioExtraSimpleDto.getExtraId());
        studioExtra.setExtra(extra);

        studioExtraRepository.save(studioExtra);

    }
}
