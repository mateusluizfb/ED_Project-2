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
						 rebalance(parent);
						break;
					} else {
						current.setParent(parent);
					}
				} else {
					current = current.getRightChild();
					if (current == null){
						parent.setRightChild(newNode);
						rebalance(parent);
						break;
					} else {
						current.setParent(parent);
					}
				}
			}
		}
	}
	
	public void rebalance(Node node){
		balancear(node);
	
		if (node.getHeight() <= -2) {
            if (setarAltura(node.getLeftChild().getLeftChild()) >= setarAltura(node.getLeftChild().getRightChild())){
                node = rotacionarDireita(node);
            }else{
                node = rotacionarEsquerdaDireita(node);
            }
 
        } else if (node.getHeight() >= 2) {
            if (setarAltura(node.getRightChild().getRightChild()) >= setarAltura(node.getRightChild().getLeftChild())){
                node = rotacionarEsquerda(node);
            }else{
                node = rotacionarDireitaEsquerda(node);
            }
        }
 
        if (node.getParent() != null) {
            rebalance(node.getParent());
        } else {
            root = node;
        }
		
	}
	
	protected void balancear(Node... node){ 
		for(Node n: node){
			n.setHeight(setarAltura(n.getRightChild()) - setarAltura(n.getLeftChild()));
		}
	}
	
	protected int setarAltura(Node node){ 
		if (node == null){
			return -1;
		} else {
			return 1 + Math.max(setarAltura(node.getLeftChild()), setarAltura(node.getRightChild()));
		}
	}
	
	protected Node rotacionarDireita(Node node){
		
		Node temp = node.getLeftChild();
		temp.setParent(node.getParent());
		node.setLeftChild(temp.getRightChild());
		
		if(node.getLeftChild() != null){
			node.getLeftChild().setParent(node);
		}
		
		temp.setRightChild(node);
		node.setParent(temp);
		
		if (temp.getParent() != null) {
            if (temp.getParent().getRightChild() == node) {
            	temp.getParent().setRightChild(temp);
            } else {
            	temp.getParent().setLeftChild(temp);
            }
        }
		
		balancear(node, temp);
		
		return temp;
	}
	
	protected Node rotacionarEsquerda(Node node){
		
		Node temp = node.getRightChild();
		temp.setParent(node.getParent());
		node.setRightChild(temp.getLeftChild());
		
		if(node.getRightChild() != null){
			node.getRightChild().setParent(node);
		}
		
		temp.setLeftChild(node);
		node.setParent(temp);
		
		if (temp.getParent() != null) {
            if (temp.getParent().getRightChild() == node) {
            	temp.getParent().setRightChild(temp);
            } else {
            	temp.getParent().setLeftChild(temp);
            }
        }
		
		balancear(node, temp);
		
		return temp;
	}
	
	protected Node rotacionarEsquerdaDireita(Node node){
		node.setLeftChild(rotacionarEsquerda(node));
		
		return rotacionarDireita(node);
	}
	
	protected Node rotacionarDireitaEsquerda(Node node){
		node.setLeftChild(rotacionarDireita(node));
		
		return rotacionarEsquerda(node);
	}
	
	
}
