package 算法;

/**
 * @Description: 斐波那契数列 - 第N位的值
 * @Author
 * @Date 2024/1/29
 * @Version 1.0
 */
public class Fibonacci {
    public static void main(String[] args) {
//        System.out.println(calculate(10));
//        System.out.println(iterate(10));
        System.out.println(calculate2(10));
    }

    /**
     * 递归算法
     */
    private static int calculate(int num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        return calculate(num - 1) + calculate(num - 2);
    }

    /**
     * 递归算法-缓存值
     */
    private static int calculate2(int num){
        int[] arr = new int[num + 1];
        return recurse(arr,num);
    }

    private static int recurse(int[] arr,int num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        if (arr[num] != 0){
            return arr[num];
        }
        arr[num] = recurse(arr,num-1) + recurse(arr,num - 2);
        return arr[num];
    }


    /**
     * 双指针迭代算法
     */
    private static int iterate(int num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        int low = 0,high = 1;
        int sum = 0;
        for (int i = 2;i <= num; i++){
            sum = low + high;
            low = high;
            high = sum;
        }
        return sum;
    }
}
