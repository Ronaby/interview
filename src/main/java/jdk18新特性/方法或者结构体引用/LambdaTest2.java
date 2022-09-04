package jdk18新特性.方法或者结构体引用;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author
 * @Date 2023/4/25
 * @Version 1.0
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println("s========"+s);
        PrintStream printStream =  System.out;
        Consumer<String> consumer1 = printStream::println;
        consumer1.accept("4342423");
    }
}
