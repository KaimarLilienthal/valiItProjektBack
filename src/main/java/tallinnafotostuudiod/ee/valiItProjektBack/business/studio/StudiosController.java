package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDto;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioDtoBasic;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioGeneralInfo;
import tallinnafotostuudiod.ee.valiItProjektBack.business.studio.dto.StudioPriceDto;
import tallinnafotostuudiod.ee.valiItProjektBack.infrastructure.error.ApiError;

import java.util.List;

@RestController
@RequestMapping("/studio")
public class StudiosController {
    @Resource
    private StudiosService studiosService;

    @GetMapping("/user-studios")
    @Operation(summary = "Kuvab listi kasutaja stuudiotest",
            description = "Tagastab info koos studioId ja studioName'ga ning imageId'ga jne.MUUDA ÕIGEKS!!!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi Stuudiot", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<StudioDto> findUserStudios(@RequestParam Integer userId) {
        List<StudioDto> userStudios = studiosService.findUserStudios(userId);
        return userStudios;
    }

    @PostMapping
    public void addStudio(@RequestBody StudioGeneralInfo studioGeneralInfo) {
        studiosService.addStudio(studioGeneralInfo);

    }

    @GetMapping("/user-studio")
    @Operation(summary = "Kuvab kasutaja stuudio",
            description = "Tagastab info koos ... MUUDA ÕIGEKS")
    public StudioGeneralInfo findUserStudio(@RequestParam Integer studioId) {
        StudioGeneralInfo userStudio = studiosService.findUserStudio(studioId);
        return userStudio;
    }

    @DeleteMapping
    @Operation(summary = "Kustutab kasutaja stuudio")
    public void deleteUserStudio(@RequestParam Integer studioId) {
        studiosService.deleteUserStudio(studioId);
    }


    @GetMapping("/all-selected-studios")
    @Operation(summary = "Kuvab kõik stuudiod valitud piirkonnas")
    public List<StudioDtoBasic> findAllAreaStudios(Integer districtId) {
        List<StudioDtoBasic> allAreaStudios = studiosService.findAllAreaStudios(districtId);
        return allAreaStudios;
    }


    @PutMapping
    @Operation(summary = "Muudab kasutaja stuudio",
            description = "Tagastab info koos ... MUUDA ÕIGEKS")
    public void changeUserStudio(@RequestParam Integer studioId, @RequestBody StudioGeneralInfo studioGeneralInfo) {
        studiosService.changeUserStudio(studioId, studioGeneralInfo);
    }

    @GetMapping("/price")
    @Operation(summary = "Kuvab stuudio tunnihinna")
    public StudioPriceDto findUserStudioHourPrice(@RequestParam Integer studioId) {
        StudioPriceDto userStudioHourPrice = studiosService.findUserStudioHourPrice(studioId);
        return userStudioHourPrice;
    }

    @PatchMapping("/price")
    @Operation(summary = "Salvestab üle ainult stuudio tunnihinna")
    public void editUserStudioHourPrice(@RequestParam Integer studioId, @RequestBody StudioPriceDto studioPriceDto){
        studiosService.editUserStudioHourPrice(studioId, studioPriceDto);

    }

}
