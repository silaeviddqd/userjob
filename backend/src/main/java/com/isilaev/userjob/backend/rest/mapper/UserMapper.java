package com.isilaev.userjob.backend.rest.mapper;

import com.isilaev.userjob.backend.persistence.entity.User;
import com.isilaev.userjob.backend.rest.dto.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(UserDto companyDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}
