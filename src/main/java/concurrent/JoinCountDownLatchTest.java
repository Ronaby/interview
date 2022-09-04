package concurrent;

/**
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            Thread t0 =    new Thread(()->{
                System.out.println("thread1 finished");
            },"t0");

            Thread t2 =    new Thread(()->{
                System.out.println("thread2 finished");
            },"t2");

            t0.start();
            t2.start();
            try {
                t0.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("all thread finished");
        }
    }
}
