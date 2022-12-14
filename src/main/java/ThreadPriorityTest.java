public class ThreadPriorityTest {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println("---->1 " + count++);
            }
        };
        Runnable task2 = () -> {
            int count = 0;
            for (int i = 0; i < 10000; i++) {
                // Thread.yield();
                System.out.println(" ---->2 " + count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");

        //cpu 闲暇时， 优先级不一定有用
        //cpu 忙时优先级高的会获得更多时间片
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

    }
}
