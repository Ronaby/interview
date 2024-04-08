package 并发;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author
 * @Date 2024/2/28
 * @Version 1.0
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        User user1 = new User("张三",20);
        User user2 = new User("李四",25);
        User user3 = new User("王五",23);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);
        //把user2赋值给atomicReference
        atomicReference.compareAndSet(user1,user2);
        System.out.println(atomicReference.get());
        //把user3赋值给atomicReference
        atomicReference.compareAndSet(user1,user3);
        System.out.println(atomicReference.get());

    }
}

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
