package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.*;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.image.Image;
import tallinnafotostuudiod.ee.valiItProjektBack.util.ImageUtil;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudioMapper {
    @Mapping(source = "id", target = "studioId")
    @Mapping(source = "name", target = "studioName")
    @Mapping(source = "address.street", target = "address")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    StudioDto toStudioDto(Studio studio);

    List<StudioDto> toStudioDtos(List<Studio> studios);

    @Mapping(ignore = true, target = "address")
    @Mapping(source = "imageData", target = "image", qualifiedByName = "imageDataToImage")
    @Mapping(source = "website", target = "url")
    @Mapping(source = "studioName", target = "name")
    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "0", target = "hourPrice")
    Studio toStudio(StudioGeneralInfo studioGeneralInfo);

    @Mapping(source = "address.street", target = "address")
    @Mapping(source = "district.id", target = "districtId")
    @Mapping(source = "name", target = "studioName")
    @Mapping(source = "address.latitude", target = "latitude")
    @Mapping(source = "address.longtitude", target = "longtitude")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "ownerUser.id", target = "ownerUserId")
    @Mapping(source = "url", target = "website")
    StudioGeneralInfo toUserStudioDto(Studio studio);

    @Mapping(source = "studioName", target = "name")
    @Mapping(source = "imageData", target = "image", qualifiedByName = "imageDataToImage")
    @Mapping(source = "website", target = "url")
    @Mapping(source = "address", target = "address.street")
    @Mapping(source = "longtitude", target = "address.longtitude")
    @Mapping(source = "latitude", target = "address.latitude")
    @Mapping(constant = "0", target = "hourPrice")
    @Mapping(constant = "A", target = "status")
    Studio partialUpdate(StudioGeneralInfo studioGeneralInfo, @MappingTarget Studio studio);

    Studio partialUpdate(StudioPriceDto studioPriceDto, @MappingTarget Studio studio);


    @Mapping(source = "id", target = "studioId")
    @Mapping(source = "image", target = "imageData", qualifiedByName = "imageToImageData")
    @Mapping(source = "name", target = "studioName")
    StudioDtoBasic toAllStudioDto(Studio studio);

    List<StudioDtoBasic> toAllStudioDtos(List<Studio> studios);

    StudioPriceDto toStudioPriceDto(Studio studio);

    @Named("imageToImageData")
    static String imageToImageData(Image image) {
        if (image == null) {
            return "";
        }
        return ImageUtil.byteArrayToBase64ImageData(image.getData());
    }

    @Named("imageDataToImage")
    static Image imageDataToImage(String imageData) {
        if (imageData.isEmpty()) {
            return null;
        }
        return new Image(ImageUtil.base64ImageDataToByteArray(imageData));
    }

}






