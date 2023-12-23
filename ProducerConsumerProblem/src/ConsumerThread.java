public class ConsumerThread extends Thread {
    private final SharedQueue sharedQueue;

    public ConsumerThread(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
           while(true){
                int item = sharedQueue.consume();
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

