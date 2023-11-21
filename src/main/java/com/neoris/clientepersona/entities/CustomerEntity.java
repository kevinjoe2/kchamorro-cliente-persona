package com.neoris.clientepersona.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "customers")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends PersonEntity {

    @Id
    public Long id;

    @Column("customer_number")
    private String customerNumber;

    private String password;

    private String state;

    @Builder
    public CustomerEntity(String name, String gender, LocalDate dateBirth, String documentNumber, String address,
                          String phone, Long id, String customerNumber, String password, String state) {
        super(name, gender, dateBirth, documentNumber, address, phone);
        this.id = id;
        this.customerNumber = customerNumber;
        this.password = password;
        this.state = state;
    }
}
