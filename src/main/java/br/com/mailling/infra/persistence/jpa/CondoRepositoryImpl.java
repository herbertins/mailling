package br.com.mailling.infra.persistence.jpa;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.repository.CondoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondoRepositoryImpl extends JpaRepository<Condo, Long>, CondoRepository {
}
