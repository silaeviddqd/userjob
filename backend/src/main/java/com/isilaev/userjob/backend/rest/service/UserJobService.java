package com.isilaev.userjob.backend.rest.service;

import com.isilaev.userjob.backend.persistence.entity.UserJobInfo;
import com.isilaev.userjob.backend.persistence.repository.UserJobInfoRepository;
import com.isilaev.userjob.backend.rest.dto.UserJobInfoDto;
import com.isilaev.userjob.backend.rest.exception.UserJobInfoNotFoundException;
import com.isilaev.userjob.backend.rest.mapper.UserJobInfoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserJobService {

    UserService userService;
    UserJobInfoMapper mapper;
    CompanyService companyService;
    UserJobInfoRepository userJobInfoRepository;

    public UserJobInfo createUserJob(UserJobInfoDto userJobInfoDto) {
        UserJobInfo userJobInfo = mapper.toEntity(userJobInfoDto);
        userJobInfo.setUser(userService.createUser(userJobInfoDto.getUser()));
        userJobInfo.setCompany(companyService.createCompany(userJobInfoDto.getCompany()));

        return userJobInfoRepository.save(userJobInfo);
    }

    public UserJobInfoDto updateUserJob(UserJobInfoDto userJobInfoDto) {
        long userJobInfoId = userJobInfoDto.getId();

        return userJobInfoRepository.findById(userJobInfoId)
                .map(userJobInfo -> mapper.partialUpdate(userJobInfoDto, userJobInfo))
                .map(mapper::toDto)
                .orElseThrow(UserJobInfoNotFoundException::new);
    }

    public UserJobInfoDto getUserJob(Long companyId, Long userId) {

        if (userId != null) {

            return userJobInfoRepository
                    .findByUserId(userId)
                    .map(mapper::toDto)
                    .orElseThrow(UserJobInfoNotFoundException::new);

        } else if (companyId != null) {

            return userJobInfoRepository
                    .findByCompanyId(companyId)
                    .map(mapper::toDto)
                    .orElseThrow(UserJobInfoNotFoundException::new);
        }

        throw new UserJobInfoNotFoundException();
    }
}
