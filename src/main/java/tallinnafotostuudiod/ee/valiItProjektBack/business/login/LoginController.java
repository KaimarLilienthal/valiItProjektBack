package tallinnafotostuudiod.ee.valiItProjektBack.business.login;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/register")
    @Operation(summary = "Vaatab kas Email on juba süsteemis")
    public String findEmail(@RequestParam String email) {
        String exists = loginService.findEmail(email);
        return exists;
    }

}
