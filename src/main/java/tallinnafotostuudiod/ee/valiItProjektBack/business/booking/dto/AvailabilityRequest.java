package tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability.Availability;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Availability}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityRequest implements Serializable {
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private String startHour;
    @NotNull
    private String endHour;
}