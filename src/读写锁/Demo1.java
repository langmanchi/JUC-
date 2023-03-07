package 读写锁;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo1 {

    public static void main(String[] args) {

        //可重入读写锁对象
        ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwlock.readLock();//读锁
        ReentrantReadWriteLock.WriteLock writeLock = rwlock.writeLock();//写锁


        //锁降级
        //1 获取写锁
        writeLock.lock();
        System.out.println("atguigu");

        //2 获取读锁
        readLock.lock();
        System.out.println("--read");


        //3 释放写锁
        writeLock.unlock();

        //4 释放读锁
        readLock.unlock();
    }



}
