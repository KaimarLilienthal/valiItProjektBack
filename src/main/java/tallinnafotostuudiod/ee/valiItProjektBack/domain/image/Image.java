package tallinnafotostuudiod.ee.valiItProjektBack.domain.image;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

    public Image(byte[] data) {
        this.data = data;
    }

    public Image() {
    }

}