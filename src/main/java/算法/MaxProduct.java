package 算法;

import java.util.Arrays;

/**
 * @Description: 数组中三个数成绩最大的乘积
 * @Author
 * @Date 2024/1/17
 * @Version 1.0
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(">>>");
        int max = sort(new int[]{1,2,3,4,5,6});
        System.out.println(max);

        System.out.println(getMaxMin(new int[]{1,2,3,4,5,6}));
    }

    private static int sort(int[] nums){
        Arrays.sort(nums);
        System.out.println(nums);
        int len = nums.length;
        return  Math.max(nums[0] * nums[1] * nums[len - 1],nums[len-1] * nums[len - 2] * nums[len - 3]);
    }

    private static int getMaxMin(int[] nums){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for (int x : nums){
            if (x < min1){
                min2 = min1;
                min1 = x;
            }else if (x < min2){
                min2 = x;
            }

            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2){
                max3 = max2;
                max2 = x;
            }else if (x > max3){
                max3 = x;
            }
        }
        return Math.max(min1 * min1 * max1,max1 * max2 * max3);
    }
}
