package br.com.messaging.domain.repository;

import br.com.messaging.domain.model.Condo;

import java.util.List;
import java.util.Optional;

public interface CondoRepository {
    Optional<Condo> findById(Long id);

    Optional<Condo> findByIdWithAddress(Long id);

    List<Condo> findAll();

    void save(Condo condo);
}
