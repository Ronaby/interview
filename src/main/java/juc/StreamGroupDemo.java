package juc;

import lombok.Data;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: StreamGroupDemo
 * @Description:
 * @Author
 * @Date 2022/9/6
 * @Version 1.0
 */

@Data
class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class StreamGroupDemo {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User u1 = new User("zhangsan",25);
        userList.add(u1);
        User u2 = new User("lisi",30);
        userList.add(u2);
        User u3 = new User("wangwu",20);
        userList.add(u3);
        userList.stream().collect(Collectors.groupingBy(User::getName)).forEach((key,value)->{
            value.stream().collect(Collectors.groupingBy(User::getAge)).forEach((key1,value1)->{
                System.out.println(value1);
            });
        });

    }
}
