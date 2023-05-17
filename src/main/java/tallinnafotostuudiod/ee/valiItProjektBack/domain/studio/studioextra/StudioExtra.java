package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra.Extra;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.Studio;

@Getter
@Setter
@Entity
@Table(name = "studio_extra")
public class StudioExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "extra_id", nullable = false)
    private Extra extra;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

}