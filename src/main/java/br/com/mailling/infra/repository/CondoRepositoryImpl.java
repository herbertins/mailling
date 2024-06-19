package br.com.mailling.infra.repository;

import br.com.mailling.domain.model.Address;
import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.repository.CondoRepository;
import br.com.mailling.infra.mapper.AddressMapper;
import br.com.mailling.infra.mapper.CondoEntityMapper;
import br.com.mailling.infra.persistence.entity.AddressEntity;
import br.com.mailling.infra.persistence.entity.CondoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityGraph;
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
    private final AddressMapper addressMapper;

    @Autowired
    public CondoRepositoryImpl(EntityManager entityManager, CondoEntityMapper condoEntityMapper, AddressMapper addressMapper) {
        this.entityManager = entityManager;
        this.condoEntityMapper = condoEntityMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public Optional<Condo> findById(Long id) {
        CondoEntity entity = entityManager.find(CondoEntity.class, id);
        return Optional.ofNullable(condoEntityMapper.toDomain(entity));
    }

    public Optional<Condo> findByIdWithAddress(Long id) {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("CondoEntity.withAddress");
        TypedQuery<CondoEntity> query = entityManager.createQuery("SELECT c FROM CondoEntity c WHERE c.id = :id", CondoEntity.class);
        query.setParameter("id", id);
        query.setHint("jakarta.persistence.fetchgraph", entityGraph);
        CondoEntity entity = query.getSingleResult();
        return Optional.ofNullable(condoEntityMapper.toDomain(entity));
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        AddressEntity entity = entityManager.createQuery("SELECT c.address FROM CondoEntity c WHERE c.id = :id", AddressEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        return Optional.ofNullable(addressMapper.toDomain(entity));
    }

    @Override
    public List<Condo> findAll() {
        TypedQuery<CondoEntity> query = entityManager.createQuery("SELECT c FROM CondoEntity c", CondoEntity.class);
        List<CondoEntity> entities = query.getResultList();
        return entities.stream().map(condoEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(Condo condo) {
        CondoEntity entity = condoEntityMapper.toEntity(condo);
        entityManager.persist(entity);
    }
}
