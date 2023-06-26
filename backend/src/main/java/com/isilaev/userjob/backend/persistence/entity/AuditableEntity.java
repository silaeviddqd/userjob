package com.isilaev.userjob.backend.persistence.entity;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AuditableEntity {

    Date created;
    Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}
