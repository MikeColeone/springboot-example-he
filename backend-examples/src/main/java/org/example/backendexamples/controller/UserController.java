package org.example.backendexamples.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//实现更新密码
@Slf4j
@RestController
@RequiredArgsConstructor //使用final注解自动实现自动注入
@RequestMapping("/api/")
public class UserController {
    private final UserService userService;

    public ResultVO patchPassword(@RequestBody User user, @RequestAttribute("uid") String uid) {
        userService.UpdateUserPasswordById(uid, user.getPassword());
        return ResultVO.ok();
    }
}
