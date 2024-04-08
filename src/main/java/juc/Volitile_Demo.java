package juc;


/**
 * @Description:
 * @Author
 * @Date 2024/1/25
 * @Version 1.0
 */
public class Volitile_Demo {

    private volatile  boolean flag = true;
    private  int count = 0;

    private void refresh(){
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改flag后的值是:" + flag);
    }

    private void count(){
        System.out.println(Thread.currentThread().getName() + "开始执行...." );
        while (flag){
            ++count;
        }
        System.out.println("推出循环，count的值是:" + count);
    }

    public static void main(String[] args) {
         new Thread(()->{
             new Volitile_Demo().count();
         }).start();
        new Thread(()->{
            new Volitile_Demo().refresh();
        }).start();
    }
}
