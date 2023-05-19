package tallinnafotostuudiod.ee.valiItProjektBack.domain.studio.address;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioGeneralInfo;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    @Mapping(source = "address", target = "street")
    Address toAddress(StudioGeneralInfo studioGeneralInfo);

}