package tallinnafotostuudiod.ee.valiItProjektBack.business.login;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto.LoginResponse;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.User;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.UserMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.UserService;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }

    public String findEmail(String email) {
        String exists = userService.findEmailExists(email);
        return exists;
    }

}
