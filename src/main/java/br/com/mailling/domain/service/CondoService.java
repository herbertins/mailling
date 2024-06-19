package br.com.mailling.domain.service;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.repository.CondoRepository;
import br.com.mailling.infra.mapper.CondoMapper;
import br.com.mailling.infra.persistence.entity.CondoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CondoService {

    private final CondoRepository repository;
    private final CondoMapper mapper;

    @Autowired
    public CondoService(CondoRepository repository, CondoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create(final Condo condo) {
        CondoEntity entity = mapper.toEntity(condo);
        repository.save(entity);
    }

    public List<Condo> getCondos() {
        Iterable<CondoEntity> iterable = repository.findAll();
        return mapper.toDomain(StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList()));
    }

}
