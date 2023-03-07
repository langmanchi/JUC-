package Synchronized原理.普通;

public class Car {
    public synchronized void runing1(Thread thread){
        System.out.println(thread.getName()+ " car1 得到锁");
        System.out.println("------ car1 is running ------");
        working();
        System.out.println(thread.getName()+ " car1 释放锁");
        System.out.println();
    }

    public synchronized void runing2(Thread thread){
        System.out.println(thread.getName()+ " car2 得到锁");
        System.out.println("------ car2 is running ------");
        working();
        System.out.println(thread.getName()+ " car2 释放锁");
        System.out.println();
    }

    public static void  working(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Test01 {
    public static void main(String[] args) {
        Car car = new Car();
        //线程1
        Thread t1 = new Thread(){
            @Override
            public void run() {
                car.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t1.start();

        //线程2
        Thread t2 = new Thread(){
            @Override
            public void run() {
                car.runing2(Thread.currentThread()); //同步实例方法2
            }
        };
        t2.start();
    }
}
 class test02 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        //线程1 对象1
        Thread t1 = new Thread(){
            @Override
            public void run() {
                car1.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t1.start();

        //线程2 对象2
        Thread t2 = new Thread(){
            @Override
            public void run() {
                car2.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t2.start();
    }
}

