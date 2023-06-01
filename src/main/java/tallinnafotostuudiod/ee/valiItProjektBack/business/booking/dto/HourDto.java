package tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour.Hour;

import java.io.Serializable;

/**
 * DTO for {@link Hour}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourDto implements Serializable {
    @NotNull
    private Integer startHour;
}