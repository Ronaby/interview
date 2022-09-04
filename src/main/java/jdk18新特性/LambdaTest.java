package jdk18新特性;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description:
 * @Author
 * @Date 2023/4/25
 * @Version 1.0
 */
public class LambdaTest {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r.run();
        System.out.println("--------------");
        Runnable r2 = ()->{
            System.out.println("我爱北京故宫");
        };
        r2.run();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("1111");
                System.out.println("2222");
                return o1.compareTo(o2);
            }
        };
       int c =  comparator.compare(10,12);
        System.out.println("c==="+ c);
        System.out.println("---------------");
        Comparator<Integer> comparator1 = ( o1, o2)-> {
                System.out.println("1111");
                System.out.println("2222");
                return o1.compareTo(o2);
            };
        int c1 =  comparator1.compare(10,12);
        System.out.println("c==="+ c1);
        System.out.println("----------------------");

        Comparator<Integer> comparator2 = Integer::compareTo;
        int a = comparator2.compare(10,9);
        System.out.println("a==="+a);

        System.out.println("---------");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hhhhh"+s);
            }
        };
        consumer.accept("hello");
        System.out.println("------------------------");
      Consumer<String> consumer1 =(String s)-> System.out.println("hhhhh"+s);
        consumer.accept("hello");

        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(">>>>>>"+s);
                return false;
            }
        };
     boolean res =    predicate1.test(">>>");
        System.out.println("res===" + res);

        System.out.println("*******");
        Predicate<String> predicate2 = (String s)-> {
                System.out.println(">>>>>>"+s);
                return false;
            };
        predicate2.test("111");
    }



}
