package com.gxa.agriculture.entity.vo;

import com.gxa.agriculture.entity.pojo.User;
import lombok.Data;


//返回数据

/*//继承
@Data
public class UserVo extends User {
    private String token;
}*/

//聚合
@Data
public class UserVo extends User{
    private String token;
}
