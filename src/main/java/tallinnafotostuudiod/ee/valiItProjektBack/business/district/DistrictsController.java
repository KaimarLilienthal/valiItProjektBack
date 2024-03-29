package tallinnafotostuudiod.ee.valiItProjektBack.business.district;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tallinnafotostuudiod.ee.valiItProjektBack.business.district.dto.DistrictDto;

import java.util.List;

@RestController
public class DistrictsController {

    @Resource
    private DistrictsService districtsService;

    @GetMapping("/districts")
    public List<DistrictDto> getDistricts() {
        List<DistrictDto> districts = districtsService.getDistricts();
        return districts;
    }

}
