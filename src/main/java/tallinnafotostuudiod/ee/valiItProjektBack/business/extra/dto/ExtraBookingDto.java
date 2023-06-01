package tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtraBookingDto {
    private String extraName;
    private Integer extraPrice;
}
