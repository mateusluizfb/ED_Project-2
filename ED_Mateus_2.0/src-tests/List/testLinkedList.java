package List;

import Lists.LinkedList;
import Lists.List;
import junit.framework.TestCase;

public class testLinkedList extends TestCase {

	List ld = new LinkedList();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		ld.insert(0, 1);
		ld.insert(1, 2);
		ld.insert(2, 3);
		ld.insert(3, 4);
	}
	
	public void testRemove(){
		
		ld.remove(4);
		
		assertEquals(1, ld.elementAt(0));
		assertEquals(2, ld.elementAt(1));
		assertEquals(3, ld.elementAt(2));
		
		
	}

}
