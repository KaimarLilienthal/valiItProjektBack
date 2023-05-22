package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.district;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import tallinnafotostuudiod.ee.valiItProjektBack.business.district.dto.DistrictDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DistrictMapper {

    @Mapping(source = "id", target = "districtId")
    @Mapping(source = "name", target = "districtName")
    DistrictDto toDistrictDto(District district);

    List<DistrictDto> toDistrictsDto(List<District> districts);
}