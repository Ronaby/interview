package 算法.合并两个数组;

import java.util.Arrays;

/**
 * @Description:合并两个数组
 * @Author
 * @Date 2024/4/3
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] res = mergeArray(nums1,3,nums2,nums2.length);
        System.out.println("res====" + res);

//        int[] res1 = mergeArrayWithDoublePointer(nums1,3,nums2,nums2.length);
//        System.out.println("res1====" + res1);

//          int[] res2 = mergeWithNoSpace(nums1,3,nums2,nums2.length);
//          System.out.println("res2===" + res2);
    }
    /**
     * 借助原有函数
     */
    private static int[] mergeArray(int[] nums1,int m,int[] nums2,int n){
        for(int i = 0;i < n;i++){
            nums1[m++] =  nums2[i];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 双指针写法
     */
    private static int[] mergeArrayWithDoublePointer(int[] nums1,int m,int[] nums2,int n){
        int k = m + n;
        int[] temp = new int[k];
        for (int index = 0,nums1Index=0,nums2Index=0;index < k;index++){
            if (nums1Index >= m){
                temp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                temp[index] = nums1[nums1Index++];
            }else if (nums1[nums1Index] < nums2[nums2Index]){
                temp[index] = nums1[nums1Index++];
            } else {
                temp[index] = nums2[nums2Index++];
            }
        }
        for (int i=0;i<k;i++){
            nums1[i] = temp[i];
        }
        return nums1;
    }

    /**
     * 不引入临时数组
     */
    private static int[] mergeWithNoSpace(int[] nums1,int m,int[] nums2,int n){
        int k = m + n;
        for (int index=k-1,nums1Index = m-1,nums2Index = n-1; index >= 0;index--){
            if (nums1Index < 0){
                //nums1的值取完，直接取nums2的值
                nums1[index] = nums2[nums2Index--];
            }else if (nums2Index < 0) {
                //nums2的值取完，直接取nums1的值
                break;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            }else {
                nums1[index] = nums2[nums2Index--];
            }
        }
        return nums1;
    }
}
