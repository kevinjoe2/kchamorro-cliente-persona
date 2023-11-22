package com.kchamorro.clientepersona.entities;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    private String name;

    private String gender;

    @Column("date_birth")
    private LocalDate dateBirth;

    @Column("document_number")
    private String documentNumber;

    private String address;

    private String phone;

}
