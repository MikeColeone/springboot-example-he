package org.example.springmvcexamples.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.exception.XException;
import org.example.springmvcexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一处理异常信息
@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(XException.class)
    public ResultVO handleXException(XException e){
        if(e.getCode()!=null){
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getNumber(),e.getMessage());
    }

    @ExceptionHandler(XException.class)
    public ResultVO handleException(Exception e){
        return ResultVO.error(Code.ERROR,e.getMessage());
    }
}
