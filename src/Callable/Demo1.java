package Callable;

//比较两个接口
//实现Runnable接口

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
}

//实现Callable接口

class MyThread2 implements Callable{
    @Override
    public Integer call() throws Exception {
        return 200;
    }
}
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //Runnable接口创建线程

        new Thread(new MyThread1(),"AA").start();

        //Callable接口

        //FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        //lam表达式
        FutureTask<Integer> futureTask1 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"come in callable");
            return 1024;
        });


        new Thread(futureTask1,"Lucy").start();
        while (!futureTask1.isDone()){
            System.out.println("wait......");
        }

        //调用FutureTask的get方法
        System.out.println(futureTask1.get());

        System.out.println(futureTask1.get());

        System.out.println(Thread.currentThread().getName()+"come over");
        //FutureTask原理 未来任务
        //对未来任务的理解分析

        /*
           在不影响主线程的情况下
           1老师上课，口渴了，去买票不合适，讲课线程继续

           2 4个同学 1:1+2+。。+5 2:10+11+12+。。+50 3:60+61+62 4：100+101
           第二个同学计算量大

         */



    }


}
