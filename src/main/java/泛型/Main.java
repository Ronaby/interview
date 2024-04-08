package 泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Main
 * @Description:
 * @Author
 * @Date 2024/1/15
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        IntegerPrinter integerPrinter = new IntegerPrinter(123);
        integerPrinter.printf();
        //
        Printer<String> printer = new Printer("abc");
        printer.printf();

        //
        Printer<Integer> printer1 = new Printer(456);
        printer1.printf();

        print(123);
        print("abc");
        print(123L);

        List<String> list = new ArrayList<>();
        list.add("1235");
        list.add("1234");
        print1(list);
    }

    private static <T> void print(T content){
        System.out.println(content);
    }

    private static <T> void print1(List<?> content){
        System.out.println(content);
    }
}
