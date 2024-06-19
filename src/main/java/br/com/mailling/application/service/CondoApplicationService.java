package br.com.mailling.application.service;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.service.CondoService;
import br.com.mailling.ui.dto.CondoDto;
import br.com.mailling.ui.dto.Request;
import br.com.mailling.ui.mapper.CondoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void create(final Request request) {
        Condo condo = mapper.toDomain(request);
        service.create(condo);
    }

    public List<CondoDto> getUsers() {
        List<Condo> condoList = service.getCondos();
        return mapper.toDto(condoList);
    }

    public CondoDto getCondoDetails(Long id, boolean expand) {
        return expand ? mapper.toDto(service.findByIdWithAddress(id)) : mapper.toDto(service.findById(id));
    }

}
