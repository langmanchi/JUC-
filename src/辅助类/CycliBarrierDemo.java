package 辅助类;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//集齐7课龙族就可以召唤神龙  循环匝栏
public class CycliBarrierDemo {

    //创建固定值
    private static final int NUMBER = 7;



    public static void main(String[] args) {
       CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println(".....集齐7颗龙珠就可以召唤神龙");
        });

        for (int i = 1; i <= 7 ; i++) {
            new Thread(()->{
                try {
                System.out.println(Thread.currentThread().getName()+"星龙被收集到了");
                //等待
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
