package org.cuatrovientos.larris.PSPBlockingQueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Consumer class- Collects the values that the Producer 
 * has previously placed in the container.
 **/
public class Consumer extends Thread {

    /**
     * The shared SynchronousQueue used by the Consumer to collect the values.
    */
    private SynchronousQueue<Integer> queue;
	
    /**
    * The specific number of different values that will be 
    * placed in the SynchronousQueue.
    */
    private static final int ITERATIONS_NUMBER = 10;

    /**
     * Constructor.
     *
     * @param queue
     * SynchronousQueue that will be used by the Consumer
     */
    public Consumer(SynchronousQueue<Integer> c) {
    	this.queue = c;
    }

     /**
       * Consumes an integer value from the SynchronousQueue and sleeps
       * the thread for half a second.
       */
    @Override
    public void run() {
        int value;
        for (int i = 0; i < Consumer.ITERATIONS_NUMBER; i++) {
            try {
				value = (Integer) queue.take();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}