package limit;

import java.util.ArrayList;

/**
 * 模拟赛车比赛，理解泛型通配符的用法
 */
public class App {
    public static void main(String[] args) {
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        go(bmws);

        ArrayList<BENZ> benzs = new ArrayList<>();
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        go(benzs);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        //go(dogs);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        go1(cars);
    }

    //ArrayList<Car>与ArrayList<BENZ>没有关系，go2不能传入BENZ
    public static void go2(ArrayList<Car> cars) {

    }

    //这里设置任意类型都能进入，使得dog也能参加car比赛，不合理，故出现了下面的
    public static void go0(ArrayList<?> cars) {

    }

    //子类和car可以传入
    public static void go(ArrayList<? extends Car> cars) {

    }

    //父类和car可以传入
    public static void go1(ArrayList<? super BENZ> cars) {

    }

}

class Dog {}

class BENZ extends Car{

}


class BMW extends Car{

}


//父类
class Car {

}