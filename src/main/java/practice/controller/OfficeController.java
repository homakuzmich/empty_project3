package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.service.OfficeService;
import practice.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success" /*response = Long.class*/),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/office", consumes = "application/json", produces = "application/json")
    public void officeAdd(@RequestBody OfficeView office){
        officeService.addAndSave(office);
    }

    @ApiOperation(value = "Получить список всех офисов", httpMethod = "GET")
    @GetMapping("/office/list")
    public List<OfficeView> list(){
        return officeService.offices();
    }

    @ApiOperation(value = "Загрузить по id", httpMethod = "GET")
    @GetMapping("/office/{id}")
    public OfficeView loadById(OfficeView office, @PathVariable Long id) {
        return officeService.loadById(office, id);
    }

    @ApiOperation(value = "Обновить информацию об офисе", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(path = "/office/{id}/update", consumes = "application/json", produces = "application/json")
    public void officeUpdate(@RequestBody OfficeView office) throws Exception {
        officeService.update(office);
    }

}