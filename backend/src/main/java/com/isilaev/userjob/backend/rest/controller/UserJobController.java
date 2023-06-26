package com.isilaev.userjob.backend.rest.controller;

import com.isilaev.userjob.backend.persistence.entity.UserJobInfo;
import com.isilaev.userjob.backend.rest.dto.UserJobInfoDto;
import com.isilaev.userjob.backend.rest.service.UserJobService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/user/job")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserJobController {

    UserJobService userJobService;

    @PostMapping("/create-userjob")
    public ResponseEntity<UserJobInfo> create(@RequestBody UserJobInfoDto userJobInfoDto) {
        return new ResponseEntity<>(userJobService.createUserJob(userJobInfoDto), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update-userjob", produces = "application/json")
    public UserJobInfoDto update(UserJobInfoDto userJobInfoDto) {
        return userJobService.updateUserJob(userJobInfoDto);
    }

    @GetMapping(value = "/get-userjob", produces = "application/json")
    public UserJobInfoDto get(@RequestParam(value = "idCompany", required = false) Long companyId,
                              @RequestParam(value = "userId", required = false) Long userId) {
        return userJobService.getUserJob(companyId, userId);
    }
}
