package dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {

    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    @Before
    public void init() throws Exception {
        System.out.println("init被执行");
        //创建驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //建立连接
        String url = "jdbc:mysql://localhost:3306/db_hualian?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "1234";
        connection = DriverManager.getConnection(url, username, password);
    }


    @After
    public void close() throws Exception {
        // 关闭结果集和连接
        if (resultSet != null) {
            resultSet.close();
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        connection.close();
    }


    /**
     * 插入数据
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {

        //创建执行对象
        preparedStatement = connection.prepareStatement("insert into tb_user(name, phone, pwd) values(?,?,?)");
        preparedStatement.setObject(1, "zhangsan");
        preparedStatement.setObject(2, "13333333");
        preparedStatement.setObject(3, "123321123");

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    /**
     * 查询数据
     *
     * @throws Exception
     */
    @Test
    public void testQuery() throws Exception {

        // 创建连接和执行对象，这里假设 connection 已经正确初始化
        preparedStatement = connection.prepareStatement("select * from tb_user");

        // 执行查询操作，获取结果集
        resultSet = preparedStatement.executeQuery();

        // 遍历结果集并处理查询结果
        while (resultSet.next()) {
            // 根据需要获取查询结果的各个字段值
            Object username = resultSet.getObject("name");
            Object id = resultSet.getObject("id");
            // 其他字段获取类似

            // 处理查询结果，可以输出到控制台或者进行其他业务处理
            System.out.println(id + "：" + username);
        }


    }

    @Test
    public void testDataSourse() throws SQLException {
        //spring通过对DataSource类型的bean的创建和管理
        //完成数据库的连接管理

        //建立连接
        String url = "jdbc:mysql://localhost:3306/db_hualian?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "1234";

        //创建MySQL类型的数据源对象
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        Connection connection = mysqlDataSource.getConnection();
        //..........
    }

    /**
     * 通过源码，了解mybatis最底层就是使用动态代理
     */


   /* @Test
    public void testSqlSession() {
        SqlSession sqlSession = null;
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    }*/

}
