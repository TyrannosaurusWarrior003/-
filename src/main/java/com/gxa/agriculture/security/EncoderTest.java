package com.gxa.agriculture.security;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class EncoderTest {
    private BCryptPasswordEncoder encoder = null;


    @Before
    public void init() {
        encoder = new BCryptPasswordEncoder();
    }


    @Test
    public void testEncode() {

        //加密123456
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void testMatch() {

        boolean matches = encoder.matches("123456", "$2a$10$w8z3uXIO0LAKo4xvmc6gC.zN6iToMGqzcvM5n.WlI4w6elXw3vdUa");
        log.info("匹配情况：" + matches);
    }

}
