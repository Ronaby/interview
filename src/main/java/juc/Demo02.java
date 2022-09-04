package juc;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Demo02
 * @Description:
 * @Author
 * @Date 2022/5/11
 * @Version 1.0
 */
public class Demo02 {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<100;i++){
            new Thread(()->{
                for (int j=0;j<100;j++){
                    counter++;
                }
            }).start();

        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(counter);
    }
}
