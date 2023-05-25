package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extra")
public class ExtrasController {
    @Resource
    private ExtrasService extrasService;

    @GetMapping("/studio-extras")
    @Operation(summary = "Kuvab kõik stuudio lisateenused")
    public void findAllStudioExtras(@RequestParam Integer studioId) {
        extrasService.findAllStudioExtras(studioId);
    }
}
