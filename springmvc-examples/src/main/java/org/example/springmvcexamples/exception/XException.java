package org.example.springmvcexamples.exception;


import lombok.*;

//通用异常名

@EqualsAndHashCode(callSuper = false)

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XException extends RuntimeException {
    private Code code;
    private int number;
    private String message;
}
