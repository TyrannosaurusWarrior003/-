package com.gxa.agriculture.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.gxa.agriculture.MainApp;
import com.gxa.agriculture.entity.pojo.User;
import com.gxa.agriculture.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 测试UserMapper的调用API,完成CRUD方法
 * 要完成该测试，还需引入SpringBoot的测试环境
 *
 * @SpringBootTest开启springboot测试环境，引入spring容器 并指定了主启动类，当如果包路径完全相同，该配置可以省略
 */


//@SpringBootTest()包路径完全相同，该配置可以省略
@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class UserMapperWithWrapperTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 带有非空判断，查询用户手机号
     */
    @Test
    public void testQuery() {
        //phone = ?

        //1. 构建条件构造器的方法
        //2. 条件构造器的类型 Update 和 Query
        //3. 查询类型的条件构造 QueryWrapper和LambdaQueryWrapper
        //4. 通过API找到对应的方法

       /* User user = new User();
        QueryWrapper<User> query = Wrappers.query(user);
        query.eq("phone", "13333333");*/

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery(User.class);

        //普通的构建
        //lambdaQuery.eq(User::getPhone, "13333333");

        //带有条件判定的构建
        String phone = "13333333";
        //lambdaQuery.clear();
        lambdaQuery.eq(!StringUtils.isEmpty(phone), User::getPhone, phone);

        //使用条件构造对象完成查询
        User user = userMapper.selectOne(lambdaQuery);
        System.out.println(user);

    }

    /**
     * 模糊查询用户手机号
     */
    @Test
    public void testList() {

        //where phone like ?
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery(User.class);
        //lambdaQuery.clear();
        //lambdaQuery.clear();
        lambdaQuery.like(User::getPhone, "135");

        List<User> users = userMapper.selectList(lambdaQuery);

        //遍历
        users.forEach(System.out::println);
    }

    /**
     * 条件查询用户手机号密码
     */
    @Test
    public void testQuery2() {
        // where phone = ? and pwd = ?
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);

        // 默认采用逻辑与
        /*queryWrapper.eq(User::getPhone, 13333334);
        queryWrapper.eq(User::getPwd, "123321123");*/

        /*queryWrapper.eq(User::getPhone, 13333334)
                .eq(User::getPwd, "123321123");*/

        queryWrapper.eq(User::getPwd, "123321123");
        //queryWrapper.or();
        queryWrapper.eq(User::getPhone, 13333334);

        userMapper.selectOne(queryWrapper);
    }

    /**
     * 姓名或手机号的模糊查询
     */
    @Test
    public void testQuery3() {
        // where name = ? and phone = ?
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);


        queryWrapper.like(User::getName, "123321123");
        queryWrapper.or();
        queryWrapper.like(User::getPhone, 13333334);

        userMapper.selectOne(queryWrapper);
    }

    /**
     * 查询编号1，2，5
     */
    @Test
    public void testQuery4() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);


        /*//1.用数组
        List<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        ids.add(5);
        queryWrapper.in(User::getId, ids);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);*/


        //2.用可变参数
        queryWrapper.in(User::getId, 1, 2, 5);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }


    /*//可变参数就是数组
    public void selectByArray(Integer... ids) {
        System.out.println(ids);
        System.out.println(ids.length);
        System.out.println(ids[2]);
    }

    @Test
    public void testSelectByArray() {
        selectByArray(1, 2, 5);
    }*/


    /**
     * 查询注册时间在xxx-xxx范围内的用户信息
     */
    @Test
    public void testQuery5() {

        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);

        //yyyy MM dd hh:mm:ss
        queryWrapper.between(User::getRegTime, "2023-04-22 19:08:41", "2023-09-27 15:29:37");
        userMapper.selectList(queryWrapper);
    }

    /**
     * 将注册时间早与2024年1月1日的用户deleted状态改为1
     */
    @Test
    public void testUpdate() {

        //数据库使用datetime类型，必须带时分秒
        //数据库用date,只用到年月日
        LambdaUpdateWrapper<User> updateWrapper = Wrappers.lambdaUpdate(User.class);
        updateWrapper.lt(User::getRegTime, "2024-04-22 00:00:00").set(User::getDeleted, 1);

        int rowsAffected = userMapper.update(null, updateWrapper);
        System.out.println(rowsAffected);

    }


}
