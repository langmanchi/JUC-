package Lock接口.sync;


//第一步 创建资源类，定义属性和操作方法

class Share{
    //初始值
    private int number = 0;
    //+1的方法
    public synchronized void incr() throws InterruptedException {
       // 第二步 判断 干活 通知
        while (number != 0 ){//判断number值是否是0，如果不是没等待
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知其他线程
        this.notifyAll();

    }
    //-1的方法
    public synchronized void decr() throws InterruptedException {
        while (number != 1 ){//判断number值是否是0，如果不是没等待
            this.wait();
        }
        //干活
        number-- ;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知其他线程
        this.notifyAll();
    }

}


//虚假唤醒线程
public class ThreadDemo1 {
    //第三步 创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {
        Share share = new Share();
        //创建线程
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.incr();//+1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.decr();//-1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();


    }
}
