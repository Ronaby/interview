package 并发;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Description:
 * @Author
 * @Date 2024/2/28
 * @Version 1.0
 */
public class AtomaticIntegerTest {
    static int[] value = {1,2,3,4,5};
    static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);
    public static void main(String[] args) {
        //设置索引0 的值为100
        atomicIntegerArray.set(0,100);
        System.out.println(atomicIntegerArray.get(0));

        //以原子更新的方式将数组为1的元素与输入值相加
        atomicIntegerArray.getAndAdd(1,5);
        System.out.println(atomicIntegerArray);


    }
}
