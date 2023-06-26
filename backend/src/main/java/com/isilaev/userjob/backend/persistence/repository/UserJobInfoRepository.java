package com.isilaev.userjob.backend.persistence.repository;

import com.isilaev.userjob.backend.persistence.entity.UserJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserJobInfoRepository extends JpaRepository<UserJobInfo, Long> {
    Optional<UserJobInfo> findByCompanyId(long id);
    Optional<UserJobInfo> findByUserId(long id);
}
