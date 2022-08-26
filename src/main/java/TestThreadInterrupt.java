import java.util.concurrent.TimeUnit;

public class TestThreadInterrupt {
    public static void main(String[] args) {
        try {
            test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
//        TimeUnit.SECONDS.sleep((long) 0.5);
        //打断sleep的线程，清空打断状态
        t1.interrupt();
        System.out.println("打断状态: " + t1.isInterrupted());
    }

    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if(interrupted) {
                    System.out.println("打断状态: " + interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        TimeUnit.SECONDS.sleep((long) 0.5);
        //打断正常运行的线程，非sleep, wait, join的线程，不会清空打断状态
        t2.interrupt();

    }


}
