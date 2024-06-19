package br.com.mailling.ui.controller;

import br.com.mailling.ui.dto.AddressDTO;
import br.com.mailling.application.service.ZipCodeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeController {

    @Autowired
    ZipCodeApplicationService service;

    @GetMapping("/{zipCode}")
    public ResponseEntity<AddressDTO> getAddressByZipCode(@PathVariable String zipCode) {
        Optional<AddressDTO> address = service.getAddressByZipCode(zipCode);
        return address.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
