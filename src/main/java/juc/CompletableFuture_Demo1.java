package juc;

import java.util.concurrent.*;

/**
 * CompletableFuture_Demo1
 */

public class CompletableFuture_Demo1 {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName() + "\t" + "come in---");
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 11;
//        },threadPoolExecutor);
//
//        threadPoolExecutor.shutdown();
//
//        System.out.println("------"  + future3.get());
//
//        System.out.println("主线程 is over");

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 11;
        },threadPoolExecutor).thenApply((f)->{
            return f+2;
        }).whenComplete((v,e)->{
            if (v==null){
                System.out.println("result===" + v);
            }
        }).exceptionally((e)->{
            e.printStackTrace();
            return null;
        });

        System.out.println("主线程 is over");
        System.out.println(future4.get());
        threadPoolExecutor.shutdown();

    }
}
