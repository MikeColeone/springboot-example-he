package org.example.backendexamples.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.components.JWTComponent;
import org.example.backendexamples.components.PasswordEncodingConfig;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor //使用fianl注解自动实现自动注入
@RequestMapping("/api/")
public class LoginController {

    //构造函数注入的组件必须加final
    private final UserService userService;
    private final PasswordEncodingConfig passwordEncodingConfig;
    private final PasswordEncoder passwordEncoder;

    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User userR = userService.getUserByAccount(user.getAccount());
        if (userR==null|| !passwordEncoder.matches(user.getPassword(),userR.getPassword())){
            System.out.println("=================");
            return ResultVO.error(Code.LOGIN_ERROR);

        }
        //Map的键对应的值不允许为空
        String token = jwtComponent.encode(Map.of("uid",userR.getId(),"role",userR.getRole()));
        //将token放在header
        response.setHeader("token",token);
        response.setHeader("role",userR.getRole()); //可以设成两套值 加大破解的难度
        return ResultVO.success(userR);
    }
}
