package Lists;

class DLinkedNode {
	private int value;
	private DLinkedNode next;
	private DLinkedNode previous; 
	
	public DLinkedNode(int value) {
		this.value = value;
		next = null;
		previous = null;
	}

	public DLinkedNode getNext() {
		return next;
	}

	public void setNext(DLinkedNode next) {
		this.next = next;
	}

	public DLinkedNode getPrevious() {
		return previous;
	}

	public void setPrevious(DLinkedNode previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
}

public class DLinkedList implements List {
	protected int size; 
	protected DLinkedNode tail;
	protected DLinkedNode head; 
	
	public DLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	@Override
	public void insert(int pos, int value) {
		if(pos > 0 || pos <= size) {
			if(size == 0) {
				head = new DLinkedNode(value);
				tail = head;
			}
			else if(pos == 0) {
				DLinkedNode newNode = new DLinkedNode(value);
				newNode.setNext(head);
				head.setPrevious(newNode);
				head = newNode;
			}
			else {
				DLinkedNode temp = head; 
				for(int i = 0; i < pos - 1; i++) {
					temp = temp.getNext();
				}
				DLinkedNode newNode = new DLinkedNode(value);
				newNode.setNext(temp.getNext());
				newNode.setPrevious(temp);
				newNode.getNext().setPrevious(newNode);
				temp.setNext(newNode);
				if(pos < size) {
					newNode.getNext().setPrevious(newNode);
				} else {
					tail = newNode;
				}
			}
			size++;
		}
		else {
			throw new InvalidArgumentException();
		}
	}

	@Override
	public int find(int value) {
		DLinkedNode temp = head;
		for (int i = 0; i < size; i++){
			if(temp.getValue() == value){
				return i;
			}
		}
		throw new InvalidArgumentException();
	}

	public DLinkedNode findNode(int value) {
		DLinkedNode temp = head;
		for (int i = 0; i < size; i++){
			if(temp.getValue() == value){
				return temp;
			}
		}
		throw new InvalidArgumentException();
	}
	
	@Override
	public int elementAt(int pos) throws InvalidArgumentException {
		if (pos > 0 || pos <= size){
			DLinkedNode temp = head;
			for(int i = 0; i < pos; i++){
				temp = temp.getNext();
			}
			return temp.getValue();
		}
		throw new InvalidArgumentException();
	}

	@Override
	public void remove(int pos) throws InvalidArgumentException {
		if (pos > 0 || pos <= size){
			if (pos == 0){
				head = head.getNext();
			} else {
				DLinkedNode temp = head;
				DLinkedNode temp2 = head;
				for(int i = 0; i < pos - 1; i++){
					temp = temp.getNext();
				}
				for(int i = 0; i < pos + 1; i++){
					temp2 = temp2.getNext();
				}
				temp.setNext(temp.getNext().getNext());
				if (temp.getPrevious().getPrevious() != null){
					temp2.setPrevious(temp2.getPrevious().getPrevious());
				}
				if (pos == size){
					tail = temp;
				}
			}
			size--;
		} else {
			throw new InvalidArgumentException();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void show(boolean reverse) {
		if (reverse){
			DLinkedNode temp = tail;
			while(temp != null){
				System.out.println(temp.getValue());
				temp = temp.getPrevious();
			}
		} else {
			DLinkedNode temp = head;
			for (int i = 0; i < size; i++){
				System.out.println(temp.getValue());
				temp = temp.getNext();
			}
		}		
	}

	@Override
	public void swap(int index, int index2) {
		DLinkedNode temp = head;
		DLinkedNode temp2 = head;
		int i = 0;
		
		while (i != index){
			temp = temp.getNext();
			i++;
		}
		int smaller = temp.getValue();
		
		i = 0;
		while (i != index2){
			temp = temp.getNext();
			i++;
		}
		
		temp.setValue(temp2.getValue());
		temp2.setValue(smaller);
	}

	@Override
	public void addAll(int[] array) {
		DLinkedNode temp = head;
		
		for(int i = 0; i < size; i++){
			temp.setValue(array[i]);
			temp = temp.getNext();
		}
	}
}
