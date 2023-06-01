package tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.Availability;

import java.io.Serializable;

/**
 * DTO for {@link Availability}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityHourDto implements Serializable {
    private Integer startHour;
    private Boolean isSelected = false;

    public AvailabilityHourDto(Integer startHour) {
        this.startHour = startHour;
    }
}