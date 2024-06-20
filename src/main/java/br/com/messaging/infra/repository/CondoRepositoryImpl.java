package br.com.messaging.infra.repository;

import br.com.messaging.domain.exception.DataAccessException;
import br.com.messaging.domain.exception.NotFoundException;
import br.com.messaging.domain.model.Condo;
import br.com.messaging.domain.repository.CondoRepository;
import br.com.messaging.infra.mappers.CondoEntityMapper;
import br.com.messaging.infra.persistence.entities.CondoEntity;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CondoRepositoryImpl implements CondoRepository {

    @Autowired
    private final EntityManager entityManager;

    @Autowired
    private final CondoEntityMapper condoEntityMapper;

    @Autowired
    public CondoRepositoryImpl(EntityManager entityManager, CondoEntityMapper condoEntityMapper) {
        this.entityManager = entityManager;
        this.condoEntityMapper = condoEntityMapper;
    }

    @Override
    public Optional<Condo> findById(Long id) {
        try {
            CondoEntity entity = entityManager.find(CondoEntity.class, id);
            return Optional.ofNullable(condoEntityMapper.toDomain(entity));
        } catch (Exception e) {
            throw new DataAccessException("Error finding Condo by ID", e);
        }
    }

    public Optional<Condo> findByIdWithAddress(Long id) {
        try {
            EntityGraph<?> entityGraph = entityManager.getEntityGraph("CondoEntity.withAddress");
            TypedQuery<CondoEntity> query = entityManager.createQuery("SELECT c FROM CondoEntity c WHERE c.id = :id", CondoEntity.class);
            query.setParameter("id", id);
            query.setHint("jakarta.persistence.fetchgraph", entityGraph);
            CondoEntity entity = query.getSingleResult();
            return Optional.ofNullable(condoEntityMapper.toDomain(entity));
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new DataAccessException("Error finding Condo by ID with address", e);
        }
    }

    @Override
    public List<Condo> findAll() {
        try {
            TypedQuery<CondoEntity> query = entityManager.createQuery("SELECT c FROM CondoEntity c", CondoEntity.class);
            List<CondoEntity> entities = query.getResultList();
            return entities.stream().map(condoEntityMapper::toDomain).collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException("Error finding all Condos");
        }
    }

    @Override
    @Transactional
    public void save(Condo condo) {
        try {
            CondoEntity entity = condoEntityMapper.toEntity(condo);
            entityManager.persist(entity);
        } catch (Exception e) {
            throw new DataAccessException("Error saving Condo", e);
        }
    }
}
