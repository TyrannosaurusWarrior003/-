package com.gxa.agriculture.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BCryptUtil2 {
    private static BCryptPasswordEncoder encoder = null;

    /**
     * 加密
     *
     * @param rawPwd
     * @return
     */
    public static String encode(String rawPwd) {
        return BCryptUtil2.encoder.encode(rawPwd);
    }


    public static boolean matches(String rawPwd, String encodedPwd) {
        encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPwd, encodedPwd);
    }

}
