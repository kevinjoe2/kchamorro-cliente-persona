package com.neoris.clientepersona.utils.mappers;

import com.neoris.clientepersona.entities.CustomerEntity;
import com.neoris.clientepersona.vos.CustomerRequestVo;
import com.neoris.clientepersona.vos.CustomerResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerResponseVo toCustomerDto(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(CustomerRequestVo customerRequestDto);
    void putCustomerEntityFromDto(CustomerRequestVo requestDto, @MappingTarget CustomerEntity entity);

}
