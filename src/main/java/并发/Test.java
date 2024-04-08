package 并发;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Test
 * @Description:
 * @Author
 * @Date 2024/2/28
 * @Version 1.0
 */
public class Test {
    private volatile static int sum = 0;
    private static  String lock = "0";
    private static ReentrantLock reLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread thread = new Thread(() -> {
//                synchronized(lock) {
                reLock.lock();
                for (int j = 0; j < 10000; j++) {
                    sum++;
                }
                reLock.unlock();
//                }
            });
            thread.start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(sum);
    }
}
