package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService executorServicePool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i=0;i<THREAD_COUNT;i++){
            executorServicePool.execute(new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("save Data");
                semaphore.release();
            }));
            executorServicePool.shutdown();
        }
    }
}
