package org.example.jdbcexamples.repository;
import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class UserRepositoryTest{
    @Autowired
    private UserRepository userRepository;

    @Test
    void deleteAllById() {
        userRepository.deleteAllById("1283955984397971456");
        User user = userRepository.findById("1283955984397971456").orElse(null);
        log.debug("删除的user为{}",user);
    }


    //更新
    //指定主键在数据表中查询到该主键的时候 查不到报错 save执行的是更新操作 否者执行的是插入操作
    @Test
    void save(){
        User user = User.builder().id("1283955714800693248").name("hdx").build();
        userRepository.save(user);
        log.debug("{}",user);


        User user1 = User.builder().name("haha").build();
        userRepository.save(user1);
        log.debug("{}",user1);
    }


}