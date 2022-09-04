package juc;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * 打印对象的对象头信息
 */
@Slf4j
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("-------------------");

        new Thread(()->{
            synchronized (obj){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {

                }
                log.info(ClassLayout.parseInstance(obj).toPrintable());
            }
        }).start();



        new Thread(()->{
            synchronized (obj){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info(ClassLayout.parseInstance(obj).toPrintable());
            }
        }).start();
    }
}
