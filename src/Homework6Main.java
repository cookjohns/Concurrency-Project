/** 
 * Program: Homework Assignment 6, COMP 3220
 * Programmer: John Cook
 * Date: 3/29/2015, updated 4/2/2015
 * Purpose: to learn how to implement concurrent threads
 * Compile: 
 * Description: Creates a number of threads which read and write
 * 	concurrently to a single buffer.
 * 
 **/

public class Homework6Main {
	
	public static void main(String[] args) {
		
		// create queue
		MyQueue q = new MyQueue(100);
		
		// create threads
		Thread t1 = new Thread(new Reader(q));
		Thread t2 = new Thread(new Writer(q));
		Thread t3 = new Thread(new Reader(q));
		Thread t4 = new Thread(new Writer(q));
		
		// start threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}