import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private BlockingQueue<Runnable> runnableQueue = new LinkedBlockingQueue<>();
    private volatile boolean canWork = true;
    private final Object object = new Object();
    private WorkerThread[] workerThreads;

    public CustomThreadPool(int threadNumber) {
        if (threadNumber <= 0) {
            throw new IllegalStateException();
        }

        workerThreads = new WorkerThread[threadNumber];
        for (int i = 0; i < threadNumber; i++) {
            workerThreads[i] = new WorkerThread();

        }
    }

    public void execute(Runnable task) {
        if (task == null || !canWork) {
            throw new IllegalStateException();
        }

        synchronized (object) {
            runnableQueue.offer(task);
            object.notify();
        }
    }

    public void shutdown() {
        canWork = false;
        for (WorkerThread thread : workerThreads) {
            thread.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        private BlockingQueue<Runnable> task;
        private CustomThreadPool threadPool;


        @Override
        public void run() {
            try {
                while (!threadPool.canWork || !task.isEmpty()) {
                    Runnable runnable;
                    while ((runnable = task.poll()) != null) {
                        runnable.run();
                    }
                    Thread.sleep(10);
                }
            } catch (RuntimeException e) {
                throw new IllegalStateException();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
