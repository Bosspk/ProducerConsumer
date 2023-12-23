public class Main {
    public static void main(String[] args) {

        SharedQueue queue = new SharedQueue(5);
        ProducerThread producerThread = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);
        producerThread.start();
        consumerThread.start();
    }
}