package JUC概述;

public class Main {
    public static void main(String[] args) {
     Thread aa = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"::"+Thread.currentThread().isDaemon());
            //isDaemon是用户线程还是守护线程 false是用户，true是守护
            while (true){

            }
        },"aa");

     //设置守护线程
     aa.setDaemon(true);
     aa.start();


     System.out.println(Thread.currentThread().getName()+" over");
    }
}
