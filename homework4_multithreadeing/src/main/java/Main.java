import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(15);
        AtomicInteger value = new AtomicInteger();
        for (int i = 0; i < 1000; i++) {
            int task = i;
            customThreadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " processed the task " + task
                    + " with the result " + value.addAndGet(1)));
        }
        customThreadPool.shutdown();
    }
}
