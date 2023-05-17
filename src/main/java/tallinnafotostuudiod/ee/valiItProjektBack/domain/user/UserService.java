package tallinnafotostuudiod.ee.valiItProjektBack.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.validation.ValidationService;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> userOptional = userRepository.findUserBy(username, password, "A");
        ValidationService.validateCorrectUserCredentials(userOptional);
        return userOptional.get();

    }
}
