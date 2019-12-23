import java.util.Arrays;

public class Oop{
    public static void main(String[] args){
        var zwq = new Person();
        String name = zwq.setName("zwq");
        zwq.setBirth(1995);
        System.out.println(zwq.getAge());
        System.out.println(name);
        System.out.println(zwq.country);
        System.out.println(Arrays.toString(zwq.full_name));

        var qwz = new Student(100);
        qwz.setName("qwz");  // 继承自父类方法
        qwz.printName();
        System.out.println(Arrays.toString(qwz.full_name));
        System.out.println(qwz.score);

        // 把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。反之称为向下转型（downcasting）
        var s1 = new Student(100);
        Person p1 = s1; // 向上转型，实际类型Student，变量声明类型Person
        System.out.println(Arrays.toString(s1.full_name));
        System.out.println(Arrays.toString(p1.full_name));
        p1.run(); // Student run

        if (p1 instanceof Student){
            Student s2 = (Student) p1; // 向下转型
            System.out.println(Arrays.toString(s2.full_name));
        }

        // Java的方法调用总是作用于运行期对象的实际类型，这种行为称为多态
        // 多态具有一个非常强大的功能，允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码
    }
}

// 默认继承Object
class Person{
    public String[] full_name; // 公有属性
    private int birth;         // 私有属性（不可继承），默认引用类型为null，数值类型为默认空值
    protected String name;       // 私有属性（可继承）
    public String country = "china"; // 也可以直接初始化，该初始化在构造方法之前

    public static int number;    // 静态属性：相当于Python中类属性。静态方法同理

    // 构造方法，相当于python中__init__
    public Person(String... names){  // 不定长参数，实际传递数组参数String[]
        this.full_name = names;
    }

    // 可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分
    // 方法名相同，但各自的参数不同，称为方法重载（Overload）。注意：方法重载的返回值类型通常都是相同的。方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。
    // 一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。
    public Person(){
        this("weiqi", "zhou");
    }

    public String setName(String name){      // 共有方法
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip();
        return this.name;
    }

    public void setBirth(int birth){
        this.birth = birth;
    }

    private int calcAge(int currentYear){   // 私有方法
        return currentYear - this.birth;
    }

    public int getAge(){
        return calcAge(2020);      // 类内部调用私有方法
    }

    public void run(){
        System.out.println("Person run");
    }
}

// 继承，java中只能单继承
class Student extends Person{
    public int score;
    public Book book; // 组合，has关系

    public Student(int score){
        super("zhou", "weiqi");  // 调用父类构造方法
        this.score = score;
    }

    public void printName(){
        System.out.println(this.name); // 继承私有属性（可继承）protected
    }

    // 覆写父类方法（Override），需要参数、返回值、方法名完全一致
    // 因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
    //      toString()：把instance输出为String；
    //      equals()：判断两个instance是否逻辑相等；
    //      hashCode()：计算一个instance的哈希值。
    // final修饰符有多种作用：
    //      final修饰的方法可以阻止被覆写；
    //      final修饰的class可以阻止被继承；
    //      final修饰的field必须在创建对象时初始化，随后不可修改。
    @Override  // 添加以让编译器检查是否正确覆写
    public void run(){
        System.out.println("Student run");
    }
}

class Book{}

// ----------------------------------------------------------------------------------------------
// 面向抽象编程使得调用者只关心抽象方法的定义，不关心子类的具体实现
// 抽象类：本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”
abstract class AbstractClass{
    // 抽象方法，本身没有实现任何方法语句。仅仅是为了定义方法签名，目的是让子类去覆写它
    public abstract void abstractMethod();
}

// ----------------------------------------------------------------------------------------------
// 接口：
// Java的接口（interface）定义了纯抽象规范，一个类可以实现多个接口；
// 接口也是数据类型，适用于向上转型和向下转型；
// 接口的所有方法都是抽象方法，接口不能定义实例字段；
// 接口可以定义default方法（JDK>=1.8）。

interface InterfaceOne{
    // 接口的静态字段：编译器会自动加上public statc final:
    int MALE = 1;
    int FEMALE = 2;

    void One();
}

// 接口继承
interface InterfaceTwo extends InterfaceOne{
    String Two();
}

// default方法
// 实现类可以不必覆写default方法。
// default方法的目的是，当我们需要给接口新增一个方法时，会涉及到修改全部子类。
// 如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
interface InterfaceThree{
    default void Three(){
        System.out.println("default");
    }
}

// 类实现多个接口
class InterfaceClass implements InterfaceTwo, InterfaceThree{
    @Override
    public void One(){};

    @Override
    public String Two(){
        return "Two";
    }
}