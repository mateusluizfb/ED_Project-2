package Tree;

public class AVL extends BST{
	
	public void insert(int key){
		Node newNode = new Node();
		newNode.setValue(key);
		
		if (root == null){
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			
			while(true){
				parent = current;
				if(key < current.getValue()){
					current = current.getLeftChild();
					if (current == null){
						parent.setLeftChild(newNode);
						newNode.setParent(parent);
						refreshHeight(newNode);
						break;
					}
				} else {
					current = current.getRightChild();
					if (current == null){
						parent.setRightChild(newNode);
						newNode.setParent(parent);
						refreshHeight(newNode);
						break;
					} else {
						current.setParent(parent);
					}
				}
			}
		}
	}
	
	public void refreshHeight(Node node){
		Node temp = node;
		while(temp.getParent() != null){
			newHeight(temp.getParent());
			temp = temp.getParent();
		}
		
		if(node.getParent().getParent() != null && node.getParent().getParent().getHeight() >= 2){
			if (node.getParent().getParent().getRightChild() == null){
//				if(height(node.getRightChild().getRightChild()) >= height(node.getRightChild().getLeftChild())){
						rotacionarDireita(node.getParent()); 
//				} else {
//					rotacionarDireitaEsquerda(node);  // TESTAR <------
//				}
			}
		}
		
		if (node.getParent().getParent() != null && node.getParent().getParent().getHeight() <= -2){
			if (node.getParent().getParent().getLeftChild() == null){
//				if (height(node.getLeftChild().getLeftChild()) >= height(node.getLeftChild().getRightChild())){
					rotacionarEsquerda(node.getParent()); 
//				} else {
//				 	rotacionarEsquerdaDireita(node); // TESTAR <------
//			 	}
			}
		}
	}
	
	public void newHeight(Node node){
		node.setHeight(height(node.getLeftChild()) - height(node.getRightChild()));
	}
	
	protected int height(Node node){ 
		
		if(node == null) {
			   return -1;
		}
     	if(node.getLeftChild() == null && node.getRightChild() == null) {
			   return 0;
		} else if(node.getLeftChild() == null) {
			   return 1+height(node.getRightChild());
		} else if(node.getRightChild() == null) {
			   return 1+height(node.getLeftChild());
		} else {
			   return 1 + Math.max(height(node.getLeftChild()),height(node.getRightChild()));
		}
	}
	
	public Node rotacionarDireita(Node node){
		
		Node temp = node.getParent();
		node.setParent(temp.getParent());
		temp.setParent(node);
		node.setRightChild(temp);
		
		if(temp == root){
			root.setLeftChild(null);
			root = temp.getParent();
			newHeight(temp);
		}
		newHeight(node);
		
		return node;
	}
	
	public Node rotacionarEsquerda(Node node){
		
		Node temp = node.getParent();
		node.setParent(temp.getParent());
		temp.setParent(node);
		node.setLeftChild(temp);
		
		if(temp == root){
			root.setRightChild(null);
			root = temp.getParent();
			newHeight(temp);
		}
		newHeight(node);	
		
		return node;
	}
	
	public void rotacionarDireitaEsquerda(Node node){
		node.setRightChild(rotacionarDireita(node.getRightChild()));		
		rotacionarEsquerda(node);
	}
	
	public void rotacionarEsquerdaDireita(Node node){
		node.setLeftChild(rotacionarEsquerda(node.getLeftChild()));		
		rotacionarDireita(node);
	}
	
}