package Tree;

import junit.framework.TestCase;

public class testBST extends TestCase {
	
	BST tree = new BST();

	protected void setUp() throws Exception {
		super.setUp();		
		
		tree.insert(55);
		tree.insert(44);
		tree.insert(66);
		tree.insert(22);
		tree.insert(77);
		tree.insert(56);
		tree.insert(54);
	}
	
	public void testFind(){
		
		assertEquals(null, tree.find(10));
		BSTNode temp;
		
		temp = tree.find(44);
		assertEquals(temp, tree.find(44));
		
		temp = tree.find(55);
		assertEquals(temp, tree.find(55));

		temp = tree.find(77);
		assertEquals(temp, tree.find(77));

	}
	
	public void testTraverse(){
		
		tree.traverse(1);
		tree.traverse(2);
		tree.traverse(3);
		
	}
	
	public void testRemove(){
		
		tree.remove(55); //root atual
		BSTNode temp = tree.getRoot();
		assertEquals(temp, tree.getRoot());
		
		
	}

}
