package com.neoris.clientepersona.services.impl;

import com.neoris.clientepersona.entities.CustomerEntity;
import com.neoris.clientepersona.repos.CustomerRepo;
import com.neoris.clientepersona.services.CustomerService;
import com.neoris.clientepersona.utils.mappers.CustomerMapper;
import com.neoris.clientepersona.utils.mappers.PatchGeneralMapper;
import com.neoris.clientepersona.vos.CustomerRequestVo;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<CustomerResponseVo> findById(Long id) {
        return customerRepo.findById(id)
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<CustomerResponseVo> findByDocumentNumber(String documentNumber) {
        return customerRepo.findFirstByDocumentNumber(documentNumber)
                .switchIfEmpty(Mono.error(new RuntimeException("El cliente con dicho numero de cuenta no existe")))
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<Long> findCustomerIdByDocumentNumber(String documentNumber) {
        return customerRepo.findFirstByDocumentNumber(documentNumber)
                .map(CustomerEntity::getId);
    }

    @Override
    public Mono<CustomerResponseVo> save(Mono<CustomerRequestVo> customerRequestDtoMono) {
        return customerRequestDtoMono
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
                .flatMap(customerRepo::save)
                .onErrorMap(errorMap -> new RuntimeException("Ocurrio un error inesperado al guardar el cliente", errorMap))
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<CustomerResponseVo> update(Long id, Mono<CustomerRequestVo> customerRequestDtoMono) {
        return Mono.error(new RuntimeException("No implementado"));
    }

    @Override
    public Mono<CustomerResponseVo> patch(Long id, Mono<CustomerRequestVo> customerRequestDtoMono) {
        return customerRequestDtoMono.flatMap(customerRequestDto -> customerRepo.findById(id)
                        .map(customerEntity -> {
                            patchGeneralMapper.patchCustomerEntityFromFto(customerRequestDto, customerEntity);
                            return customerEntity;
                        }))
                .flatMap(customerRepo::save)
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return Mono.error(new RuntimeException("No implementado"));
    }

}
