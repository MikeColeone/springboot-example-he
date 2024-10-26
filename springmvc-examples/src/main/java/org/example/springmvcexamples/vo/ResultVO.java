package org.example.springmvcexamples.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springmvcexamples.exception.Code;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {
    private int code;
    private String message; //返回信息
    private Object data;  //返回数据


    //只返回成功的状态 不返回数据

    private static final ResultVO EMPTY = ResultVO.builder().code(200).build();
    //每次请求的不必都创建对象 所以构建一个ResultVO对象做一个缓存 不必每次都创建
    public static ResultVO ok(){
        return EMPTY;
    }
    public static ResultVO success(Object data){
        return ResultVO.builder().code(200).data(data).build();
    }

    public static ResultVO success(String account){
        return ResultVO.builder().code(200).build();
    }

    public static ResultVO error(Code code){
        return ResultVO.builder().code(code.getCode()).message(code.getMessage()).build();
    }

    public static ResultVO error(int code,String message){
        return ResultVO.builder().code(code).message(message).build();
    }
}

