package com.isilaev.userjob.backend.rest.mapper;

import com.isilaev.userjob.backend.persistence.entity.Company;
import com.isilaev.userjob.backend.rest.dto.CompanyDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    Company toEntity(CompanyDto companyDto);

    CompanyDto toDto(Company company);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company partialUpdate(CompanyDto companyDto, @MappingTarget Company company);
}