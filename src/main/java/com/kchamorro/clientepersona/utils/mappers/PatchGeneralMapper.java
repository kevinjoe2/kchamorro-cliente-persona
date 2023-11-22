package com.kchamorro.clientepersona.utils.mappers;

import com.kchamorro.clientepersona.entities.CustomerEntity;
import com.kchamorro.clientepersona.vos.CustomerRequestVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface PatchGeneralMapper {
    void patchCustomerEntityFromFto(CustomerRequestVo requestDto, @MappingTarget CustomerEntity entity);
}
