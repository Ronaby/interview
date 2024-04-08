package 算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author
 * @Date 2024/1/17
 * @Version 1.0
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] res = selTwoNumberSum(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(res));
        int[] res1 = selTwoNumberSum1(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(res1));

    }

     //暴力解法
    private static int[] selTwoNumberSum(int[] numbers,int target){
        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //Map解法
    private static int[] selTwoNumberSum1(int[] numbers,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(target - numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return new int[0];
    }
}
