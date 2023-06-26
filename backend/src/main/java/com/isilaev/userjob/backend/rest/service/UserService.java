package com.isilaev.userjob.backend.rest.service;

import com.isilaev.userjob.backend.persistence.entity.User;
import com.isilaev.userjob.backend.persistence.repository.UserRepository;
import com.isilaev.userjob.backend.rest.dto.UserDto;
import com.isilaev.userjob.backend.rest.exception.UserAlreadyExistsException;
import com.isilaev.userjob.backend.rest.mapper.UserMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserMapper mapper;
    UserRepository userRepository;

    public User createUser(UserDto userDto) {
        Long userId = userDto.getId();

        if (userId != null) {
            User user = userRepository
                    .findById(userId)
                    .orElse(null);

            if (user != null) {
                throw new UserAlreadyExistsException();
            }
        }

        return userRepository.save(mapper.toEntity(userDto));
    }
}
