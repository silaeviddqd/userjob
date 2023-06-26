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
public class CompanyDto implements Serializable {
    Long id;
    String companyName;
    String description;
    Date created;
    Date updated;
    boolean isActivity;
}