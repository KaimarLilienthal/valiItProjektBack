package tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto;

import lombok.Data;

@Data
public class MyStudiosDto {
    private Integer studioId;
    private String studioName;
    private String address;
    private String imageData;
}
