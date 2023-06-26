package com.isilaev.userjob.backend.rest.service;

import com.isilaev.userjob.backend.persistence.entity.Company;
import com.isilaev.userjob.backend.persistence.repository.CompanyRepository;
import com.isilaev.userjob.backend.rest.dto.CompanyDto;
import com.isilaev.userjob.backend.rest.exception.CompanyAlreadyExistException;
import com.isilaev.userjob.backend.rest.mapper.CompanyMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompanyService {

    CompanyMapper mapper;
    CompanyRepository companyRepository;

    public Company createCompany(CompanyDto companyDto) {
        Long companyId = companyDto.getId();

        if (companyId != null) {
            Company company = companyRepository
                    .findById(companyId)
                    .orElse(null);

            if (company != null) {
                throw new CompanyAlreadyExistException();
            }
        }

        return companyRepository.save(mapper.toEntity(companyDto));
    }
}
