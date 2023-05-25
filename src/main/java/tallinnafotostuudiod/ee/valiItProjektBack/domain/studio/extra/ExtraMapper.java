package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.extra;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraExtendedDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraMapper {


    ExtraExtendedDto toExtraDto(Extra extra);

    List<ExtraExtendedDto> toExtrasDto(List<Extra> extras);


}