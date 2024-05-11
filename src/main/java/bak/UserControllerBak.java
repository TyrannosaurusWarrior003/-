/*
package bak;

import com.gxa.agriculture.common.R;
import com.gxa.agriculture.entity.dto.UserDto;
import com.gxa.agriculture.entity.dto.UserRegisterDto;
import com.gxa.agriculture.entity.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.User;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

*/
/*@Controller
@ResponseBody*//*

@RestController
@Slf4j
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户操作接口")
public class UserControllerBak{

    */
/*//*
/以前学的
    @GetMapping("/{id}")
    public void getById(@PathVariable Integer id) {
        log.info("{}方法被访问了","getById");
        System.out.println("id:" + id);
    }*//*


    */
/**
     * get请求访问参数一致与不一致
     * @param id
     *//*


    */
/*//*
/参数名与请求参数一致
    @GetMapping("/getById")
    public void getById( Integer id) {
        log.info("{}方法被访问了","getById");
        System.out.println("id:" + id);
    }*//*


    */
/*//*
/参数名与请求参数不一致
    @GetMapping("/getById")
    public void getById(@RequestParam("i") Integer id) {
        log.info("{}方法被访问了","getById");
        System.out.println("id:" + id);
    }*//*



    */
/**
     * 当传入多个参数时推荐使用使用dto的优点
     *
     * @param
     * @return
     *//*

    //参数不够产生null值
    */
/*@GetMapping("/login")
    public User login(User user) {
        log.info("该用户的信息：{}", user);
        return null;
    }*//*



   */
/* @PostMapping("/login")
    public User login(@RequestBody String phone, String pwd) {
        log.info("该用户的手机号：{}，密码：{}", phone, pwd);
        return null;
    }*//*


    */
/*@GetMapping("/login")
    public User login(String phone, String pwd) {
        log.info("该用户的手机号：{}，密码：{}", phone, pwd);
        return null;
    }*//*



    //参数多时用dto封装为对象比较方便简洁
    @PostMapping("/login")
   */
/* @ApiImplicitParams({
            @ApiImplicitParam(name = "dto", value = "用户登录的传输对象")
    })*//*

    public User login(@RequestBody UserDto dto) {
        log.info("该用户的信息：{}", dto);
        return null;
    }

    */
/**
     * 模拟用户登录
     *
     * @param id
     * @return
     *//*

    */
/*@GetMapping("getById")
    public com.gxa.agriculture.entity.pojo.User getById(Integer id){
        log.info("这是：" + id);
        com.gxa.agriculture.entity.pojo.User user = new com.gxa.agriculture.entity.pojo.User();
        user.setId(id);
        user.setName("战术上");
        user.setPwd("1111");
        user.setPhone("43343");

        return user;
    }*//*

    @GetMapping("getById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的编号", required = true)
    })
    //@ApiImplicitParams会覆盖@ApiParam
    public UserVo getById(@ApiParam(value = "用户id") Integer id) {
        log.info("这是：" + id);
        UserVo userVo = new UserVo();
        userVo.setId(id);
        userVo.setName("战术上");
        userVo.setPwd("1111");
        userVo.setPhone("43343");

        //使用UUID给前端颁发token串
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        userVo.setToken(token);

        return userVo;
    }


    @ApiOperation(value = "register", tags = "用户注册方法", notes = "用户注册方法注意事项")
    @PostMapping("/register")
    public com.gxa.agriculture.entity.pojo.User register(@RequestBody UserRegisterDto dto) {
        //从数据库返回的id
        int id = 100;

        //创建user实体类
        com.gxa.agriculture.entity.pojo.User user = new com.gxa.agriculture.entity.pojo.User();

        //赋值
        BeanUtils.copyProperties(dto, user);
        user.setId(id);

        log.info("用户信息：" + dto);
        return user;

    }


    @ApiOperation(value = "用户登录方法", notes = "{\n" +
            "  \"phone\": \"133\",\n" +
            "  \"pwd\": \"123456\"\n" +
            "}")
    @PostMapping("/login2")
    public R login2(@RequestBody UserDto dto) {
        UserVo vo = null;
        if ("133".equals(dto.getPhone()) && "123456".equals((dto.getPwd()))) {
            //登录成功
            vo = new UserVo();
            vo.setId(100);
            vo.setName("张三丰");
            vo.setPhone("133");
            vo.setPwd("123456");

            //使用UUID给前端颁发token串
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            vo.setToken(token);
        }

        return vo != null ? R.success(vo) : R.error();
    }


    @ApiOperation(tags = "用户注册方法", value = "register2", notes = "{\n" +
            "  \"name\": \"mdh\",\n" +
            "  \"phone\": \"1988\",\n" +
            "  \"pwd\": \"123456\"\n" +
            "}")
    @PostMapping("/register2")
    public R register2(@RequestBody UserRegisterDto dto) {
        //从数据库返回的id
        int id = 100;

        //创建user实体类
        com.gxa.agriculture.entity.pojo.User user = new com.gxa.agriculture.entity.pojo.User();

        //赋值
        BeanUtils.copyProperties(dto, user);
        user.setId(id);

        log.info("用户信息：" + dto);
        return user.getId() != null ? R.success(user) : R.error();
    }
}

*/
