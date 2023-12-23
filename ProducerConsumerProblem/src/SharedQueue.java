import java.util.LinkedList;

public class SharedQueue {

    private final LinkedList<Integer> queue;
    private final int capacity;

    public SharedQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int item = queue.remove();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
