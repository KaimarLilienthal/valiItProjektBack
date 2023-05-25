package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.w3c.dom.stylesheets.LinkStyle;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ExtraDto toExtraDto(Extra extra);

    List<ExtraDto> toExtrasDto(List<Extra> extras);


}