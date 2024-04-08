package 算法.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution
 * @Description: 求数组里两元素之和等于指定值
 * @Author
 * @Date 2024/4/3
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,12,18};
        int[] res = toSum(array,20);
        System.out.println("res===" + Arrays.stream(res).toArray());

        int[] res1 = toSumWithMap(array,20);
        System.out.println("res1===" + res1);
    }

    private static int[] toSum(int[] array,int target){
        int[] res = new int[2];
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] + array[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }


    private static int[] toSumWithMap(int[] array,int target){
        Map<Integer,Integer> containerMap = new HashMap<>();
        int[] res = new int[2];
        for (int i=0;i<array.length;i++){
            if (containerMap.get(target-array[i])!= null){
                res[0] = containerMap.get(target-array[i]);
                res[1] = i;
                break;
            }else {
                containerMap.put(array[i],i);
            }
        }
        return res;
    }


}
