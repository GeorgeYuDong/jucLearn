import java.util.concurrent.TimeUnit;

public class TestA {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("ab");
        System.out.println(person.getName());

        person.setSchool("cd");
        System.out.println(person.getSchool());

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("china");
            }
            System.out.println("hello,world");
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("available cpu num is " + Runtime.getRuntime().availableProcessors());
            }
        });

        thread.start();
//        /*
        try {
            //join排队，必须跑完thread, thread1才能跑
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         */
        thread1.start();
        //Java开不了线程，通过调用本地方法(native method 底层的C++)调用

        //New, RUNNABLE,BLOCKED, TIMED_WAITING, WAITING, TERMINATED
        try {
            //睡一天
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //137 6471 6656 官希标


    }


}
