package Tree;

import junit.framework.TestCase;

public class testAVL extends TestCase {
	
	public void testHeightLeft(){
		
		Tree tree = new AVL();
		
		tree.insert(55);
		tree.insert(44);
		tree.insert(40);
		
		assertEquals(0,tree.find(55).getHeight());
		assertEquals(0,tree.find(44).getHeight());
		assertEquals(0,tree.find(40).getHeight());
	
	}
	
	public void testHeightWithMoreThanThreeElementsLeft(){
	
		Tree tree = new AVL();
		
		tree.insert(55);
		tree.insert(44);
		tree.insert(40);
		tree.insert(30);
		
		assertEquals(0,tree.find(55).getHeight());
		assertEquals(1,tree.find(44).getHeight());
		assertEquals(1,tree.find(40).getHeight());
		assertEquals(0,tree.find(30).getHeight());
	
	}
	
	public void testHeightRight(){
		
		Tree tree = new AVL();
		
		tree.insert(55);
		tree.insert(66);
		tree.insert(77);
		
		assertEquals(0, tree.find(66).getHeight());
		assertEquals(0, tree.find(55).getHeight());
		assertEquals(0, tree.find(77).getHeight());
		
	}
	
	public void testHeightWithMoreThanThreeElementsRight(){
		
		Tree tree = new AVL();
		
		tree.insert(55);
		tree.insert(66);
		tree.insert(77);
		tree.insert(88);
				
		assertEquals(0,tree.find(55).getHeight());
		assertEquals(-1,tree.find(66).getHeight());
		assertEquals(-1,tree.find(77).getHeight());
		assertEquals(0,tree.find(88).getHeight());
		
	}
	
	public void testHeightWithMoreThanOneSubtree(){
		
		Tree tree = new AVL();
		
		tree.insert(55);
		tree.insert(44);
		tree.insert(40);
		tree.insert(66);
		tree.insert(63);
		
		System.out.println(tree.find(55));
		System.out.println(tree.find(44));
		System.out.println(tree.find(40));
		System.out.println(tree.find(66));
		System.out.println(tree.find(63));
		
//		assertEquals(0, tree.find(55));
//		assertEquals(1, tree.find(44));
//		assertEquals(0, tree.find(40));
//		assertEquals(1, tree.find(66));
//		assertEquals(0, tree.find(63));
		
	}
	
	
	
//	public void testFind(){
//		
//		assertEquals(null, tree.find(10));
//		Node temp;
//		
//		temp = tree.find(44);
//		assertEquals(temp, tree.find(44));
//		
//		temp = tree.find(55);
//		assertEquals(temp, tree.find(55));
//
//		temp = tree.find(77);
//		assertEquals(temp, tree.find(77));
//
//	}
//	
//	public void testTraverse(){
//		
//		tree.traverse(1);
//		tree.traverse(2);
//		tree.traverse(3);
//		
//	}
//	
//	public void testRemove(){
//		
//		tree.remove(55); //root atual
//		Node temp = tree.getRoot();
//		assertEquals(temp, tree.getRoot());
//		
//		
//	}
	
}
