package juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Demo
 * @Description:
 * @Author
 * @Date 2022/5/9
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
       Thread a =  new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "come in:\t " + (Thread.currentThread().isDaemon()?"守护线程":"用户线程"));
            while (true){

            }
        },"a");
       a.setDaemon(true);
       a.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + " task is over" );
    }
}
