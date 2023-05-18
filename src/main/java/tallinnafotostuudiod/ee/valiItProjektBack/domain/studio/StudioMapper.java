package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.image.Image;
import tallinnafotostuudiod.ee.valiItProjektBack.util.ImageUtil;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudioMapper {
    @Mapping(source = "id",target = "studioId")
    @Mapping(source = "name",target = "studioName")
    @Mapping(source = "address.street",target = "address")
    @Mapping(source = "image",target = "imageData",qualifiedByName = "imageToImageData")
    StudioDto toStudioDto(Studio studio);


   List<StudioDto> toStudioDtos(List<Studio> studios);

    @Named("imageToImageData")
    static String imageToImageData(Image image){
        if(image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }


}