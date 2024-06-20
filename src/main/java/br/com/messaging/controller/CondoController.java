package br.com.messaging.controller;

import br.com.messaging.controller.dto.CondoRequestDTO;
import br.com.messaging.controller.dto.CondoResponseDTO;
import br.com.messaging.controller.dto.ResponseWrapper;
import br.com.messaging.controller.service.CondoApplicationService;
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
    private ResponseEntity add(@RequestBody CondoRequestDTO request) {
        service.create(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<List<CondoResponseDTO>>> getAllCondos() {
        ResponseWrapper<List<CondoResponseDTO>> response = service.getAllCondos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseWrapper<CondoResponseDTO>> getCondoDetails(@PathVariable Long id,
                                                                              @RequestParam(value = "expand", defaultValue = "false") boolean expand) {
        ResponseWrapper<CondoResponseDTO> condoResponseDto = service.getCondoDetails(id, expand);
        return new ResponseEntity<>(condoResponseDto, HttpStatus.OK);

    }

}
