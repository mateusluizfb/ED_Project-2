package Stack;

import Lists.LinkedList;

/**
 * Implementacao de uma Stack (Pilha) usando Stack, a especificacao 
 * dos metodos herdados de AbstractQueue estah na Interface Stack 
 *  
 * Neste projeto iremos apenas usar a LinkedList do tipo primitivo 'int'
 * @author MateusLuiz
 */


public class StackLinkedList extends AbstractStack {
		
	public StackLinkedList() {
		elements = new LinkedList();
	}
}
