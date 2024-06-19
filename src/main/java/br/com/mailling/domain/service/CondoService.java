package br.com.mailling.domain.service;

import br.com.mailling.domain.model.Address;
import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.repository.CondoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondoService {

    @Autowired
    private final CondoRepository repository;

    @Autowired
    public CondoService(CondoRepository repository) {
        this.repository = repository;
    }

    public void create(final Condo domain) {
        repository.save(domain);
    }

    public Condo findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Condo not found"));
    }

    public Condo findByIdWithAddress(Long id) {
        return repository.findByIdWithAddress(id).orElse(null);
    }

    public List<Condo> getCondos() {
        List<Condo> condoList = repository.findAll();
        return condoList;
    }

}
