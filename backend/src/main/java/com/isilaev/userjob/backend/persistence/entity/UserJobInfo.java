package com.isilaev.userjob.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "user_job_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserJobInfo extends AuditableEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @OneToOne
    @JoinColumn(name = "company_id")
    Company company;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    String description;
    boolean isActivity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserJobInfo that = (UserJobInfo) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
