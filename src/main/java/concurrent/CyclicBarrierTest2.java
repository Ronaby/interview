package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 */
public class CyclicBarrierTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new  Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("111");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("222");
    }

    public static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("3333");
        }
    }
}
