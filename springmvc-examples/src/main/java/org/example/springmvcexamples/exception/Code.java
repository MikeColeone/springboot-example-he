package org.example.springmvcexamples.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/*
通用的异常码
 */

//只掉不该所以不需要setter 采用http协议异常码
@Getter
@RequiredArgsConstructor
public enum Code {
    LOGIN_ERROR(Code.ERROR, "用户名密码错误"),
    BAD_REQUEST(Code.ERROR, "请求错误"),
    UNAUTHORIZED(401, "未登录"),
    TOKEN_EXPIRED(403, "过期请重新登录"),
    FORBIDDEN(403, "无权限");
    public static final int ERROR = 400;
    private final int code;
    private final String message;
}