package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService {

    @Resource
    private ExtraRepository extraRepository;


    public List<Extra> findAllExtras() {
        List<Extra> extras = extraRepository.findAll();
        return extras;

    }
}
