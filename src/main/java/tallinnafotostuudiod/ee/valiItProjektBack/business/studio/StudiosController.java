package tallinnafotostuudiod.ee.valiItProjektBack.business.studio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tallinnafotostuudiod.ee.valiItProjektBack.infrastructure.error.ApiError;

@RestController
public class StudiosController {
    @Resource
    private StudiosService studiosService;


//    @GetMapping("/my-studios")
//    @Operation(summary = "Kuvab listi minu stuudiotest",
//            description = "Tagastab info koos studioId ja studioName'ga ning imageId'ga")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi Stuudiot", content = @Content(schema = @Schema(implementation = ApiError.class)))})

//    public List<> getMyStudios()
}