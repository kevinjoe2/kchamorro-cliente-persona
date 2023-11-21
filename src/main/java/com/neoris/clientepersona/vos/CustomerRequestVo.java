package com.neoris.clientepersona.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestVo {
    private String name;
    private String gender;
    private LocalDate dateBirth;
    private String documentNumber;
    private String address;
    private String phone;
    private String password;
}
