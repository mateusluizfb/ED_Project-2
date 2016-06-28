package Lists;

class LinkedNodeGeneric<T> {

	private T value;
	
	private LinkedNodeGeneric<T> next;
	
	public LinkedNodeGeneric(T value, LinkedNodeGeneric<T> n) {
		this.value = value;
		next = n;
	}
	
	public LinkedNodeGeneric(T value) {
		this.value = value;
		next = null;
	}
	
	public void setValue(T value){
		this.value = value;
	}
	
	public void setNext(LinkedNodeGeneric<T> next) {
		this.next = next;
	}
	
	public T getValue() {
		return value;
	}
	
	public LinkedNodeGeneric<T> getNext() {
		return next;
	}
}


public class LinkedListGeneric<T>  implements ListGeneric<T>{
	//por questoes de eficiencia, mantem o tamanho da lista. 
	private int size;
	
	//referencia para o primeiro no da lista. 
	private LinkedNodeGeneric<T> head;

	
	public LinkedListGeneric() {
		size = 0;
		head = null;
	}


	
	public void insert(int pos, T value) {
		if(pos >= 0 && pos <= size) {
			if(size == 0) { //caso mais simples, lista vazia
				head = new LinkedNodeGeneric<T>(value);
			}
			else if(pos == 0) { //insere na posicao de indice zero, mas a lista nao esta vazia!
				LinkedNodeGeneric<T> newNode = new LinkedNodeGeneric<T>(value, head);
				head = newNode;
			}
			else { //insere nas demais posicoes da lista. 
				LinkedNodeGeneric<T> temp = head; 
				for(int i = 0; i < pos-1; i++) {
					temp = temp.getNext();
				}
				LinkedNodeGeneric<T> newNode = new LinkedNodeGeneric<T>(value, temp.getNext());
				temp.setNext(newNode);
			}
			size++;
		}
		else { 
			throw new InvalidArgumentException();
		}
	}
	

	
	public int find(T value) throws InvalidArgumentException{
		LinkedNodeGeneric<T> temp = head;
		for(int i = 0; i < size; i++) {
			if(temp.getValue() == value) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}

	public T elementAt(int pos) {
		if(pos < 0 || pos >= size) {
			throw new InvalidArgumentException();
		}
		LinkedNodeGeneric<T> t = head;
		for(int i = 0; i < pos; i++) {
			t = t.getNext();
		}
		return t.getValue();
	}

	
	public void remove(int pos) {
		if(pos < 0 || pos >= size) {
			throw new InvalidArgumentException();
		}
		if(pos == 0) {
			head = head.getNext();
		}
		else {
			LinkedNodeGeneric<T> temp = head; 
			for(int i = 0; i < pos - 1; i++) {
				temp = temp.getNext();
			}
			//temp aponta para o elemento anterior 
			//ao que deve ser excluido. 
			temp.setNext(temp.getNext().getNext());		
		}		
		size--;
	}


	public int size() {
		return size;
	}
	
	public void show(boolean reverse) {
		if(!reverse) {
			LinkedNodeGeneric<T> temp = head;
			for(int i = 0; i < size; i++) {
				System.out.println(temp.getValue());
				temp = temp.getNext();
			}
		}
		else {
			for(int i = size - 1; i >= 0; i--) {
				System.out.println(elementAt(i));
			}
		}
	}


	public void swap(int index, int index2) {
		LinkedNodeGeneric<T> temp = head;
		LinkedNodeGeneric<T> temp2 = head;
		int i = 0;
		
		while(i != index){
			temp = temp.getNext();
			i++;
		}
		T smaller = temp.getValue();
		
		i = 0;
		while(i != index2){
			temp2 = temp2.getNext();
			i++;
		}
		
		temp.setValue(temp2.getValue());
		temp2.setValue(smaller);
	}
	
	public void setValue(T value){
		LinkedNodeGeneric<T> temp = head;
		temp.setValue(value);
	}


	public void addAll(T[] array) {
		LinkedNodeGeneric<T> temp = head;
		
		for(int i = 0; i < size; i++){
			temp.setValue(array[i]);
			temp = temp.getNext();
		}
		
	}
	
	public boolean hasItems(){
		return size == 0;
	}
	
	public boolean hasItem(T value){
		LinkedNodeGeneric<T> temp = head;
		for(int i = 0; i < size; i++) {
			if(temp.getValue() == value) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	
}
