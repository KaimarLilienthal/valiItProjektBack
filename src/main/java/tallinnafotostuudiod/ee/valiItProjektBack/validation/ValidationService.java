package tallinnafotostuudiod.ee.valiItProjektBack.validation;

import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.User;
import tallinnafotostuudiod.ee.valiItProjektBack.infrastructure.exception.BusinessException;

import java.util.Optional;

import static tallinnafotostuudiod.ee.valiItProjektBack.validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static void validateCorrectUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
