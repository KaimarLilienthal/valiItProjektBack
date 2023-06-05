package tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraBookingDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfoDto implements Serializable {
    @NotNull
    private LocalDate bookingDate;
    @NotNull
    private Integer houPrice;
    private Integer totalPrice;
    private List<HourDto> hours;
    private List<ExtraBookingDto> extraBookings;
}