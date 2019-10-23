package practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.service.DocsService;
import practice.view.DocsView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "DocsController", description = "Управление информацией о документах")
@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DocsController {
    private final DocsService docsService;

    @Autowired
    public DocsController(DocsService docsService) {
        this.docsService = docsService;
    }

    @ApiOperation(value = "Добавить новый документ", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/docs")
    public void docsAdd(@RequestBody DocsView document){
        docsService.add(document);
    }


    @ApiOperation(value = "Получить список всех документов", httpMethod = "GET")
    @GetMapping("/docs")
    public List<DocsView> list(){
        return docsService.documents();
    }
}
