package br.com.mailling.infra.api;

import br.com.mailling.application.dto.AddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ExternalZipCodeService {

    private final RestTemplate restTemplate;

    private static final String EXTERNAL_API_URL = "https://viacep.com.br/ws/{cep}/json/";

    public ExternalZipCodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<AddressDTO> fetchCep(String cep) {
        try {
            AddressDTO response = restTemplate.getForObject(EXTERNAL_API_URL, AddressDTO.class, cep);
            return Optional.ofNullable(response);
        } catch (Exception e) {
            return Optional.empty();
        }

    }

}
