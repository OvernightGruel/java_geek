package oop_package.src.com.itranswarp.sample;

// 导入System类的所有静态字段和静态方法:
// import static java.lang.System.*;

// 导入其他包public_class
import oop_package.src.com.itranswarp.world.Person;
// 无法导入普通class
// import oop_package.src.com.itranswarp.world.Hello;

public class Main{
    public static void main(String[] args) {
        var p1 = new Person("小周");
        p1.sayHello();  // public_method可在外包调用

        // var h1 = new Hello();
        // h1.hello("hello");  // 包作用域方法，只能在包内调用
    }
}