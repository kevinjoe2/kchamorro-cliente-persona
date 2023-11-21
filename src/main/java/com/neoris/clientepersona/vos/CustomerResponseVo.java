package com.neoris.clientepersona.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseVo {
    private Long id;
    private String name;
    private String gender;
    private LocalDate dateBirth;
    private String documentNumber;
    private String address;
    private String phone;
    private String customerNumber;
    private String password;
    private String state;
}
