package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.service.OrganizationService;
import practice.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController", description = "Управление информацией о компаниях")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Добавить новую компанию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Long.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/organization", consumes = "application/json", produces = "application/json")
    public void organizationAdd(@RequestBody OrganizationView organization){
        organizationService.addAndSave(organization);
    }

    @ApiOperation(value = "Получить список всех компаний", httpMethod = "GET")
    @GetMapping("/organization/list")
    public List<OrganizationView> list(){
        return organizationService.organizations();
    }

    @ApiOperation(value = "Загрузить по id", httpMethod = "GET")
    @GetMapping("/organization/{id}")
    public OrganizationView loadById(OrganizationView organization, @PathVariable Long id) {
        return organizationService.loadById(organization, id);
    }

    @ApiOperation(value = "Обновить информацию об организации", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/organization/{id}/update", consumes = "application/json", produces = "application/json")
    public void organizationUpdate(@RequestBody OrganizationView organization) throws Exception {
        organizationService.update(organization);
    }
}