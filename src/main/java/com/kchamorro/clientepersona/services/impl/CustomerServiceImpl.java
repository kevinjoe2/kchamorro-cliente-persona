package com.kchamorro.clientepersona.services.impl;

import com.kchamorro.clientepersona.exceptions.ClientePersonaException;
import com.kchamorro.clientepersona.repos.CustomerRepo;
import com.kchamorro.clientepersona.services.CustomerService;
import com.kchamorro.clientepersona.utils.mappers.PatchGeneralMapper;
import com.kchamorro.clientepersona.vos.CustomerRequestVo;
import com.kchamorro.clientepersona.vos.CustomerResponseVo;
import com.kchamorro.clientepersona.entities.CustomerEntity;
import com.kchamorro.clientepersona.utils.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    private final PatchGeneralMapper patchGeneralMapper;

    @Override
    public Flux<CustomerResponseVo> findAll(){
        return customerRepo.findAll()
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<CustomerResponseVo> findById(UUID id) {
        return customerRepo.findById(id)
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<CustomerResponseVo> findByDocumentNumber(String documentNumber) {
        return customerRepo.findFirstByDocumentNumber(documentNumber)
                .switchIfEmpty(Mono.error(new ClientePersonaException("El cliente con dicho numero de cuenta no existe")))
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<UUID> findCustomerIdByDocumentNumber(String documentNumber) {
        return customerRepo.findFirstByDocumentNumber(documentNumber)
                .map(CustomerEntity::getId);
    }

    @Override
    public Mono<CustomerResponseVo> save(CustomerRequestVo customerRequestVo) {
        return customerRepo.findFirstByDocumentNumber(customerRequestVo.getDocumentNumber())
                .defaultIfEmpty(new CustomerEntity())
                .<CustomerRequestVo>handle((found, sink) -> {
                    if (Objects.isNull(found.getId())) {
                        sink.next(customerRequestVo);
                        return;
                    }
                    sink.error(new ClientePersonaException("El cliente ya existe."));
                })
                .map(cusReqVo -> CustomerEntity.builder()
                        .name(cusReqVo.getName())
                        .gender(cusReqVo.getGender())
                        .dateBirth(cusReqVo.getDateBirth())
                        .documentNumber(cusReqVo.getDocumentNumber())
                        .address(cusReqVo.getAddress())
                        .phone(cusReqVo.getPhone())
                        .password(cusReqVo.getPassword())
                        .state("ACT")
                        .build())
                .flatMap(customer -> customerRepo.save(customer)
                        .onErrorMap(errorMap -> new ClientePersonaException("Ocurrio un error inesperado al guardar el cliente", errorMap)))
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<CustomerResponseVo> update(UUID id, CustomerRequestVo customerRequestVo) {
        return Mono.error(new ClientePersonaException("No implementado"));
    }

    @Override
    public Mono<CustomerResponseVo> patch(UUID id, CustomerRequestVo customerRequestVo) {
        return customerRepo.findById(id)
                .map(customerEntity -> {
                    patchGeneralMapper.patchCustomerEntityFromFto(customerRequestVo, customerEntity);
                    return customerEntity;
                })
                .flatMap(customerRepo::save)
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return Mono.error(new ClientePersonaException("No implementado"));
    }

}
