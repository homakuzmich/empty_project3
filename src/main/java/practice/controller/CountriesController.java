package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.service.CountriesService;
import practice.view.CountriesView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "CountriesController", description = "Управление справочником стран")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class CountriesController {
    private final CountriesService countriesService;

    @Autowired
    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    @ApiOperation(value = "Добавить новую страну проживания", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/countries")
    public void countriesAdd(@RequestBody CountriesView country){
        countriesService.add(country);
    }

    @ApiOperation(value = "Получить список всех стран", httpMethod = "GET")
    @GetMapping("/countries")
    public List<CountriesView> list(){
        return countriesService.countries();
    }
}
