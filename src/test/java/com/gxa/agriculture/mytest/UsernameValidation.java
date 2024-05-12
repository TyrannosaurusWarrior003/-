package com.gxa.agriculture.mytest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidation {

    public static void main(String[] args) {
        String username1 = "user1234567890";  // 超过12个字符
        String username2 = "valid_username";  // 符合要求的用户名

        // 定义正则表达式，限制用户名不能超过12个字符
        String regex = "^.{1,12}$";
        Pattern pattern = Pattern.compile(regex);

        // 验证用户名1
        Matcher matcher1 = pattern.matcher(username1);
        if (matcher1.matches()) {
            System.out.println(username1 + " 是合法的用户名");
        } else {
            System.out.println(username1 + " 不符合要求，用户名不能超过12个字符");
        }

        // 验证用户名2
        Matcher matcher2 = pattern.matcher(username2);
        if (matcher2.matches()) {
            System.out.println(username2 + " 是合法的用户名");
        } else {
            System.out.println(username2 + " 不符合要求，用户名不能超过12个字符");
        }
    }
}
