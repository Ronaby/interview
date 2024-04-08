package 算法;

/**
 * @ClassName: PrimeCount
 * @Description: 统计素数个数
 * @Author
 * @Date 2024/1/28
 * @Version 1.0
 */
public class PrimeCount {

    public static void main(String[] args) {
        System.out.println(getPrimeCount(100));
    }

    private static int getPrimeCount(int n){
        int count = 0;
        for (int i=2;i<n;i++){
            count += isPrime(i)? 1:0;
        }
        return count;
    }

    private static boolean isPrime(int n) {
        for (int i=2;i*i <= n;i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
