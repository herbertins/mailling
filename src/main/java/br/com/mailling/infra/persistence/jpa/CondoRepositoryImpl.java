package br.com.mailling.infra.persistence.jpa;

import br.com.mailling.domain.repository.CondoRepository;
import br.com.mailling.infra.persistence.entity.CondoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondoRepositoryImpl extends JpaRepository<CondoEntity, Long>, CondoRepository {
}
