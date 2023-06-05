package tallinnafotostuudiod.ee.valiItProjektBack.business.district;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.district.dto.DistrictDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.District;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.DistrictMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.DistrictService;

import java.util.List;

@Service
public class DistrictsService {

    @Resource
    private DistrictService districtService;

    @Resource
    private DistrictMapper districtMapper;

    public List<DistrictDto> getDistricts() {
        List<District> district = districtService.getAllDistricts();
        List<DistrictDto> districtDtos = districtMapper.toDistrictsDto(district);
        return districtDtos;

    }

}
