package 读写锁;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//多綫程的编程步骤
//资源类
public class Mycache {
    //创建map集合
    //volatile的使用方式
    private  volatile Map<String,Object> map = new HashMap<>();

    //创建读写锁的对象
    private ReadWriteLock rwlock = new ReentrantReadWriteLock();


    //放数据
    public void put(String key,Object value){
        //添加读锁
        rwlock.writeLock().lock();


        try {
            System.out.println(Thread.currentThread().getName()+"正在进行写操作"+key);
            //暂停一会
            TimeUnit.MICROSECONDS.sleep(300);
            //放数据
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写完了"+key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放写锁
            rwlock.writeLock().unlock();
        }

    }

    //取数据
    public Object get(String key){
        //添加读锁
        rwlock.readLock().lock();
        Object result = null;

        try {

            System.out.println(Thread.currentThread().getName()+"正在读取数据"+key);
            //暂停一会儿
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"取完了"+key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }

        return result;
    }

}

class ReadWriteLockDemo{
    public static void main(String[] args) {
        Mycache mycache = new Mycache();

        //先键五个线程放数据     创建线程从里面取数据
        for (int i = 1; i <=5 ; i++) {
            final int num = i;
            new Thread(()->{
                mycache.put(num+"",num+"");
            },String.valueOf(i)).start();
        }

        //创建线程收集数据
        for (int i = 1; i <=5 ; i++) {
            final int num = i;
            new Thread(()->{
                mycache.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}