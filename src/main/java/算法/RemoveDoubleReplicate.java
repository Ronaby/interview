package 算法;

/**
 * @Description: 去除重复元素---快慢指针
 * @Author
 * @Date 2024/1/28
 * @Version 1.0
 */
public class RemoveDoubleReplicate {

    public static void main(String[] args) {
        System.out.println(removeDoubleRepli(new int[]{0,1,2,2,3,3,4}));
    }

    private static int removeDoubleRepli(int[] nums){
      if (nums.length == 0){
          return 0;
      }
      int i = 0;
      for (int j=1;j<nums.length;j++){
          if (nums[i] != nums[j]){
              i++;
              nums[i] = nums[j];
          }
      }
      return i + 1;
    }
}
