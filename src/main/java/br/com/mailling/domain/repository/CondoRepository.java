package br.com.mailling.domain.repository;

import br.com.mailling.domain.model.Condo;
import org.springframework.data.repository.CrudRepository;

public interface CondoRepository extends CrudRepository<Condo, Long> {
}
