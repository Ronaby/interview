package jdk18新特性;

import java.util.function.Predicate;

/**
 * @ClassName: Test1
 * @Description:
 * @Author
 * @Date 2023/4/25
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(">>>>>>"+s);
                return false;
            }
        };
        predicate1.test(">>>");
    }
}
