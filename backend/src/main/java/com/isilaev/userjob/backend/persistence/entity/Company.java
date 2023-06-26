package com.isilaev.userjob.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@Table(name = "company")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company extends AuditableEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String companyName;
    String description;
    boolean isActivity;
}
