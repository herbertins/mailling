package br.com.messaging.controller.service;

import br.com.messaging.controller.dto.CondoResponseDTO;
import br.com.messaging.controller.dto.ResponseWrapper;
import br.com.messaging.domain.model.Condo;
import br.com.messaging.domain.service.CondoService;
import br.com.messaging.controller.dto.CondoRequestDTO;
import br.com.messaging.controller.mapper.CondoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CondoApplicationService {
    @Autowired
    private final CondoService service;
    @Autowired
    private final CondoMapper mapper;

    @Autowired
    public CondoApplicationService(CondoService service, CondoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public void create(final CondoRequestDTO request) {
        Condo condo = mapper.toDomain(request);
        service.create(condo);
    }

    public ResponseWrapper<List<CondoResponseDTO>> getAllCondos() {
        List<CondoResponseDTO> condoDtos = service.getCondos().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return new ResponseWrapper<>(condoDtos);
    }

    public ResponseWrapper<CondoResponseDTO>  getCondoDetails(Long id, boolean expand) {
        return new ResponseWrapper<>(expand ? mapper.toDto(service.findByIdWithAddress(id)) : mapper.toDto(service.findById(id)));
    }

}
