import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestThreadPark {
    public static void main(String[] args) {
        /*
        try {
            test3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       */
        test4();
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("park...");
            LockSupport.park();
            System.out.println("unpark...");
            System.out.println("打断状态：" + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep((long) 0.5);
        t1.interrupt();
    }

    private static void test4() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("park...");
                LockSupport.park();
                System.out.println("打断状态：" + Thread.currentThread().isInterrupted());
            }
        });
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        Thread.interrupted();
    }


}
