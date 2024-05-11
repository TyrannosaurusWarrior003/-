package com.gxa.agriculture.service;

import com.gxa.agriculture.MainApp;
import com.gxa.agriculture.entity.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class UserServiceTest {

    //Resource的用法，byname
    //@Resource(name = "userService")
    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("mmm");
        user.setPhone("155");
        user.setPwd("155");
        boolean save = userService.save(user);

    }

    @Test
    public void testSaveOrUpdate() {
        //getById: 直接通过id查询（必须是主键）
        //getOne: 当结果只有一条
        //list: 查询多条结果
        User user = userService.getById(1);
        user.setName("张学友y");
        user.setId(null);
        boolean save = userService.saveOrUpdate(user);

    }
}
