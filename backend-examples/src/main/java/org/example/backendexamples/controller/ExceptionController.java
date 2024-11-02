package org.example.backendexamples.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.example.backendexamples.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一处理异常信息 返给客户端
@Slf4j
@RestController
@RequiredArgsConstructor //使用fianl注解自动实现自动注入
@RequestMapping("/api/")
public class ExceptionController {
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
