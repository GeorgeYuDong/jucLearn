import java.io.FileReader;

public class ThreadInherit extends Thread{

    @Override
    public void run() {
        System.out.println("hello,world");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadInherit threadInherit = new ThreadInherit();
        threadInherit.start();

    }
}
