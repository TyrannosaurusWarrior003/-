package com.gxa.agriculture.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxa.agriculture.entity.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Mapper 表示将当前的UserMapper接口动态代理生成对象，并注册到Spring容器
 * 当需要对象执行操作，就依赖注入
 *
 */
//@Mapper
public interface UserMapper extends BaseMapper<User> {
}
