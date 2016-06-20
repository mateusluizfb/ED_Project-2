package Lists;

import java.util.Arrays;

public class ArrayList implements List{

	private static int MAX_SIZE = 10;   
	private static final int NOT_FOUND = -1;        	
	
	
	public int[] elements;
	
	protected int size; 

	public ArrayList() {
		size = 0;
		elements = new  int[MAX_SIZE]; 
	}
	public int[] getArray(){
		return elements;
	}
	
	public int find(int v) {
		for(int i = 0; i < size; i++) {
			if(v == elements[i]) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	
	public int elementAt(int pos)  {
		if(pos >= 0 && pos < size) {
		   return elements[pos];
		}
		throw new InvalidArgumentException();
	}
	
	
	public void insert(int pos, int v) {
		if (size == MAX_SIZE){
			elements = Arrays.copyOf(elements, size * 2);
			MAX_SIZE = size * 2;
		}
		
		if(pos == size) {
			elements[size] = v; 
		}
		else { 
			for(int i = size; i > pos; i--) {
				elements[i] = elements[i-1];
			}
			elements[pos] = v;
		}
		size++;
		
	}
	
	
	public void remove(int pos) {
		if(pos >= 0 && pos < size) {
			for(int i = pos; i < size-1; i++) {
				elements[i] = elements[i+1];
			}
			size--;
		}
		else {
			throw new InvalidArgumentException();
		}
	}

	
	public int size() {
		return size; 
	}

	public void show(boolean reverse) {
		if (!reverse){
			for(int i=0; i < size; i++){
				System.out.print(elements[i] + " ");
			}
		} else {
			for(int i=size; i >= 0; i--){
				System.out.print(elements[i] + " ");
			}
		}
	}

	public void swap(int index, int index2){
		int smaller = elements[index];
		elements[index] = elements[index2];
		elements[index2] = smaller;
	}
	@Override
	public void addAll(int[] array) {
		// TODO Auto-generated method stub
		
	}

	
}
