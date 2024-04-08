package jdk18新特性.方法或者结构体引用;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author
 * @Date 2023/4/26
 * @Version 1.0
 */
public class StreamApiTest {
    public static void main(String[] args) {
//        //创建stream的几种方式
//        // 1.通过集合的方式进行创建
//        List<Employee> list = new ArrayList<>();
//        Stream<Employee> stream = list.stream();
//        // 通过并行
//        Stream<Employee> employeeStream =  list.parallelStream();
//
//        // 2.通过数组的方式创建
//        int[] arr = {1,2,4,5};
//        IntStream intStream = Arrays.stream(arr);
//        //3.通过Stream的of
//        //4.创建无限流
//
//        list.stream().map(l->l.getName().toUpperCase()).forEach(System.out::println);
        List<String> list1 = Arrays.asList("bsa","dd","3242","rge");
        Stream<Stream<Character>> streamStream = list1.stream().map(StreamApiTest::fromStringToStream);
        streamStream.forEach(s->s.forEach(System.out::println));

        System.out.println("******************");
        Stream<Character> characterStream = list1.stream().flatMap(StreamApiTest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }


    public static Stream<Character> fromStringToStream(String str){
        List<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
