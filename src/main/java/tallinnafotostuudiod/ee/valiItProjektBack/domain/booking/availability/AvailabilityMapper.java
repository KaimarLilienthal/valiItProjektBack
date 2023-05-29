package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.availability;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityInfoDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.booking.dto.AvailabilityRequest;
import tallinnafotostuudiod.ee.valiItProjektBack.util.TimeUtil;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AvailabilityMapper {


    @Mapping(source = "startHour", target = "startHour", qualifiedByName = "timeStringToInteger")
    @Mapping(source = "endHour", target = "endHour", qualifiedByName = "timeStringToInteger")
    Availability toAvailability(AvailabilityRequest availabilityRequest);

    @Mapping(source = "startHour", target = "startHour", qualifiedByName = "integerToTimeString")
    @Mapping(source = "endHour", target = "endHour", qualifiedByName = "integerToTimeString")
    AvailabilityRequest toDto(Availability availability);

    List<AvailabilityRequest> toDtos(List<Availability> availabilities);

    @Mapping(source = "startHour", target = "startHour", qualifiedByName = "integerToTimeString")
    @Mapping(source = "endHour", target = "endHour", qualifiedByName = "integerToTimeString")
    @Mapping(source = "id", target = "availabilityId")
    AvailabilityInfoDto toAvailabilityDto(Availability availability);
    List<AvailabilityInfoDto> toAvailabilitiesDto(List<Availability> availabilities);

    @Named("timeStringToInteger")
    static Integer timeStringToInteger(String timeString) {

        return TimeUtil.timeStringToInteger(timeString);
    }

    @Named("integerToTimeString")
    static String integerToTimeString(Integer hour) {
        String string = TimeUtil.IntegerTotimeString(hour);
        return string;
    }





}