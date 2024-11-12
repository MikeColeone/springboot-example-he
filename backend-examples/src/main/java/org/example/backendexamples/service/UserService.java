package org.example.backendexamples.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.example.backendexamples.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
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
        return userRepository.findAll();
    }

    @Transactional
    public void UpdateUserPassword(String account){
        User user = userRepository.findByAccount(account);
        if(user == null){
           throw  XException.builder().number(Code.ERROR).message("用户不存在").build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public void UpdateUserPasswordById(String uid,String password){
        User user = userRepository.findById(uid).orElse(null);
        if(user == null){
            throw  XException.builder().number(Code.ERROR).message("用户不存在").build();
        }
        user.setPassword(passwordEncoder.encode(password));
    }

    public User getUser(String account){
        return userRepository.findByAccount(account);
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        
    }

    public String getUserByAccount(String account) {
        return userRepository.findByAccount(account).getPassword();
    }
}
