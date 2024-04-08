package 算法.找到消失数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 找到数组中消失的数字
 * @Author
 * @Date 2024/4/8
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] arrays = {4,3,2,7,8,2,3,1};
        List<Integer> res = getDisappearNum(arrays);
        System.out.println(res);
    }

    private static List<Integer> getDisappearNum(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0;i < n;i++){
            int temp = nums[i];
            int x = (temp - 1)%n;
            nums[x] = nums[x] + n;
        }

        for (int i = 0;i < nums.length;i++){
            if (nums[i] <= n){
                res.add(i + 1);
            }
        }
        return res;
    }
}
