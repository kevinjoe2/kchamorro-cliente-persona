package com.neoris.clientepersona.utils.mappers;

import com.neoris.clientepersona.entities.CustomerEntity;
import com.neoris.clientepersona.vos.CustomerRequestVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface PatchGeneralMapper {
    void patchCustomerEntityFromFto(CustomerRequestVo requestDto, @MappingTarget CustomerEntity entity);
}
