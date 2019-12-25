import java.util.StringJoiner;
import java.beans.*;

public class CoreClass{
    public static void main(String[] args) throws Exception{
        // String相关 https://www.liaoxuefeng.com/wiki/1252599548343744/1260469698963456 
        // StringBuilder是可变对象，用来高效拼接字符串
        var sb = new StringBuilder(1024);  
        sb.append("hello, ").append("zhouweiqi").insert(0, "haha, ");  // 链式操作，通过返回this实现
        System.out.println(sb.toString());

        // String.join()拼接字符串
        String[] names = {"zwq", "qwz", "qwq"};
        String join_str = String.join("-", names);
        System.out.println(join_str);

        // StringJoiner适用于拼接且前后添加字符串
        var sj = new StringJoiner("-", "hello, ", "!");
        for (String name : names){
            sj.add(name);
        }
        System.out.println(sj.toString());

        // 基础类型的包装类 --------------------------------------------------------------------------------------------
        //      基本类型	   对应的引用类型
        //      boolean	    java.lang.Boolean
        //      byte	    java.lang.Byte
        //      short	    java.lang.Short
        //      int	        java.lang.Integer
        //      long	    java.lang.Long
        //      float	    java.lang.Float
        //      double	    java.lang.Double
        //      char	    java.lang.Character

        // Integer.valueOf()就是静态工厂方法，它尽可能地返回缓存的实例以节省内存
        // 自动装箱
        Integer n = 100;  // 编译器自动转化 var n = Integer.valueOf(100);
        // 自动拆箱
        int x = n; // 编译器自动使用Integer.intValue()
        System.out.println(x);

        // 进制转换
        int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析
        System.out.println(x2);
        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

        // 包装类中常用静态变量
        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        // int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
        // long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)
        System.out.println(t);
        System.out.println(f);
        System.out.println(max);
        System.out.println(min);
        System.out.println(sizeOfLong);
        System.out.println(bytesOfLong);

        // 整数和浮点数的包装类型都继承自Number
        // 向上转型为Number:
        Number num = Integer.valueOf(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int i = num.intValue();
        long ln = num.longValue();
        float fl = num.floatValue();
        double d = num.doubleValue();
        System.out.println(b);
        System.out.println(i);
        System.out.println(ln);
        System.out.println(fl);
        System.out.println(d);

        // toUnsignedInt 转为无符号数

        // java.math.BigInteger用于表示任意大小的整数---------------------------------------------------------------
        // 对BigInteger做运算的时候，只能使用实例方法，例如，加法运算: add(); 乘法: multiply()
        // BigInteger是不变类，并且继承自Number
        // 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确

        // java.math.BigDecimal用于表示精确的小数，常用于财务计算；
        // 比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()  
        // 其他常用方法：
        //      scale() 获取小数位数
        //      stripTrailingZeros() 去除小数位末尾0
        //      setScale(4, RoundingMode.HALF_UP) RoundingMode.DOWN  设置小数位，采用四舍五入或截取
        //      add() 加法  
        //      multiply() 乘法
        //      divide()  除法
        //      divideAndRemainder()  除法获取商和余数

        // -----------------------------------------------------------------------------------------------------
        // Java提供的常用工具类有：  https://www.liaoxuefeng.com/wiki/1252599548343744/1260473555087392
        //      Math：数学计算
        //      Random：生成伪随机数
        //      SecureRandom：生成安全的随机数

        // 枚举类enum--------------------------------------------------------------------------------------------
        // 为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用enum来定义枚举类
        Weekday day = Weekday.SUN;
        System.out.println(day.name()); // 通过name()获取常量定义的字符串，注意不要使用toString()
        System.out.println(day.ordinal());  // 通过ordinal()返回常量定义的顺序（无实质意义）
        if (day == Weekday.SAT || day == Weekday.SUN){
            System.out.println(day + "休息");
        } else {
            System.out.println(day + "上班");
        }

        // 编译器编译枚举类类似如下
        // public final class Weekday extends Enum{   // 继承自Enum，标记为final class，无法被继承
        //     public static final Weekday SUN = new Weekday();   // 单例模式
        //     ...

        //     private Weekday(){};   // private构造方法，确保外部无法调用
        // }


        // JavaBean --------------------------------------------------------------------------------------------
        // JavaBean是一种符合命名规范的class，它通过getter和setter来定义属性
        // 使用Introspector.getBeanInfo()可以获取属性列表
        BeanInfo info = Introspector.getBeanInfo(Teacher.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }
}

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override  // 覆写toString()的目的是在输出时更有可读性
    public String toString() {
        return this.chinese;
    }
}

class Teacher {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}