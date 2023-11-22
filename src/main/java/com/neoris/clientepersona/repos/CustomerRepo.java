package com.neoris.clientepersona.repos;

import com.neoris.clientepersona.entities.CustomerEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface CustomerRepo extends ReactiveCrudRepository<CustomerEntity, UUID> {
    Mono<CustomerEntity> findFirstByDocumentNumber(String documentNumber);
}
