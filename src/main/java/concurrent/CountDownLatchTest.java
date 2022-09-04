package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchTest
 * @Description:
 * @Author
 * @Date 2022/6/24
 * @Version 1.0
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
            new Thread(()->{
                System.out.println("111");
                countDownLatch.countDown();
                System.out.println("222");
                countDownLatch.countDown();
            }).start();
            countDownLatch.await();
            System.out.println("333");
    }
}
