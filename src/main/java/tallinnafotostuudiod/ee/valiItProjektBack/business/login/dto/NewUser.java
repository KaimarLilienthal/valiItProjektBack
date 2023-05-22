package tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.user.User;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUser implements Serializable {
    @NotNull
    @Size(max = 255)
    private String username;
    @NotNull
    @Size(max = 255)
    private String password;
    @NotNull
    @Size(max = 255)
    private String email;
}