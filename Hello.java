/** * 自动创建文档注释 */

// import java.util.Scanner;
import java.util.Arrays;

// public 公开类/方法
// class 类
// Hello 类名首字母大写
public class Hello{
    // static 静态方法
    // void 返回值类型，表示无返回值
    // main 程序入口函数，规定必须为静态方法
    // String[] 参数类型
    // args 参数名
    public static void main(String[] args) {
        // 单行注释
        /* 多行
        注释 */
        System.out.println(Arrays.toString(args)); // 命令行参数列表
        System.out.println("hello world");

        /*
        基本数据类型:
            整数类型: byte(int8)，short(int16)，int(int32)，long(int64)
            浮点数类型: float，double
            字符类型: char
            布尔类型: boolean

        引用数据类型: 所有class和interface类型。引用类型的变量可以指向一个空值null，它表示不存在，即该变量不指向任何对象
            字符串String: 
                实为class，可以等价为：String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
                字符串使用双引号"..."表示开始和结束, 使用+连接任意字符串和其他数据类型
                java13特性, 可以用"""..."""表示多行字符串. `javac --source 13 --enable-preview Main.java`
                不可变类型
            数组:
                数组创建后大小不可改变
                array.length
        */

        int i1 = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000;        // 加下划线更容易识别
        int i4 = 0xff0000;             // 十六进制表示的16711680
        int i5 = 01111;                 // 八进制表示585
        int i6 = 0b1000000000;         // 二进制表示的512
        long l = 9000000000000000000L; // long型的结尾需要加L

        float f1 = 3.14f;
        float f2 = 3.14e38f;           // 科学计数法表示的3.14x10^38
        double d = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.9e-324;          // 科学计数法表示的4.9x10^-324

        boolean b1 = true;
        boolean b2 = false;
        boolean isGreater = 5 > 3;     // 计算结果为true
        int age = 12;
        boolean isAdult = age >= 18;   // 计算结果为false

        char c1 = 'A';
        char c2 = '中';
        int c1_code = 'A';     // 查看字符编码
        int c2_code = '中';
        char c3 = '\u0041';    // 'A'，十六进制0041 = 十进制65
        char c4 = '\u4e2d';    // '中'，十六进制4e2d = 十进制20013

        String s1 = "字符串";

        final double PI = 3.14;        // 常量

        int[] a1 = new int[5];
        String[] a2 = new String[] {"hhh", "jjj"};
        String[] a3 = {"aaa", "bbb"};
        System.out.println(Arrays.toString(a1));
        System.out.println(a1.length);
        System.out.println(a2);
        System.out.println(a3);

        int[][] a4 = {
            {1, 2, 3, 4},
            {6, 7, 2, 5}
        };
        System.out.println(Arrays.deepToString(a4));

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(i6);
        System.out.println(l);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(isGreater);
        System.out.println(isAdult);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1_code);
        System.out.println(c2_code);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(s1);
        System.out.println(PI);

        /*
        运算符: 
            >>> 符号位跟着位移
            对byte和short类型进行移位时，会首先转换为int再进行位移
            在运算过程中，如果参与运算的两个数类型不一致，那么计算结果为较大类型的整型。例如，short和int计算，结果总是int，原因是short首先自动被转型为int
            也可以将结果强制转型，即将大范围的整数转型为小范围的整数。要注意，超出范围的强制转型会得到错误的结果，原因是转型时，int的两个高位字节直接被扔掉，仅保留了低位的两个字节

            由于浮点数存在运算误差，所以比较两个浮点数是否相等常常会出现错误的结果。正确的比较方法是判断两个浮点数之差的绝对值是否小于一个很小的数
            整型和浮点型运算时，整型会自动提升为浮点型。需要特别注意，在一个复杂的四则运算中，两个整数的运算不会出现自动提升的情况
            整数运算在除数为0时会报错，而浮点数运算在除数为0时，不会报错，但会返回几个特殊值:
                NaN: 表示Not a Number
                Infinity: 表示无穷大
                -Infinity: 表示负无穷大

            可以将浮点数强制转型为整数。在转型时，浮点数的小数部分会被丢掉。如果转型后超过了整型能表示的最大范围，将返回整型的最大值

            三元运算符: b ? x : y
        */

        // ++n/n++的区别
        // ++age;
        // age++;
        // int next_age = ++age;   // 先自增后赋值
        int next_age = age++;      // 先赋值后自增
        System.out.println(age);
        System.out.println(next_age);

        // 长短int转换
        int i7 = 123456;  // 超出范围的强制转型会得到错误的结果
        short i8 = (short) i7;
        System.out.println(i7);
        System.out.println(i8);
        System.out.printf("i7: %x \n", i7);

        // 浮点数精度问题
        double d4 = 1.0 / 10;
        double d5 = 1 - 9.0 / 10;
        System.out.println(d4);  // 0.1
        System.out.println(d5);  // 0.09999999999999998

        // float/int类型转换
        int i9 = (int) 12.6;
        System.out.println(i9);

        // 三元运算符
        int i10 = 100;
        int i11 = i10 > 0 ? i10 : - i10;
        System.out.println(i11);

        /*
        流程控制: break和continue用法与其他语言一致
        */
        // 输入
        // var scanner = new Scanner(System.in);
        // System.out.print("input your name:");
        // String name = scanner.nextLine();
        // System.out.print("input your age:");
        // int myAge = scanner.nextInt();
        // System.out.println(name);
        // System.out.println(myAge);
        // scanner.close();

        // if
        String s2 = "hello";
        String s3 = "HELLO".toLowerCase();
        System.out.println(s2);
        System.out.println(s3);
        if (s2.equals(s3)) {    // 引用类型比较时, equals比较值，==比较引用
            System.out.println("s2 equals s3");
        } else {
            System.out.println("s2 not equals s3");
        }

        // switch: 穿透写法, 需要break跳出
        int option = 2;
        switch (option) {
        case 1:
            System.out.println("Selected 1");
            break;
        case 2:
        case 3:
            System.out.println("Selected 2, 3");
            break;
        default:
            System.out.println("Not selected");
            break;
        }

        // switch表达式新写法: 无穿透写法, 无需break  `javac --source 13 --enable-preview Main.java`
        // String fruit = "apple";
        // switch (fruit) {
        //     case "apple", "pear" -> System.out.println("Selected apple or pear");
        //     case "mango" -> {
        //         System.out.println("Selected mango");
        //         System.out.println("Good choice!");
        //     }
        //     default -> System.out.println("No fruit selected");
        //     }

        // yield: switch语句返回值
        // int opt = switch (fruit) {
        //     case "apple", "pear" -> 1;
        //     case "mango" -> 2;
        //     default -> {
        //         int code = fruit.hashCode();
        //         yield code;  // switch语句返回值
        //     }
        // };
        // System.out.println(opt);

        // while
        int sum = 0;
        // int n = 1;
        // while (n <= 100) {
        //     sum += n;
        //     n++;
        // }
        // System.out.println(sum);

        // do while
        // do {
        //     sum += n;
        //     n++;
        // } while (n<=100);
        // System.out.println(sum);

        // for
        for (int i=0; i<=100; i++) {
            sum += i;
        }
        System.out.println(sum);

        // for each: 遍历可迭代类型
        for (String s : a3){
            System.out.println(s);
        }
    }
}