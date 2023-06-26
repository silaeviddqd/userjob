package com.isilaev.userjob.backend.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User or company not found")
public class UserJobInfoNotFoundException extends RuntimeException {
}
