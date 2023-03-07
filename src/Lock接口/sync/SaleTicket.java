package Lock接口.sync;

class Ticket{
    //票数
    private int number = 30;
    //操作方法：卖票
    public   synchronized void sale(){
        //判断：是否有票
         if (number > 0){
             System.out.println(Thread.currentThread().getName()+":卖出："+number--+"剩下"+number);
         }
    }
}
public class SaleTicket {
    //Synchronized关键字复习
       // 第二步 创建多个线程  创建线程的多种方式 4种，耐心分析
    public static void main(String[] args) {
       //多线程卖票的步骤  多线程编程的步骤

        // 1 创建资源类，在资源类创建属性和操作方法
        // 2 创建多个线程，调用资源类的操作方法
        // 高内聚，低耦合的思想

        //3个售票员卖出30张票
        Ticket ticket = new Ticket();
        //创建三个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }

            }
        },"AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }

            }
        },"BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //调用卖票方法
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }

            }
        },"CC").start();

    }
}
