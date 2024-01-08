package 大数据;

/**
 * @ClassName: ReentrentLockDemo01
 * @Description:
 * @Author
 * @Date 2023/5/11
 * @Version 1.0
 */
public class ReentrentLockDemo01 {
    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (objectLock){
                System.out.println("外层");
                synchronized (objectLock){
                    System.out.println("中层");
                    synchronized (objectLock){
                        System.out.println("内层");
                    }
                }
            }

        }).start();
    }
}
