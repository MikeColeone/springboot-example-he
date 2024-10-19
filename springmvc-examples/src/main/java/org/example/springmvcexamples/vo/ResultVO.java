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
    private String message;
    private Object data;

    public static ResultVO success(Code code){

    }
}
