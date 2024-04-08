package 算法.移动零元素;

/**
 * @ClassName: Solution
 * @Description: 移动零元素
 * @Author
 * @Date 2024/4/6
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int a = 3,b=4;
        int tem = a;
        a = b;
        b = tem;

        System.out.println(a);
        System.out.println(b);
//        int[] nums = {0,1,0,3,12};
//        int[] res = moveWithZero(nums);
//        System.out.println(res);
    }

    private static int[] moveWithZero(int[] nums){
        if (nums.length == 0){
            return nums;
        }
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
               nums[j++] = nums[i];
            }
        }
        for (int i=j;j<nums.length;j++){
            nums[i] = 0;
        }
        return nums;
    }
}
