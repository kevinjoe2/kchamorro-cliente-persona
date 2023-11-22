package com.neoris.clientepersona.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestVo {
    @NonNull
    private String name;
    @NonNull
    private String gender;
    @NonNull
    private LocalDate dateBirth;
    @NonNull
    private String documentNumber;
    @NonNull
    private String address;
    @NonNull
    private String phone;
    @NonNull
    private String password;
}
