package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotNull
    @Column(name = "start_hour", nullable = false)
    private Integer startHour;

    @NotNull
    @Column(name = "end_hour", nullable = false)
    private Integer endHour;

}