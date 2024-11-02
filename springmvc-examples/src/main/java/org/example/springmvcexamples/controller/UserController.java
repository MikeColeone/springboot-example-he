package org.example.springmvcexamples.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/user/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("info")
    public ResultVO getInfo(@RequestAttribute("uid") String uid){
        log.debug("{}",uid);
        return ResultVO.success(Map.of("uid",uid));
    }
}
