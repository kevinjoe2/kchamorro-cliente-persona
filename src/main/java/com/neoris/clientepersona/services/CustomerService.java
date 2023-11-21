package com.neoris.clientepersona.services;

import com.neoris.clientepersona.vos.CustomerRequestVo;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerService {

    Flux<CustomerResponseVo> findAll();
    Mono<CustomerResponseVo> findById(Long id);
    Mono<CustomerResponseVo> findByDocumentNumber(String documentNumber);
    Mono<Long> findCustomerIdByDocumentNumber(String documentNumber);
    Mono<CustomerResponseVo> save(Mono<CustomerRequestVo> customerRequestDtoMono);
    Mono<CustomerResponseVo> update(Long id, Mono<CustomerRequestVo> customerRequestDtoMono);
    Mono<CustomerResponseVo> patch(Long id, Mono<CustomerRequestVo> customerRequestDtoMono);
    Mono<Void> delete(Long id);

}
