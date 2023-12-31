package com.kchamorro.clientepersona.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "customers")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends PersonEntity {

    @Id
    public UUID id;

    private String password;

    private String state;

    @Builder
    public CustomerEntity(String name, String gender, LocalDate dateBirth, String documentNumber, String address,
                          String phone, UUID id, String password, String state) {
        super(name, gender, dateBirth, documentNumber, address, phone);
        this.id = id;
        this.password = password;
        this.state = state;
    }
}
