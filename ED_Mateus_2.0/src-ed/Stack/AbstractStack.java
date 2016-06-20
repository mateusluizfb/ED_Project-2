package Stack;

import Lists.List;

	/**
	 * Implentacao abstrata de uma Stack (Pilha), a descricao de
	 * cada metodo estah na documentacao da Interfaace Stack
	 * 
	 * Neste Projeto iremos apenas usar a Stack do tipo primitivo Stack
	 * @author MateusLuiz
	 */

public abstract class AbstractStack implements Stack{
	
	public List elements;
	
	public boolean isEmpty() {
		return (elements.size() == 0);
	}
	

	public void push(int value) {
		elements.insert(elements.size(), value);
	}

	
	public int pop() {
		int value = elements.elementAt(elements.size()-1);
		elements.remove(elements.size() - 1);
		return value;
	}

	
	public int size() {
		return elements.size();
	}

	
	public void clear() {
		int temp = size();
		for(int i = 0; i < temp; i++) {
			pop();
		}
	}


	public int top() {
		int value = elements.elementAt(elements.size()-1);
		return value;
	}

}
