import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        Thread t1=new Thread(() -> {
            String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSS"));
            System.out.println("孙迅 当前时间："+time);
        });
        Thread t2=new Thread(() ->{
            String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSS"));
            System.out.println("孙迅 当前时间："+time);
        });
        Thread t3=new Thread(() ->{
            String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.SSS"));
            System.out.println("孙迅 当前时间："+time);
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("所有子线程执行完毕，主线程结束");
    }
}
