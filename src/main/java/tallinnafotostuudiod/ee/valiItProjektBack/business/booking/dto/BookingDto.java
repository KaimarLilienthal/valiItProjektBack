package tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Booking}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto implements Serializable {
    private LocalDate date;
    private List<StudioExtraDto> studioExtras;
    private List<AvailabilityHourDto> selectedTimes;
}