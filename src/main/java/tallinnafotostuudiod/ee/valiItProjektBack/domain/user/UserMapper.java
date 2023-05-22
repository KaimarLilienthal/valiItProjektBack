package tallinnafotostuudiod.ee.valiItProjektBack.domain.user;

import org.mapstruct.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.login.dto.LoginResponse;
import tallinnafotostuudiod.ee.valiItProjektBack.business.user.dto.NewUser;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);


    @Mapping(constant = "A", target = "status")
    User toUser(NewUser newUser);

}