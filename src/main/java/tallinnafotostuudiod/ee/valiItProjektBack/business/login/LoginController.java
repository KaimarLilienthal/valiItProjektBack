package tallinnafotostuudiod.ee.valiItProjektBack.business.login;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto.LoginResponse;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine username ja password'iga")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }
}
