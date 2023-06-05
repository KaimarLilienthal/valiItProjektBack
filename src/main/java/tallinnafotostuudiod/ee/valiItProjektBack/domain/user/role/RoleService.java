package tallinnafotostuudiod.ee.valiItProjektBack.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    public static final int USER_ROLE_ID_STUDIO = 2;

    @Resource
    private RoleRepository roleRepository;

    public Role findUserRoleStudio() {
        Role role = roleRepository.findById(USER_ROLE_ID_STUDIO).get();
        return role;
    }

}
