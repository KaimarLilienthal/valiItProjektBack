package tallinnafotostuudiod.ee.valiItProjektBack.business.user;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto.NewUser;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping()
    public void addUser(@RequestBody NewUser newUser) {
        usersService.addUser(newUser);
    }
}
