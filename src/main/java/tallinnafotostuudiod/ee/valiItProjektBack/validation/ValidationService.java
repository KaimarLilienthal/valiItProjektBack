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


    public static void validateUserIsAvailable(boolean exists) {
        if (exists) {
            throw new BusinessException(Error.USERNAME_UNAVAILABLE.getMessage(), Error.USERNAME_UNAVAILABLE.getErrorCode());
        }

    }

    public static void validateUrlIsAvailable(boolean urlExists){
        if (urlExists) {
            throw new BusinessException(Error.URL_UNAVAILABLE.getMessage(), Error.URL_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateExtraIsAvailable(boolean extraExists){
        if (extraExists) {
            throw new BusinessException(Error.EXTRA_UNAVAILABLE.getMessage(), Error.EXTRA_UNAVAILABLE.getErrorCode());
        }
    }

    public static void validateStartDateIsAvailable(boolean availabilityExists) {
        if (availabilityExists) {
            throw new BusinessException(Error.STARTDATE_UNAVAILABLE.getMessage(), Error.STARTDATE_UNAVAILABLE.getErrorCode());
        }
    }

}
