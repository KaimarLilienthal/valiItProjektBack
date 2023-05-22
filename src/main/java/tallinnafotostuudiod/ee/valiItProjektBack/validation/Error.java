package tallinnafotostuudiod.ee.valiItProjektBack.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
    USERNAME_UNAVAILABLE("Sellise nimega kasutaja on juba süsteemis olemas", 444),
    URL_UNAVAILABLE("Sellise web aadressiga stuudio on juba süsteemis olemas", 555);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
