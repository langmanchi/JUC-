package Lock接口.lock;


import java.util.concurrent.TimeUnit;

class Phone{
    //锁的八种情况
    public synchronized void sendSMS() throws Exception{
        //停留4秒
       // TimeUnit.SECONDS.sleep(4);
        System.out.println("-------sendSMS");
    }

    public synchronized  void sendEmail() throws Exception{
        System.out.println("-------sendWmail");
    }
    public void getHello(){
        System.out.println("------getHello");
    }
}

//八个问题
/*
1 标准访问，先打印短信还是邮件


 */
public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2= new Phone();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        Thread.sleep(100);
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();

    }
}
