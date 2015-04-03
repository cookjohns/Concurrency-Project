/**
 * MyQueue serves as the buffer that holds int items.
 * 
 * @author John Cook
 **/
public class MyQueue { 
	private int[] buffer;	// buffer for holding writes
	private int   nextIn;	// next spot to write in buffer
	private int   nextOut;	// next item to be read from buffer
	private int   filled;	// number of spots filled in buffer
	private int   size;		// total size of buffer
		
	/** Constructor
	 * @param sizeIn passes in desired size of the queue buffer
	 */
	public MyQueue(int sizeIn) {
		buffer  = new int [sizeIn];
		nextIn  = 1;
		nextOut = 1;
		filled  = 0;
		size    = sizeIn;
	}
	
	/**
	 * Writes to buffer
	 * @param item is the item to be written
	 */
	public synchronized void write(int item) throws InterruptedException {
		try {
			while (filled == size) wait();	// if the buffer is full, wait
			buffer[nextIn] = item;
			nextIn = (nextIn % size) + 1;
			filled++;
			notifyAll();
		} catch (InterruptedException e) {
			System.out.print("InterruptedException caught");
		}
	}
	
	/**
	 * Reads from buffer
	 * @return the int that was read from buffer
	 */
	public synchronized int read() throws InterruptedException {
		int item = 0;	// initialization for read item
		try {
			while (filled == 0) wait();	// if there no filled spots, wait
			item = buffer[nextOut];
			nextOut = (nextOut % size) + 1;
			filled--;
			notifyAll();
		} catch (InterruptedException e) {
			System.out.print("InterruptedException caught");
		}
		return item;
	}
}