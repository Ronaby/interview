package 并发;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author
 * @Date 2024/2/26
 * @Version 1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<100000;i++){
//            executorService.submit();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        System.out.println("总耗时==" + (System.currentTimeMillis() - start));
        Thread a= new Thread();
        a.start();
    }
}
