package tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra.StudioExtra;

import java.io.Serializable;

/**
 * DTO for {@link StudioExtra}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioExtraSimpleDto implements Serializable {
    private Integer studioId;
    private Integer extraId;
    @NotNull
    private Integer price;
}