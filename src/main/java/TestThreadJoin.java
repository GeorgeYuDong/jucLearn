import java.util.concurrent.TimeUnit;

public class TestThreadJoin {

    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
//        test2();
        test3();
    }

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });

        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2 = 20;
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        long end = System.currentTimeMillis();
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("end - start: " + (end - start));
    }

    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 10;
        });
        long start = System.currentTimeMillis();
        t1.start();
        // 线程执行结束会导致 join 结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("end - start: " + (end - start));
    }
}
