package org.example.redisexamples;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.testng.annotations.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RedissonTest {

    @Autowired
    private RedissonClient client;

    @Test
    public void testRedisson(){
        var name = "hdx";
        var key = "users:14";
        RBucket<String> bucket = client.getBucket(key, StringCodec.INSTANCE);
        log.info("bucket = {}",bucket);
        bucket.set(name);

        RBucket<String> bucket1 = client.getBucket(key, StringCodec.INSTANCE);
        log.info("bucket1={}",bucket1);

    }
}
