/**
 * Writer is the "Producer" in the Producer/Consumer concurrency model,
 * which writes to the MyQueue buffer.
 * 
 * @author John Cook
 */
public class Writer extends Thread {
	MyQueue q;
		
	/** Constructor 
	 * @param qIn takes in the buffer
	 */
	public Writer(MyQueue qIn) {
		q = qIn;
	}
		public void run() {
		int item = 0;	// initialization for item to be written
		while (true) {
			/* run indefinitely */
			try {
				// write item to buffer
				q.write(item++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} /* while (true) */
	}
}