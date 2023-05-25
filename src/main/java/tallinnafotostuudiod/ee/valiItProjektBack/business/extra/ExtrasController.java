package tallinnafotostuudiod.ee.valiItProjektBack.business.extra;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
