package br.com.mailling.domain.repository;

import br.com.mailling.domain.model.Address;
import br.com.mailling.domain.model.Condo;

import java.util.List;
import java.util.Optional;

public interface CondoRepository {
    Optional<Condo> findById(Long id);

    Optional<Address> findAddressById(Long id);

    Optional<Condo> findByIdWithAddress(Long id);

    List<Condo> findAll();

    void save(Condo condo);
}
