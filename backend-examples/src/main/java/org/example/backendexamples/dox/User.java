package org.example.backendexamples.dox;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.core.codec.StringDecoder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public static final String ADMIN = "jvon";
    public static final String USER = "vndi";

    @Id
    @CreatedBy
    private String id;
    private String name;
    private String role;
    private String account;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ReadOnlyProperty
    private LocalDateTime createTime;
    @ReadOnlyProperty
    private LocalDateTime updateTime;
}
