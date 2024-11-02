package org.example.backendexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    void save(){
        LocalDateTime LocalDateTime = null;
        User user = User.builder()
                .name("admin")
                .account("admin")
                .role("ADMIN") // 默认角色
                .password("ADMIN") // 默认密码，建议加密
                .build();
        userRepository.save(user);
        log.debug("{}",user);

    }
    @Test
    void findUserByAccount() {
    }
}