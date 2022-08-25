public class Test {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("ab");
        System.out.println(person.getName());

        person.setSchool("cd");
        System.out.println(person.getSchool());

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("china");
            }
            System.out.println("hello,world");
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("available cpu num is " + Runtime.getRuntime().availableProcessors());
            }
        }).start();

        //Java开不了线程，通过调用本地方法(native method 底层的C++)调用
    }


}
