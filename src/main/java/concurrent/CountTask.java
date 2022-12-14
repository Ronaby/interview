package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 */
public class CountTask extends RecursiveTask<Integer> {

    private static int THRESHOLD = 2;//阈值
    private int start;
    private int end;
    int sum = 0;
    @Override
    protected Integer compute() {
        boolean canCompute = end - start <= THRESHOLD;
        if (canCompute){
            for (int i=start;i<end;i++){
                sum += i;
            }
        }else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) /2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle+1,end);
            int leftResult = leftTask.join();
            int rightResult =  rightTask.join();
            sum += leftResult + rightResult;
        }
        return sum;
    }

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask  = new CountTask(1,4);
        Future<Integer> future = forkJoinPool.submit(countTask);

        try {
           int result =  future.get();
            System.out.println("result==" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
