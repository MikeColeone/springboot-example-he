package org.example.springmvcexamples.controller;

import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.component.JWTComponent;
import org.example.springmvcexamples.component.PasswordEncodingConfig;  //不需要导入配置类 由spring自动扫描机制注册
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; //导入是必须的 配置类只是实现了该接口  但是自动注入的时候还是要导入该接口
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.springmvcexamples.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor //使用fianl注解自动实现自动注入
@RequestMapping("/api/")
public class LoginController {

    //构造函数注入的组件必须加final
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final JWTComponent jwtComponent;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user, HttpServletResponse response){
        User userR = userService.getUserByAccount(user.getAccount());
        if (userR==null|| !passwordEncoder.matches(user.getPassword(),userR.getPassword())){

            return ResultVO.error(Code.LOGIN_ERROR);

        }
        log.info("login success");
        //Map的键对应的值不允许为空
        String token = jwtComponent.encode(Map.of("uid",userR.getId(),"role",userR.getRole()));
        log.debug("token:{}",token);
        //将token放在header
        response.setHeader("token",token);
        response.setHeader("role",userR.getRole()); //可以设成两套值 加大破解的难度
        return ResultVO.success(userR);
    }
}
