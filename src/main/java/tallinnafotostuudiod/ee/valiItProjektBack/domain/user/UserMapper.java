package tallinnafotostuudiod.ee.valiItProjektBack.domain.user;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.LoginResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")

    LoginResponse toLoginResponse(User user);


}