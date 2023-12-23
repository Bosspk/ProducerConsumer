public class ProducerThread extends Thread {

    private final SharedQueue sharedQueue;

    public ProducerThread(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
           while(true){
               int item = produceItem();
               sharedQueue.produce(item);
               Thread.sleep(1000); // Simulate some work being done
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int produceItem() {
        return (int) (Math.random() * 100);
    }
}
