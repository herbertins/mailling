package br.com.mailling.domain.service;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.repository.CondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondoService {

    private final CondoRepository repository;

    @Autowired
    public CondoService(CondoRepository repository) {
        this.repository = repository;
    }

    public void create(final Condo condo) {
        repository.save(condo);
    }

    public Iterable<Condo> getUsers() {
        return repository.findAll();
    }

}
