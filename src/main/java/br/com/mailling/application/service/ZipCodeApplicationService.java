package br.com.mailling.application.service;

import br.com.mailling.ui.dto.AddressDTO;
import br.com.mailling.infra.api.ExternalZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ZipCodeApplicationService {

    private final ExternalZipCodeService service;

    @Autowired
    public ZipCodeApplicationService(ExternalZipCodeService service) {
        this.service = service;
    }

    public Optional<AddressDTO> getAddressByZipCode(String zipCode) {
        return service.fetchCep(zipCode);
    }

}
