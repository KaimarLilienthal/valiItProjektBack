package tallinnafotostuudiod.ee.valiItProjektBack.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    NO_LOCATION_FOUND("Ei leitud ühtegi pangaautomaati", 222),
    USERNAME_UNAVAILABLE("Sellise nimega kasutaja on juba süsteemis olemas", 444),
    LOCATION_UNAVAILABLE("Sellise nimega pangaautomaadi asukoht on juba süsteemis olemas", 333);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

}
