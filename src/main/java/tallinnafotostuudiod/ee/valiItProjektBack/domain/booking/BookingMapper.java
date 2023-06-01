package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.BookingDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.BookingInfoDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    Booking toEntity(BookingDto bookingDto);

    @Mapping(source = "date", target = "bookingDate")
    @Mapping(source = "studio.hourPrice", target = "houPrice")
    BookingInfoDto toBookingDto(Booking booking);
}