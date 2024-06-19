package br.com.mailling.ui.controller;

import br.com.mailling.ui.dto.Request;
import br.com.mailling.ui.dto.CondoDto;
import br.com.mailling.application.service.CondoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condominiums")
public class CondoController {

    @Autowired
    CondoApplicationService service;

    @PostMapping
    private ResponseEntity add(@RequestBody Request request) {
        service.create(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<CondoDto>> list() {
        List<CondoDto> condoList = service.getUsers();
        return new ResponseEntity<>(condoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CondoDto> getCondoDetails(@PathVariable Long id, @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        CondoDto condoDto = service.getCondoDetails(id,expand);
        return new ResponseEntity<>(condoDto, HttpStatus.OK);

    }

}
