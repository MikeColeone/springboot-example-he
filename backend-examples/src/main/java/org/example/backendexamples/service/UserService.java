package org.example.backendexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor //使用fianl注解自动实现自动注入
@RequestMapping("/api/")
@Service
public class UserService {
    private static final List<User> USERS = create();
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //初始化管理员
    private static List<User> create(){
        User user = User.builder()
                .id("1")
                .name("admin")
                .role(User.ADMIN)
                .account("1001")
                .password("admin") //编码生成的之一
                .build();


        return List.of(user);
    }

    public List<User> listUsers(){
        return USERS;
    }
}
