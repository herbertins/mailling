package br.com.messaging.infra.api;

import br.com.messaging.controller.dto.AddressDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

//@Service
public class ExternalZipCodeService {

//    @Autowired
    private final RestTemplate restTemplate;

    private static final String EXTERNAL_API_URL = "https://viacep.com.br/ws/{cep}/json/";

//    @Autowired
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
