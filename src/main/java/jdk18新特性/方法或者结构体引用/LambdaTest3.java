package jdk18新特性.方法或者结构体引用;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author
 * @Date 2023/4/26
 * @Version 1.0
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        Supplier<Employee> supplier = Employee::new;
        Function<Employee,Employee> function = (Employee employee) ->employee;
    }
}
