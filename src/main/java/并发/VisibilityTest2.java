package 并发;


import java.util.HashSet;

/**
 * @Version 1.0
 */
public class VisibilityTest2 {
    private boolean flag = true;
    private int count;

    public void refresh(){
        System.out.println(Thread.currentThread().getName() + "修改flag:"+flag);
        flag = false;
    }

    public void load(){
        System.out.println(Thread.currentThread().getName() + "开始执行.....");
        while (flag){
            count++;
        }
        System.out.println(Thread.currentThread().getName() + "跳出循环: count=" + count);
    }

    public static void main(String[] args) {
        VisibilityTest2 test = new VisibilityTest2();
        // 线程threadA模拟数据加载场景
        Thread threadA = new Thread(() -> test.load(), "threadA");
        threadA.start();

        Thread thread2 = new Thread(()->test.refresh(),"thread2");
        thread2.start();

        HashSet set = new HashSet();
    }
}

