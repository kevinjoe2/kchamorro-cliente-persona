package com.kchamorro.clientepersona.services.impl;

import com.kchamorro.clientepersona.utils.mappers.PatchGeneralMapper;
import com.kchamorro.clientepersona.entities.CustomerEntity;
import com.kchamorro.clientepersona.repos.CustomerRepo;
import com.kchamorro.clientepersona.utils.mappers.CustomerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;

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
                        .id(UUID.randomUUID())
                        .name("name")
                        .gender("gender")
                        .dateBirth(LocalDate.now())
                        .documentNumber("documentNumber")
                        .address("address")
                        .phone("phone")
                        .password("password")
                        .state("ACT")
                .build());
        Mockito.when(customerRepo.findAll()).thenReturn(list1);
        service.findAll().subscribe(Assertions::assertNotNull);
    }
}