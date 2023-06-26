package com.isilaev.userjob.backend.persistence.repository;

import com.isilaev.userjob.backend.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
