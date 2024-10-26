package org.example.springmvcexamples.service;

import org.example.springmvcexamples.dox.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private static final List<User> USERS = create();
    private static List<User> create(){
        User user = User.builder()
                .id("1")
                .name("hdx")
                .account("1001")
                .password("12345")
                .build();
        return List.of(user);
    }

    public List<User> listUsers(){
        return USERS;
    }

    public User getUserByAccount(String account,String password){
        return USERS.stream()
                .filter(u->u.getAccount().equals(account))
                .filter(u->u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
    public User getUserByAccount(String account){
        return USERS.stream()
                .filter(u->u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }
}
