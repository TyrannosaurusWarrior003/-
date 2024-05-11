package com.gxa.agriculture.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BCryptUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 加密
     *
     * @param rawPwd
     * @return
     */
    public static String encode(String rawPwd) {
        return encoder.encode(rawPwd);
    }


    public static boolean matches(String rawPwd, String encodedPwd) {
        return encoder.matches(rawPwd, encodedPwd);
    }


}
