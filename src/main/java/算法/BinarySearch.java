package 算法;

/**
 * @Description: 用二分查找 实现sqrt方法，对某数开平方
 * @Author
 * @Date 2024/1/26
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(36));
    }

    private static int binarySearch(int x){
        int index = -1;
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (mid*mid <= x){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return  index;
    }
}
