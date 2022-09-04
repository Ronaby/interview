package juc;

import java.util.concurrent.*;

/**
 */
public class Future_task {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----come in");
            TimeUnit.SECONDS.sleep(2);
            return 1024;
        });
        new Thread(futureTask,"班长").start();
        System.out.println(Thread.currentThread().getName() + "阳哥继续讲课");
        System.out.println(futureTask.get());//不见不散，只要出现get方法不管是否计算完成，都被阻塞；
        System.out.println(futureTask.get(2L,TimeUnit.SECONDS));//过时不候；
        //不要阻塞，尽量用轮循替代
        while (true){
            if (futureTask.isDone()){
                System.out.println("--------reseut===" + futureTask.get());
                break;
            }else{
                System.out.println("还在计算中");
            }
        }
    }
}
