package com.gxa.agriculture.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.gxa.agriculture.MainApp;
import com.gxa.agriculture.service.UserService;
import com.gxa.agriculture.service.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class MPGenerator {
    public static void main(String[] args) {
        // 把连接url改成适配自己数据库的方式
        String url = "jdbc:mysql://localhost:3306/db_hualian? characterEncoding=UTF8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "root";
        FastAutoGenerator.create(url, username, password)
                // 基础全局配置
                .globalConfig(builder -> {
                    builder.author("bill") // 设置作者,出现在文档注释中
                            .commentDate("yyyy-MM-dd")
                            .enableSwagger() // 开启 swagger 模式,给实体类pojo/controller添加swagger的注解
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://generator"); // 指定输出目录
                })
                // 包的配置
                .packageConfig(builder -> {
                    builder.parent("com.gxa") // 设置父包名
                            .moduleName("agriculture") // 设置父包模块名
                            // mapper文件创建的目录
                            .mapper("mapper")
                            // 设置实体类包名
                            .entity("entity.pojo")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                    "C:\\Users\\mdh\\Desktop\\国信安实训文件\\01\\day01代码\\src\\main\\java\\bak"));
                })

                // 策略配置
                .strategyConfig(builder -> {
                    // 指定哪些数据表要进行逆向工程的创建(pojo/mapper/service/controller)
                    // 选择表的时候应该选择单表(对应实体)
                    // 设置需要生成的表名, 注意: 关系表(多表查询的中间表)不需要
                    // 视图是否可以自动生成代码?
                    builder.addInclude("tb_user")
                            // 指定数据表的默认前缀,生成实体类时会忽略: tb_user-> User
                            .addTablePrefix("tb_", "sys_", "gxa_", "t_")
                            .serviceBuilder() //service策略
                            .formatServiceFileName("%sService") // 设置接口名不带I前 缀, UserService
                            .formatServiceImplFileName("%sServiceImpl") // UserServiceImpl
                            .entityBuilder() //实体类策略
                            .enableLombok() // 开启lombok
                            .enableTableFieldAnnotation() // 开启字段注解
                            .controllerBuilder() // controller策略
                            .enableRestStyle() //开启RestController
                    ;
                })
                // .templateEngine(new FreemarkerTemplateEngine())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}