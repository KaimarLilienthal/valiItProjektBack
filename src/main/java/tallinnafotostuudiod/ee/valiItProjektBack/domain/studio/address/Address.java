package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "longtitude", precision = 2, scale = 6)
    private BigDecimal longtitude;

    @Column(name = "latitude", precision = 2, scale = 6)
    private BigDecimal latitude;

}