package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Resource
    private AddressRepository addressRepository;
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

}
