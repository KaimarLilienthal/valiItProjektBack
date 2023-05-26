package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraSimpleDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;

import java.util.List;

@RestController
@RequestMapping("/extra")
public class ExtrasController {
    @Resource
    private ExtrasService extrasService;

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik lisateenused")
    public List<Extra> findAllExtras() {
        List<Extra> extras = extrasService.findAllExtras();
        return extras;

    }

    @GetMapping("/studio-extras")
    @Operation(summary = "Kuvab kõik valitud lisateenused hinnaga")
    public List<StudioExtraDto> findAllSelectedExtrasWithPrice(@RequestParam Integer studioId) {
        List<StudioExtraDto> selectedExtrasWithPrice = extrasService.findAllSelectedExtrasWithPrice(studioId);
        return selectedExtrasWithPrice;
    }

    @DeleteMapping("/studio-extra")
    @Operation(summary = "Kustutab valitud ja hinnaga lisateenuse")
    public void deleteExtra(@RequestParam Integer studioId, @RequestParam Integer extraId) {
        extrasService.deleteExtra(studioId, extraId);
    }

    @PostMapping("/studio-extra")
    @Operation(summary = "Lisab valitud ja hinnastatud lisateenused")
    public void addStudioPricedExtras(@RequestBody StudioExtraSimpleDto studioExtraSimpleDto){
        extrasService.addStudioPricedExtras(studioExtraSimpleDto);
    }

}
