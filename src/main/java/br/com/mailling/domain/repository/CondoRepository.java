package br.com.mailling.domain.repository;

import br.com.mailling.infra.persistence.entity.CondoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CondoRepository extends CrudRepository<CondoEntity, Long> {
}
