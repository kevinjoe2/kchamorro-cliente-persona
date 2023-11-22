package com.neoris.clientepersona.services;

import com.neoris.clientepersona.vos.CustomerRequestVo;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerService {

    Flux<CustomerResponseVo> findAll();
    Mono<CustomerResponseVo> findById(UUID id);
    Mono<CustomerResponseVo> findByDocumentNumber(String documentNumber);
    Mono<UUID> findCustomerIdByDocumentNumber(String documentNumber);
    Mono<CustomerResponseVo> save(CustomerRequestVo customerRequestDtoMono);
    Mono<CustomerResponseVo> update(UUID id, CustomerRequestVo customerRequestDtoMono);
    Mono<CustomerResponseVo> patch(UUID id, CustomerRequestVo customerRequestDtoMono);
    Mono<Void> delete(UUID id);

}
