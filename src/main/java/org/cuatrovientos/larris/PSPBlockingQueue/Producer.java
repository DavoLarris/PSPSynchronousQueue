package org.cuatrovientos.larris.PSPBlockingQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * 
* Class Producer. It will put numbers on the SynchronousQueue (a sequence 
* of numbers from 0 to 9), waiting for the the consumer, which will
* consume one by one before being put the following number.
 */
public class Producer extends Thread {

    /**
     * The shared SynchronousQueue used by the Producer to put the 
     * values inside.
     */
    private SynchronousQueue<Integer> queue;

    /**
     * The specific number of different values that will be placed 
     * in the SynchronousQueue.
     */
    private static final int ITERATIONS_NUMBER = 10;

    /**
     * Constructor.
     *
     * @param queue
     * SynchronousQueue that will be used by the Producer
     */
    public Producer(SynchronousQueue<Integer> queue) {
    	this.queue = queue;
    }

    /**
     * Produces an integer value for the SynchronousQueue and sleeps 
     * the thread for half a second.
     */
    @Override
    public void run() {
       for (int i = 0; i < Producer.ITERATIONS_NUMBER; i++) {
    	   System.out.println("Productor. put" + i);
    	   try {
			queue.put(i);
		} catch (InterruptedException e1) {
			System.err.println(e1.getMessage());
		}
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}