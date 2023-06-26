package com.isilaev.userjob.backend.rest.dto;

import com.isilaev.userjob.backend.persistence.entity.User.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto implements Serializable {
    Long id;
    String familyName;
    String middleName;
    String firstName;
    Date birthday;
    Gender gender;
    int age;
    String description;
    Date created;
    Date updated;
    boolean isBlocked;
}