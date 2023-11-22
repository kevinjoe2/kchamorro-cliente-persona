package com.kchamorro.clientepersona.utils.mappers;

import com.kchamorro.clientepersona.entities.CustomerEntity;
import com.kchamorro.clientepersona.vos.CustomerRequestVo;
import com.kchamorro.clientepersona.vos.CustomerResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerResponseVo toCustomerDto(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(CustomerRequestVo customerRequestDto);
    void putCustomerEntityFromDto(CustomerRequestVo requestDto, @MappingTarget CustomerEntity entity);

}
