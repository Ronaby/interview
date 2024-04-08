package 算法;

import java.util.Arrays;

/**
 * @Description: 求数组中的中心下标
 * @Author
 * @Date 2024/1/27
 * @Version 1.0
 */
public class MidSubscript {
    public static void main(String[] args) {
        int index = getMidSubScript(new int[]{1,3,7,6,6,5});
        System.out.println(index);
    }
    private static int getMidSubScript(int[] nums){
       int sum =  Arrays.stream(nums).sum();
       int totol = 0;
       for (int i=0;i<nums.length;i++){
           totol += nums[i];
           if (totol == sum){
               return i;
           }
           sum = sum - nums[i];
       }
       return -1;
    }
}
