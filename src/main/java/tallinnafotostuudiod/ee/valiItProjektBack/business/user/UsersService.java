package tallinnafotostuudiod.ee.valiItProjektBack.business.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto.NewUser;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.User;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.UserMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.UserService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.role.Role;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.role.RoleService;

@Service
public class UsersService {
    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    public void addUser(NewUser newUser) {

        // userService alla validatsioon, vaatad andmebaasist kas kasutajanimi on vaba, kui mitte siis visata viga (ValidatsionService)
        userService.findExistsUserBy(newUser.getUsername());

        //  ME KUNAGI EI MÄPI FOREING key väärtusi ENTITITELE,
        //  vaid kas otsime nende id'de abil üllesse vastate tabelite objektid/read
        //  või siis tekitame uued objektid/read
        //
        //
        //  mapime 'user' objektile/reale nii palju andmeid kui saame
        User user = userMapper.toUser(newUser);

        //  otsime roleId abil andmebaasist ülesse 'role' objekti/rea
        Role role = roleService.findUserRoleStudio();

        user.setRole(role);
        userService.addUser(user);

    }
}
