package com.gxa.agriculture.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gxa.agriculture.common.BizException;
import com.gxa.agriculture.common.ErrorCode;
import com.gxa.agriculture.common.R;
import com.gxa.agriculture.entity.dto.UserLoginDto;
import com.gxa.agriculture.entity.dto.UserRegisterDto;
import com.gxa.agriculture.entity.pojo.User;
import com.gxa.agriculture.entity.vo.UserVo;
import com.gxa.agriculture.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/*@Controller
@ResponseBody*/
@RestController
@Slf4j
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户操作接口")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户登录方法
     *
     * @param dto
     * @return
     */

    @ApiOperation(tags = "用户登录方法", value = "login", notes = "{\n" +
            "  \"phone\": \"133\",\n" +
            "  \"pwd\": \"123456\"\n" +
            "}")
    @PostMapping("/login")
    //这里的R可以返回R<String>或R<UserVo>取决于返回什么
    public R login(@RequestBody UserLoginDto dto) throws  BizException{

        //FIXME 数据校验

        // 调用service
        UserVo login = userService.login(dto);

        // 返回结果给前端
        return R.success(login);


    }



    //查询
    @ApiOperation(tags = "根据id查询", value = "getById")
    @GetMapping("/getById")
    public R<User> getById( Integer id) throws BizException {

        //从业务层得到数据
        User user = userService.getById(id);

        //控制层加工处理
        if (user == null) {
            throw new BizException(ErrorCode.NULL_USER);
        }

        //返回给前端
        return R.success(user);
    }



    @ApiOperation(tags = "用户注册方法", value = "register")
    @PostMapping("/register")
    public R register(@RequestBody UserRegisterDto dto) throws BizException {

        //校验数据


        //调用方法
        User user = userService.register(dto);


        //返回结果给前端
        return R.success(user);
    }



    /**
     * 用户注册方法
     *
     * @param dto
     * @return
     */

    @ApiOperation(tags = "用户注册方法", value = "register2", notes = "{\n" +
            "  \"name\": \"mdh\",\n" +
            "  \"phone\": \"1988\",\n" +
            "  \"pwd\": \"123456\"\n" +
            "}")
    @PostMapping("/register2")
    public R<User> register2(@RequestBody UserRegisterDto dto) throws BizException {

        //-------------------------注册失败------------------------------------------
        //模拟数据库查询到重复数据
        if ("133".equals(dto.getPhone())){
            //抛出异常
            throw new BizException(ErrorCode.ALREADY_REGISTER);
        }

        //--------------------------注册成功-----------------------------------------
        //从数据库返回的id
        int id = 100;

        //创建user实体类
        com.gxa.agriculture.entity.pojo.User user = new com.gxa.agriculture.entity.pojo.User();

        //赋值
        BeanUtils.copyProperties(dto, user);
        user.setId(id);

        log.info("用户信息：" + dto);
        return R.success(user);
    }




}

