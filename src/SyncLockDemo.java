import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncLockDemo {
    public synchronized void add(){
        add();
    }

    public static void main(String[] args) {
        //Lock演示可重入锁
       Lock lock =  new ReentrantLock();
       //创建线程

        //写代码需要有上锁与解锁
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");

                try {
                    //上锁
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }finally {
                //释放锁
                lock.unlock();
            }

        },"t1").start();
        //new SyncLockDemo().add();
//        Object o = new Object();
//        new Thread(()->{
//            synchronized (o){
//                System.out.println(Thread.currentThread().getName()+"外层");
//
//                synchronized (o){
//                    System.out.println(Thread.currentThread().getName()+"中层");
//
//                    synchronized (o){
//                        System.out.println(Thread.currentThread().getName()+"内层");
//
//                    }
//                }
//
//            }
//        },"t1").start();
    }
}
