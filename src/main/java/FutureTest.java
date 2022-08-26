import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTest {
    static int r = 0;

    public static void test1() {

        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(1);
            r = 10;
            System.out.println(r);
            return 100;
        });

        Thread thread = new Thread(task, "t1");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        /*
        FutureTask<Integer> futureTask = new FutureTask<>(() ->
        {
            System.out.println("hello,world");
            return 100;
        });
        new Thread(futureTask, "t3").start();

        try {
            Integer integer = futureTask.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         */
        //test1加了join, test1先执行，r=10，主线程r也等于10
        test1();
        System.out.println(r);
    }
}
