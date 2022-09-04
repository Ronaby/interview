package juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Demo0
 * @Description:
 * @Author
 * @Date 2022/5/11
 * @Version 1.0
 */
public class Demo0 {
    private /*volatile*/ static boolean initFlag = false;

    private volatile static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{

            while (!initFlag){
                counter++;
            }
            System.out.println(Thread.currentThread().getName() + "当前线程嗅探到initFlag的状态发生改变");
        },"ThreadA").start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(()->{
            refresh();
        },"ThreadB").start();

    }
    public static void refresh(){
        System.out.println("refresh data......");
        initFlag = true;
        System.out.println("refresh data success......");
    }


}
