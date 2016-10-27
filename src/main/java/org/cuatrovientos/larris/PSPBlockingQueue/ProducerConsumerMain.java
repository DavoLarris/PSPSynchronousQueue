package org.cuatrovientos.larris.PSPBlockingQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Main class to test the Producer-Consumer algorithm.
 */
public class ProducerConsumerMain {

    /**
    * Entry point of the application
    *
    * @param args
    */
    public static void main(String[] args) {
    	SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}