package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.hour;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.HourDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HourMapper {


    @Mapping(source = "start",target = "startHour")
    HourDto toDto(Hour hour);

    List<HourDto> toHoursDto(List<Hour> hours);

}