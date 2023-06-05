package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.extrabooking;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import tallinnafotostuudiod.ee.valiItProjektBack.business.extra.dto.ExtraBookingDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExtraBookingMapper {

    @Mapping(source = "extra.name", target = "extraName")
    @Mapping(source = "price", target = "extraPrice")
    ExtraBookingDto toDto(ExtraBooking extraBooking);

 List <ExtraBookingDto> toDtos(List <ExtraBooking> extraBookings);

}