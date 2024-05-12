package com.gxa.agriculture.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gxa.agriculture.MainApp;
import com.gxa.agriculture.entity.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 分页的测试
     */
    @Test
    public void testPage(){
        //API尽量用service
        //E: IPage接口，通过Page类实现了分页的参数传递和结果的查询

        //分页的注意事项：需要配置类

        //构造查询条件
        long current = 2;   //当前页面
        long size = 5;      //每页记录数
        IPage<User> page = new Page<>(current,size);

        //通过调用service的page方法来获取到返回的IPage对象
        IPage<User> result = userService.page(page);

        //获取总记录数
        long total = result.getTotal();
        System.out.println(total);
        //获取当前页的记录情况
        List<User> records = result.getRecords();
        records.forEach(System.out::println);
    }
}
