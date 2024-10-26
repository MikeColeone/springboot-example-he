package org.example.springmvcexamples.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String id;
    private String name;
    private String account;
    private String password;
    private LocalDateTime createTime;
}
