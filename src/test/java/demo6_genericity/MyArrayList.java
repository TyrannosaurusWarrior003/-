package demo6_genericity;

import lombok.Data;

@Data
public class MyArrayList<T> {
    private String name;
    private String code;
    private String msg;
    private T data;


    public void add(T data) {
    }

    public void remove(T data) {

    }

    //如果直接这样写，会被编译器错误的识别为普通方法而不是泛型方法，T被识别为未被定义的类型
    //public static void update(T data) {}

    //用<T>声明
    public static <T> void update(T data) {}

    //方法依赖与实例T被成功判定
    public  void update6(T data) {}


    /**
     *
     * @param data
     * @param <T>   声明为泛型方法
     * @MyArrayList<T>  声明返回值为传入的data
     * @return
     */

    //当用MyArrayList.update("数据")时
    //1.MyArraylist模板直接调用静态方法。
    //2.T为String:
    //  public static MyArrayList<String> update2(String data) {
    //      MyArrayList<String> objectMyArrayList = update2();
    //  }
    //3.并且实例化了一个对象，对象中T data -->  String data
    //4.objectMyArrayList.setData(data);所有传入的String类型的数据，能够赋值成功。
    //5.最后返回了一个对象，对象中包含了被改变的属性。封装了Object类型的数据
    public static <T> MyArrayList<T> update2(T data) {
        MyArrayList<T> objectMyArrayList = update2();

        objectMyArrayList.setData(data);


        return objectMyArrayList;
    }


    public static <T> MyArrayList<T> update2() {
        MyArrayList<T> myArrayList = new MyArrayList<>();

        myArrayList.setCode("200");

        return myArrayList;
    }

    //测试
    public static void main(String[] args) {
        MyArrayList<String> str = MyArrayList.update2("String类型数据");
        System.out.println("对象的类型是：" + str.getClass().getName());


    }
}
