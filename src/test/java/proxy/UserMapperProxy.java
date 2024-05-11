package proxy;

import lombok.extern.slf4j.Slf4j;

import javax.xml.ws.spi.Invoker;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class UserMapperProxy {
    //通过动态代理创建示例

    public void test() {
        //Proxy 代理类
        //newProxyInstance创建代理对象的方法
        //Ctrl + P

        //类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();

        //interfaces
        Class[] interfaces = {UserMapper.class};//实际上包含了父接口

        //反射处理器

        //得到代理对象
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invoker invoke = null;//?
                //用动态代理增强
               try {
                   //原方法调用
                   //Object invoke = method.invoke(proxy, args);
               }catch (Exception e){

               }

               return invoke;

                /*log.info("方法前");
                //反射执行核心方法
                Object invoke = method.invoke(proxy, args);
                log.info("方法后");*//*

                //全局异常处理器机制
                try {
                    Object invoke = method.invoke(proxy, args);
                    return invoke;

                } catch (Exception e) {
                    return null;
                }
*/
            }
        });

        userMapper.getById(1);
    }
}
