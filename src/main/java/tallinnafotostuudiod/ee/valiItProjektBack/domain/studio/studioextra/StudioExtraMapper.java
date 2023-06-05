package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.studioextra;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.StudioExtraSimpleDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudioExtraMapper {

  @Mapping(source = "extra.id", target = "extraId")
  @Mapping(source = "extra.name", target = "extraName")
  @Mapping(source = "price", target = "extraPrice")
  StudioExtraDto toDto(StudioExtra studioExtra);

  List<StudioExtraDto> toExtrasDto(List<StudioExtra> studioExtras);

  StudioExtra toStudioExtraEntity(StudioExtraSimpleDto studioExtraSimpleDto);

}