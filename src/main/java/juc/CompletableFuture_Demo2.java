package juc;

import java.util.concurrent.*;

/**
 */
public class CompletableFuture_Demo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture.supplyAsync(()->{
            System.out.println("----");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        },threadPoolExecutor).whenComplete((v,e)->{
            if (e==null){
                System.out.println("------result" + v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            return null;
        });
    }
}
