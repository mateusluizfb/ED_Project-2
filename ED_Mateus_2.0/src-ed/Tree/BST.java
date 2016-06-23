package Tree;

import Lists.InvalidArgumentException;

public class BST implements Tree{
	
	protected Node root;
	
	public BST(){
		root = null;
	}
	
	public Node find(int key){
		Node current = root;
		
		while(current.getValue() != key){
			
			if(key < current.getValue()){
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			if (current == null){
				return null;
			}
		}
		return current;
	}
	
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
						break;
					}
				} else {
					current = current.getRightChild();
					if (current == null){
						parent.setRightChild(newNode);
						break;
					}
				}
			}
		}
	}
	
	public void remove(int key){
		Node current = root;
		Node parent = root;
		boolean isLeft = true;
		
		while(current.getValue() != key){ //enquanto ele não encontrar o nó
			parent = current;
			if(key < current.getValue()){ // testa se é menor
				isLeft = true;
				current = current.getLeftChild(); // current passa ser o filho da esquerda
			} else { //se nao for o menor
				isLeft = false;
				current = current.getRightChild();  // current passa ser o filho da direita
			}
			if (current == null){ // se não existir esse nó na arvore ele joga uma exception
				throw new InvalidArgumentException();
			}
		}
		
		if (current.getLeftChild() == null && current.getRightChild() == null){ // se não tiver filhos
			if (current == root){
				root = null;
			} else if (isLeft){
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		} else if (current.getRightChild() == null){ // se nao tiver ramificação a direita
			if (current == root){
				root = current.getLeftChild();
			} else if (isLeft){
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		} else if (current.getLeftChild() == null){ // se nao tiver ramificação a esquerda
			if (current == root){
				root = current.getRightChild();
			} else if (isLeft){
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else { // possui dois filhos
			Node successor = getSucessor(current);
			
			if(current == root){
				root = successor;
			} else if(isLeft){
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			
			successor.setLeftChild(current.getLeftChild());
		}
	}
	
	protected Node getSucessor(Node nodeRemove){ //pegar o sucessor do node a ser removido para substituir
		Node successorParent = nodeRemove;
		Node successor = nodeRemove;
		Node current = nodeRemove.getRightChild();
		
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		
		if(successor != nodeRemove.getRightChild()){ // se o sucessor não for o nó  a direita do a ser excluido ele já cuida disso aqui
			successorParent.setLeftChild(successor.getRightChild());
			successor.setRightChild(nodeRemove.getRightChild());
		}
		return successor;
	}	
	
	public Node getRoot(){
		return root;
	}
	
	public void traverse(int type){	
		switch(type){
		
			case 1 :
				System.out.println("PreOrder: ");
				preOrder(root);
				break;
			case 2 :
				System.out.println("InOrder: ");
				inOrder(root);
				break;
			case 3 :
				System.out.println("PostOrder");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	protected void preOrder(Node localRoot){
		if(localRoot != null){
			System.out.print(localRoot.getValue() + " ");
			preOrder(localRoot.getLeftChild());
			preOrder(localRoot.getRightChild());
		}
	}
	
	protected void inOrder(Node localRoot){
		if(localRoot != null){
			preOrder(localRoot.getLeftChild());
			System.out.print(localRoot.getValue() + " ");			
			preOrder(localRoot.getRightChild());
		}
	}
	
	protected void postOrder(Node localRoot){
		if(localRoot != null){
			preOrder(localRoot.getLeftChild());
			preOrder(localRoot.getRightChild());
			System.out.print(localRoot.getValue() + " ");			
		}
	}
	
	
}
