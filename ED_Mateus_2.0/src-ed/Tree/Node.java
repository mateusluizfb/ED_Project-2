package Tree;

public class Node {
	
	private int value;
	private int height = 0;
	private Node rightChild = null;
	private Node leftChild = null;
	private Node parent = null;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
