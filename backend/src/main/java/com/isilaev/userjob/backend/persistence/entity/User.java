package com.isilaev.userjob.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AuditableEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String familyName;
    String middleName;
    String firstName;
    Date birthday;
    @Enumerated(EnumType.ORDINAL)
    Gender gender;
    int age;
    String description;
    boolean isBlocked;

    public enum Gender {
        MALE,
        FEMALE
    }
}
