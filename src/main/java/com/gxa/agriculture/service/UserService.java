package com.gxa.agriculture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gxa.agriculture.common.BizException;
import com.gxa.agriculture.entity.dto.UserLoginDto;
import com.gxa.agriculture.entity.dto.UserRegisterDto;
import com.gxa.agriculture.entity.pojo.User;
import com.gxa.agriculture.entity.vo.UserVo;

//关于mybatis中dao的mapper service serviceImpl 的理解
//mapper 我们继承了 mp提供的 BaseMapper
//service调用BaseMapper
//自定义接口UserService继承了官方的IService<User>接口
//自定义接口的实现类UserServiceImpl 要实现 自定义接口UserService中的方法。那么就要实现IService接口，ServiceImpl实现了IService<User>
//所以只需要继承->UserServiceImpl extends ServiceImpl 再实现自己自定义接口中官方未实现的方法 implements UserService
public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param dto
     * @return
     * @throws BizException
     */
    UserVo login(UserLoginDto dto) throws BizException;

    /**
     * 用户注册
     * @param dto
     * @return
     * @throws BizException
     */
    User register(UserRegisterDto dto) throws BizException;




}
