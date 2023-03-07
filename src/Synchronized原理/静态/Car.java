package Synchronized原理.静态;


public class Car {
    public synchronized void runing1(Thread thread){
        System.out.println(thread.getName()+ " car1 得到锁");
        System.out.println("------ car1 is running ------");
        working();
        System.out.println(thread.getName()+ " car1 释放锁");
        System.out.println();
    }


    public static synchronized void staticRuning1(Thread thread){
        System.out.println(thread.getName()+ " static car1 得到锁");
        System.out.println("------ static car1 is running ------");
        working();
        System.out.println(thread.getName()+ " static car1 释放锁");
        System.out.println();
    }
    public static synchronized void staticRuning2(Thread thread){
        System.out.println(thread.getName()+ " static car2 得到锁");
        System.out.println("------ static car2 is running ------");
        working();
        System.out.println(thread.getName()+ " static car2 释放锁");
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

class test02 {
    public static void main(String[] args) {

        //线程1 类
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Car.staticRuning1(Thread.currentThread()); //同步类方法1
            }
        };
        t1.start();

        //线程2 类
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Car.staticRuning2(Thread.currentThread()); //同步类方法2
            }
        };
        t2.start();
    }
}

 class test03 {
    public static void main(String[] args) {
        Car car = new Car();
        //线程1 实例对象
        Thread t1 = new Thread(){
            @Override
            public void run() {
                car.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t1.start();


        //线程2 类
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Car.staticRuning2(Thread.currentThread()); //同步类方法2
                //面试中一个面试官问如果静态方法通过实例来调用，那锁的是实例还是类呢？
                //当然还是类了，这里可以把Car.staticRuning2改成car.staticRuning2，通过实例对象来调用静态方法
                //结果还是一样的。
            }
        };
        t2.start();
    }
}
