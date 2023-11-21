package com.neoris.clientepersona.services.impl;

import com.neoris.clientepersona.entities.CustomerEntity;
import com.neoris.clientepersona.repos.CustomerRepo;
import com.neoris.clientepersona.utils.mappers.CustomerMapper;
import com.neoris.clientepersona.utils.mappers.PatchGeneralMapper;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private PatchGeneralMapper patchGeneralMapper;

    @InjectMocks
    private CustomerServiceImpl service;

    @Test
    void findAll() {

        Flux<CustomerEntity> list1 = Flux.just(CustomerEntity.builder()
                        .id(1L)
                        .name("name")
                        .gender("gender")
                        .dateBirth(LocalDate.now())
                        .documentNumber("documentNumber")
                        .address("address")
                        .phone("phone")
                        .customerNumber("customerNumber")
                        .password("password")
                        .state("ACT")
                .build());
        Mockito.when(customerRepo.findAll()).thenReturn(list1);
        service.findAll().subscribe(Assertions::assertNotNull);
    }
}