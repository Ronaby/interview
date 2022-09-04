package juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Demo4
 * @Description:
 * @Author
 * @Date 2022/5/12
 * @Version 1.0
 */
@Slf4j
public class Juc01_Thread_LockSupport {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        Thread t0 = new Thread(()->{
            log.info("{}开始执行", Thread.currentThread().getName() );
            for (;;){
                log.info("准备park当前线程:{}",Thread.currentThread().getName());
                LockSupport.park();
                log.info("{}线程已经被唤醒",Thread.currentThread().getName());
            }
        },"t0");
        t0.start();

        try {
            TimeUnit.SECONDS.sleep(3);
            log.info("准备唤醒{}线程",Thread.currentThread().getName());
            LockSupport.unpark(t0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
