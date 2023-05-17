package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking;

@Getter
@Setter
@Entity
@Table(name = "extra_booking")
public class ExtraBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "extra_id", nullable = false)
    private Extra extra;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

}