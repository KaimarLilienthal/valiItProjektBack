package tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Studio}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudioGeneralInfo implements Serializable {
    private Integer ownerUserId;
    @NotNull
    @Size(max = 255)
    private String studioName;
    @NotNull
    @Size(max = 255)
    private String website;
    @NotNull
    private String imageData;
    private Integer districtId;
    @NotNull
    @Size(max = 255)
    private String address;
    private BigDecimal longtitude;
    private BigDecimal latitude;
}