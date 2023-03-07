package Lock接口.sync;

public class Sale {
    private int number = 30;

    synchronized void sell(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+":卖出："+number--+"剩下"+number);
        }
    }
}

class Demo{
    public static void main(String[] args) {
        Sale sale = new Sale();

        //创建线程的三个方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                   sale.sell();
                }
            }
        },"aa").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    sale.sell();
                }
            }
        },"bb").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    sale.sell();
                }
            }
        },"cc").start();

    }

}