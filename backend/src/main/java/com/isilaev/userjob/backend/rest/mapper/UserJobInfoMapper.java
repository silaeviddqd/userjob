package com.isilaev.userjob.backend.rest.mapper;

import com.isilaev.userjob.backend.persistence.entity.UserJobInfo;
import com.isilaev.userjob.backend.rest.dto.UserJobInfoDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CompanyMapper.class, UserMapper.class})
public interface UserJobInfoMapper {
    UserJobInfo toEntity(UserJobInfoDto userJobInfoDto);

    UserJobInfoDto toDto(UserJobInfo userJobInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserJobInfo partialUpdate(UserJobInfoDto userJobInfoDto, @MappingTarget UserJobInfo userJobInfo);
}