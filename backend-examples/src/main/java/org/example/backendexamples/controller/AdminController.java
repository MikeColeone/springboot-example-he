package org.example.backendexamples.controller;

import lombok.RequiredArgsConstructor;
import org.example.backendexamples.dox.User;
import org.example.backendexamples.service.UserService;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {
    private UserService userService;


    @PostMapping("users")
    public ResultVO postUser(@RequestBody User user){
        userService.addUser(user);
        return ResultVO.ok();
    }

    //更新密码
    @PutMapping("users/{account}/password")
    public ResultVO putPassword(@PathVariable String account){

    }
    @PostMapping("user")
    public ResultVO getUser(){
        return ResultVO.success((userService.listUsers()));
    }

    @GetMapping("users/{account}")
    public ResultVO getUser(@PathVariable String account){
        return ResultVO.success(userService.getUserByAccount(account));
    }
}
