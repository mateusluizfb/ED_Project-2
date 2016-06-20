package Stack;

/**
 * Stack (pilha) criada para implementar o SymbolChecker.
 * 
 * Estah pilha usa o tipo primitivo 'char', diferente da 
 * interface Stack que usa 'int'
 * @author MateusLuiz
 *
 */

public class StackString{
	
	public String[] elements;
	public int size;
	
	public StackString(int size){
		elements = new String[size];
		size = 0;
	}
	
	public boolean isEmpty() {
		return (elements.length == 0);
	}
	

	public void push(String parts) {
		elements[size] = parts;
		size++;
	}

	public String pop() {
		String value = elements[size - 1];
		size--;
		return value;
	}

	
	public int size() {
		return elements.length;
	}

	
	public void clear() {
		int temp = size();
		for(int i = 0; i < temp; i++) {
			pop();
		}
	}


	public String top() {
		String value = elements[size-1];
		return value;
	}
}
