package com.ronbay.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 */
@Slf4j
public class Juc_Thread_LockSupport {

    public static void main(String[] args) {
       Thread t0 =  new Thread(()->{
            Thread current = Thread.currentThread();
            log.info("{},开始执行",current.getName());
            for (;;){
                log.info("准备park当前线程:{}" ,current.getName());
                LockSupport.park();
                log.info("当前线程:{}已被唤醒",current.getName());
            }
        },"t0");
       t0.start();

        try {
            Thread.sleep(5000);
            log.info("准备唤醒:{}线程",t0.getName());
            LockSupport.unpark(t0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
    }

    //Lock的三大特性：
    /**
     * 1.自旋转
     * 2.LockSupport,
     * 3.通过cas算法加锁
     * 4.队列
     */
}
