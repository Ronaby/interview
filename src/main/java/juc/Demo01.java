package juc;

import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName: Demo01
 * @Description:
 * @Author
 * @Date 2022/5/17
 * @Version 1.0
 */
public class Demo01 {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = null; //new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>(4),null);
//        Executors.newFixedThreadPool();
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,"A");
        treeMap.put(2,"B");
        treeMap.put(3,"C");
        treeMap.put(4,"D");
        treeMap.put(5,"E");
        treeMap.put(6,"F");
        SortedMap<Integer,String> sortedMap = treeMap.tailMap(2);
        System.out.println(">>>"+sortedMap.firstKey());
        int[] array = new int[3];
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");

        Iterator<String> iterator1 = names.iterator();

        while (iterator1.hasNext()){
            if ("a".equals(iterator1.next())){
                iterator1.remove();
            }
            System.out.println(">>>" + iterator1.next()); // 运行结
        }
    }

    private void sort(int[] num1,int[] num2){
        int[] copy_num = new int[num1.length];
        System.arraycopy(num1,0,copy_num,0,num1.length);

    }
}
