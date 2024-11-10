package org.example.springmvcexamples.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.exception.XException;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一处理异常信息 返给客户端
@Slf4j
@RestControllerAdvice
public class ExceptionController {

//    @ExceptionHandler 注解是 Spring MVC 中用来处理特定异常的注解。当控制器抛出指定的异常时，自动捕获并调用相应的函数
    @ExceptionHandler(XException.class) //处理不同的异常信息 首先是自定义信息
    public ResultVO handleXException(XException e){
        if(e.getCode()!=null){
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getNumber(),e.getMessage());
    }

    //同统一返回400
    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e){
        return ResultVO.error(Code.ERROR,e.getMessage());
    }
}
