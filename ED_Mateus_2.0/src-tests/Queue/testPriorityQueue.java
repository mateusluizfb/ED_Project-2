package Queue;

import junit.framework.TestCase;

public class testPriorityQueue extends TestCase {

	private PriorityQueue queue = new PriorityQueue();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(10);
		queue.enqueue(7);
		queue.enqueue(50);
		
	}
	
	public void testDequeue(){
		
		int size = queue.size();
		
		for(int i = 0;i < size; i++){
			System.out.println(queue.dequeue());
		}
		
	}

}
