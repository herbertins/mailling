package br.com.mailling.application.service;

import br.com.mailling.application.dto.Request;
import br.com.mailling.application.dto.Response;
import br.com.mailling.application.mappers.CondoMapper;
import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.service.CondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CondoApplicationService {
    private final CondoService service;
    private final CondoMapper mapper;

    @Autowired
    public CondoApplicationService(CondoService service, CondoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public void create(final Request request) {
        service.create(mapper.toDomain(request));
    }

    public List<Response> getUsers() {
        Iterable<Condo> iterable = service.getUsers();
        return mapper.toResponse(StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList()));
    }

}
