package juc;

import java.util.concurrent.*;

/**
 * CompletableFuture
 */
public class CompletableFuture_Demo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "测试代码");
        });

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in ");
        }, threadPoolExecutor);

        threadPoolExecutor.shutdown();
    }
}
