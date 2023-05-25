package tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;

import java.io.Serializable;

/**
 * DTO for {@link Extra}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtraExtendedDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;

}