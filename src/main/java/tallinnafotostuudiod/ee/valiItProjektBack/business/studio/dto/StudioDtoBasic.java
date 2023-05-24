package tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class StudioDtoBasic implements Serializable {
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private String imageData;
}