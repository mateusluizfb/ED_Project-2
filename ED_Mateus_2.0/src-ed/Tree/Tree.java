package Tree;

public interface Tree {
	
	public void insert(int key);
	public Node find(int key);
	public void remove(int key);
	public void traverse(int type);
	public Node getRoot(); 

}
