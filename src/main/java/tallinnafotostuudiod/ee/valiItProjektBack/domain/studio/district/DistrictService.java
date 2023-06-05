package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Resource
    private DistrictRepository districtRepository;

    public District findDistrictBy(Integer districtId) {
        District district = districtRepository.findById(districtId).get();
        return district;
    }

    public List<District> getAllDistricts() {
        List<District> districts = districtRepository.findAll();
        return districts;
    }

}
