package com.isilaev.userjob.backend.rest.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserJobInfoDto implements Serializable {
    Long id;
    CompanyDto company;
    UserDto user;
    String description;
    boolean isActivity;
    Date created;
    Date updated;
}