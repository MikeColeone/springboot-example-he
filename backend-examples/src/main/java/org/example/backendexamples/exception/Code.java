package org.example.backendexamples.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/*
通用的异常码 枚举类型
 */

//只掉不该所以不需要setter 采用http协议异常码
@Getter
@RequiredArgsConstructor
public enum Code {
    //创建实例
    LOGIN_ERROR(Code.ERROR, "用户名密码错误"),
    BAD_REQUEST(Code.ERROR, "请求错误"),
    UNAUTHORIZED(401, "未登录"),
    TOKEN_EXPIRED(403, "过期请重新登录"),
    FORBIDDEN(403, "无权限");
    public static final int ERROR = 400;  //通用业务码
    private final int code;
    private final String message; //异常信息
}