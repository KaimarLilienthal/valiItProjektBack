package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.BookingDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {


    Booking toEntity(BookingDto bookingDto);
}