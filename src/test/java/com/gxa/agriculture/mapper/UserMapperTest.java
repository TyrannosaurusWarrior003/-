package com.gxa.agriculture.mapper;

import com.gxa.agriculture.MainApp;
import com.gxa.agriculture.entity.pojo.User;
import com.gxa.agriculture.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


/**
 * 测试UserMapper的调用API,完成CRUD方法
 * 要完成该测试，还需引入SpringBoot的测试环境
 * @SpringBootTest开启springboot测试环境，引入spring容器 并指定了主启动类，当如果包路径完全相同，该配置可以省略
 *
 */


//@SpringBootTest()包路径完全相同，该配置可以省略
@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    //查询
    @Test
    public void testSelectById() {
        System.out.println(userMapper);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    //删除
    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(38);
        System.out.println(i);
    }

    //添加
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三丰");
        user.setPhone("1988");
        user.setPwd("123456");
        userMapper.insert(user);
    }

    //修改
    @Test
    public void testUpdateById() {
        User user = userMapper.selectById(50);
        user.setPwd("99999");
        user.setRegTime(new Date());
        userMapper.updateById(user);
    }
}
