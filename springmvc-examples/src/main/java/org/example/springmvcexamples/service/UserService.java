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
                .role(User.ADMIN)
                .account("1001")
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW") //编码生成的之一
                .build();

        User user1 = User.builder()
                .id("2")
                .name("hd")
                .role(User.USER)
                .account("1002")
                .password("$2a$10$XPz7Kp1kF8NU3vewqqPGn.feT7UPvhoZolvJ1JRi57s16XKMWz9OW") //编码生成的之一
                .build();
        return List.of(user,user1);
    }

    public List<User> listUsers(){
        return USERS;
    }
//无法给基于密码查询寻相关用户因为每一次密码编码生成的密码都是不同的

//    public User getUserByAccount(String account,String password){
//        return USERS.stream()
//                .filter(u->u.getAccount().equals(account))
//                .filter(u->u.getPassword().equals(password))
//                .findFirst()
//                .orElse(null);
//    }
    public User getUserByAccount(String account){
        return USERS.stream()
                .filter(u->u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }



}
