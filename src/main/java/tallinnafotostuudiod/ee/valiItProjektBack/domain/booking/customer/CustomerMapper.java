package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.customer.dto.CustomerDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(source = "customerName", target = "name")
    @Mapping(source = "customerPhone", target = "phone")
    @Mapping(source = "customerEmail", target = "email")
    Customer toEntity(CustomerDto customerDto);

}