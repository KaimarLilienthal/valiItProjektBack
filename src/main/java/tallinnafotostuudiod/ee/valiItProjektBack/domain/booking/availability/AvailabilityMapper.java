package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;
import tallinnafotostuudiod.ee.valiItProjektBack.util.TimeUtil;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AvailabilityMapper {


    @Mapping(source = "startHour", target = "startHour", qualifiedByName = "timeStringToInteger")
    @Mapping(source = "endHour", target = "endHour", qualifiedByName = "timeStringToInteger")
    Availability toAvailability(AvailabilityRequest availabilityRequest);


    @Named("timeStringToInteger")
    static Integer timeStringToInteger(String timeString) {
        return TimeUtil.timeStringToInteger(timeString);
    }


}