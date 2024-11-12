package org.example.backendexamples.service;
import lombok.RequiredArgsConstructor;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.example.backendexamples.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class InitService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        String account = "admin";
        long count = userRepository.count();
        if(count>0)return; //有记录
        User user = User.builder().name(account).account(passwordEncoder.encode(account)).password(account).role(User.ADMIN).build();

    }


}