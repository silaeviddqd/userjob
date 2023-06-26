package com.isilaev.userjob.backend.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Company with given id already exist")
public class CompanyAlreadyExistException extends RuntimeException {
}
