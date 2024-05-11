package com.gxa.agriculture.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gxa.agriculture.common.BizException;
import com.gxa.agriculture.common.ErrorCode;
import com.gxa.agriculture.entity.dto.UserLoginDto;
import com.gxa.agriculture.entity.dto.UserRegisterDto;
import com.gxa.agriculture.entity.pojo.User;
import com.gxa.agriculture.entity.vo.UserVo;
import com.gxa.agriculture.mapper.UserMapper;
import com.gxa.agriculture.service.UserService;
import com.gxa.agriculture.util.BCryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * UserServiceImpl 是UserService的实现者
 * 通过ServiceImpl 获取大量的MP基础API
 * 在泛型中通过指定UserMapper,把Mapper作为真正的执行者
 * <p>
 * 在service中声明spring事务管理机制
 * 当前所有的service方法都具备了事物的管理能力
 * 业务中当含有多个CRUD，要么都commit 要么都 rollback
 * 都是利用AOP
 * try{
 * ..
 * ..
 * commit();
 * } catch (Excption e) {
 * rollback();
 * }
 */
//被反射生成对象，放在容器中
//@Service("userService")
@Service()
@Transactional(rollbackFor = Throwable.class)

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public UserVo login(UserLoginDto dto) throws BizException {

        //登录校验： mp的方式实现
        //where phone = ? and pwd = ?
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);
        queryWrapper.eq(User::getPhone, dto.getPhone());

        //queryWrapper.eq(User::getPwd, dto.getPwd());

        //通过手机号查询对应的用户
        //getOne
        User user = this.getOne(queryWrapper);

        //先判断用户对象是否存在
        if (user == null) {
            throw new BizException(ErrorCode.NULL_USER);
        }

        //获取数据库密码的密文
        String pwd = user.getPwd();

        //密码的判断
        boolean matches = BCryptUtil.matches(dto.getPwd(), pwd);


        //没有数据
        //自定义异常加全局异常
        if (!matches) {
            throw new BizException(ErrorCode.FAILED_LOGIN);
        }

        //查询有数据
        //封装在vo对象中
        UserVo userVo = new UserVo();

        //复制字段的特征
        BeanUtils.copyProperties(user, userVo);

        //颁发token
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        userVo.setToken(token);

        return userVo;
    }

    @Override
    public User register(UserRegisterDto dto) throws BizException {

        //注册失败
        //如果手机号相同
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class);
        queryWrapper.eq(User::getPhone, dto.getPhone());

        //getOne
        User one = this.getOne(queryWrapper);
        //查询有数据
        //自定义异常加全局异常
        if (one != null) {
            throw new BizException(ErrorCode.ALREADY_REGISTER);
        }


        //查询无数据
        //保存数据
        //数据库返回id
        int id = 123;


        //赋值
        User user = new User();
        user.setId(id);
        BeanUtils.copyProperties(dto, user);
        //存入数据库
        boolean isSave = this.save(user);


        return user;
    }
}
