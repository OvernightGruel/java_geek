package oop_package.src.com.itranswarp.world;  // 申明包名

// 一个.java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。
public class Person{
    public String name;

    public Person(String name){
        this.name = name;
    }

    public void sayHello(){
        var h1 = new Hello();
        h1.hello(this.name);  // 包作用域方法，只能在包内调用
    }
}