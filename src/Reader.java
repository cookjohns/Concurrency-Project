/**
 * Reader is the "Consumer" in the Producer/Consumer concurrency model,
 * which reads from the MyQueue buffer.
 * 
 * @author John Cook
 */
public class Reader extends Thread {
	MyQueue q;
		
	/** Constructor 
	 * @param qIn takes in the buffer
	 */
	public Reader(MyQueue qIn) {
		q = qIn;
	}
		
	public void run() {
		@SuppressWarnings("unused")
		int item;	// item to be read
		while (true) {
			/* run indefinitely */
			try {
				// read item from buffer
				item = q.read();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} /* while (true) */
	}
}