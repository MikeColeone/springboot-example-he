package org.example.springmvcexamples.component;


import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.html.HTMLImageElement;

import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

//工具性质的组件
@Component
@Slf4j
public class JWTcomponent {
    @Value("${my.secretkey}")
    private String secretkey;
    public String encode(Map<String,Object> map){
        return JWT.create()
                .withPayload(map)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(time.atZone(ZoneId.systemDefault()).toInstance()))
                .sign(algorithm);
    }

}
