package tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

import java.io.Serializable;

/**
 * DTO for {@link Studio}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioPriceDto implements Serializable {
    @NotNull
    private Integer hourPrice;
}