package oop_package.src.com.itranswarp.world;  // 申明包名

// public_class对外包开放类
// 普通class包内作用域
class Hello{
    // public_method/field对外提供方法
    // private_method/field类作用域方法
    // method/field包作用域方法，只能在包内调用
    void hello(String name){
        System.out.println(name);
    }
}