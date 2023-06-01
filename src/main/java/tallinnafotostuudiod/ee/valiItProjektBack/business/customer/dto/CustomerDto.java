package tallinnafotostuudiod.ee.valiItProjektBack.business.customer.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer.Customer;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    @NotNull
    @Size(max = 100)
    private String customerName;
    @NotNull
    @Size(max = 8)
    private String customerPhone;
    @NotNull
    @Size(max = 100)
    private String customerEmail;
}