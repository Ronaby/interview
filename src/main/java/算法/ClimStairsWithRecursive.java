package 算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ClimStairsWithRecursive
 * @Description: 递归爬楼梯
 * @Author
 * @Date 2024/4/2
 * @Version 1.0
 */
public class ClimStairsWithRecursive {
    private static Map<Integer, Integer> cacheMap = new HashMap<>();
    public static void main(String[] args) {
        int n = climStairs(5);
        System.out.println("n====" + n);
        int a = climStairsWithCache(5);
        System.out.println("a====" + a);
        int res = climStairsWithPre(5);
        System.out.println("res====" + res);
    }
    /**
     * 纯递归
     * @param n
     * @return
     */
    private static int climStairs(int n){
        if (n == 1){
            return 1;
        } else if (n == 2) {
            return 2;
        }else {
            return climStairs(n - 1) + climStairs(n - 2);
        }
    }

    /**
     * 递归 + 缓存
     * @param n
     * @return
     */
    private static int climStairsWithCache(int n){
        if (n == 1){
            return 1;
        } else if (n == 2) {
            return 2;
        }else {
            if (null != cacheMap.get(n)){
                return cacheMap.get(n);
            }else{
              int result =   climStairsWithCache(n - 1) + climStairsWithCache(n - 2);
              cacheMap.put(n,result);
              return result;
            }
        }
    }




    /**
     * 非递归用法
     * @param n
     * @return
     */
    private static int climStairsWithPre(int n){
        if (n==1){
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 2;
        int prePre = 1;
        int res = 0;
        for (int i = 3;i <= n; i++){
            res = pre + prePre;
            prePre = pre;
            pre = res;
        }
        return res;
    }

}
