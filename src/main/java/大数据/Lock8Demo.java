package 大数据;

import java.util.concurrent.TimeUnit;

/**
 */
class Phone{
    public static synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------sendEmail");
    }

    public synchronized void sendSms(){
        System.out.println("-------sendSms");
    }

    public void hello(){
        System.out.println("------hello");
    }
}
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendEmail();
        },"a").start();

        new Thread(()->{
            phone2.sendSms();
        },"b").start();


    }
}
