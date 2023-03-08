package pool;



import java.util.concurrent.*;

public class ThreadPoolDemo2 {


    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
               2,
               5,
               2L,
               TimeUnit.SECONDS,
               new ArrayBlockingQueue<>(3),
               Executors.defaultThreadFactory(),
               new ThreadPoolExecutor.AbortPolicy()
       );

        try {
            for (int i = 1; i <=20; i++) {
                //执行
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
