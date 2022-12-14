package concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 */
public class BankWaterService implements Runnable{
    //创建4个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier cyclicBarrier =  new CyclicBarrier(4);
    //假设只有4个sheet，所以只启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    int result = 0;

    private void count(){
        for (int i=0;i<4;i++){
            executor.execute(new Thread(()->{
                //计算当前sheet的银流数据，计算代码省略
                sheetBankWaterCount.put(Thread.currentThread().getName(),1);
            }));

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
// 汇总每个sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        // 将结果输出
        sheetBankWaterCount.put("result", result); System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}
