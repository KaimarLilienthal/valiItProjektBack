package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioGeneralInfo;
import tallinnafotostuudiod.ee.valiItProjektBack.infrastructure.error.ApiError;

import java.util.List;

@RestController
@RequestMapping("/studios")
public class StudiosController {
    @Resource
    private StudiosService studiosService;


    @GetMapping("/user-studios")
    @Operation(summary = "Kuvab listi kasutaja stuudiotest",
            description = "Tagastab info koos studioId ja studioName'ga ning imageId'ga jne.MUUDA ÕIGEKS!!!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi Stuudiot", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<StudioDto> findUserStudios(@RequestParam Integer userId){
        List<StudioDto> userStudios = studiosService.findUserStudios(userId);
        return userStudios;
    }
    @PostMapping("/general")
    public void addStudio(@RequestBody StudioGeneralInfo studioGeneralInfo){
        studiosService.addStudio(studioGeneralInfo);

    }

    @GetMapping("/user-studio")
    @Operation(summary = "Kuvab muutmiseks kasutaja stuudio",
            description = "Tagastab info koos ... MUUDA ÕIGEKS")
    public StudioGeneralInfo editUserStudio(@RequestParam Integer studioId){
        StudioGeneralInfo userStudio = studiosService.editUserStudio(studioId);
        return userStudio;
    }
}
