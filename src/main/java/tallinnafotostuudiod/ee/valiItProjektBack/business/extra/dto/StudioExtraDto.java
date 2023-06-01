package tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class StudioExtraDto implements Serializable {
    private Integer extraId;
    private String extraName;
    private Integer extraPrice;
    private Boolean isSelected = false;
}