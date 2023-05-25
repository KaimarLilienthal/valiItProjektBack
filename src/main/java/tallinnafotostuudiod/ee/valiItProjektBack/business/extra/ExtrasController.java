package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraDto;

import java.util.List;

@RestController
@RequestMapping("/extra")
public class ExtrasController {
    @Resource
    private ExtrasService extrasService;

    @GetMapping("/all")
    @Operation(summary = "Kuvab kõik lisateenused")
    public List<ExtraDto> findAllExtras() {
        List<ExtraDto> allExtras = extrasService.findAllExtras();
        return allExtras;
    }

//    @PostMapping("/studio-extra")
//    @Operation(summary = "Lisab valitud ja hinnastatud lisateenused")
//    public void addStudioPricedExtras(@RequestBody )

}
