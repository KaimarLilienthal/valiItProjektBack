package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking;

@Getter
@Setter
@Entity
@Table(name = "hour")
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @NotNull
    @Column(name = "start", nullable = false)
    private Integer start;

}