package tallinnafotostuudiod.ee.valiItProjektBack.business.district.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district.District;

import java.io.Serializable;

/**
 * DTO for {@link District}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto implements Serializable {
    private Integer districtId;
    @NotNull
    @Size(max = 255)
    private String districtName;

}