package 并发;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author
 * @Date 2024/2/26
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        for (int i=0;i<100000;i++){
            Thread t = new Thread(()->{
                list.add(random.nextInt());
            });
            t.start();
            t.join();
        }
        System.out.println("总耗时=" + (System.currentTimeMillis() - start) + "ms");
    }
}
