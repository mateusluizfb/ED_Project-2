package Queue;

import Lists.LinkedList;

/**
 * Implementacao de uma Queue (Fila) usando LinkedList, a especificacao 
 * dos meotodos herdados de AbstractQueue esta na Interface Queue 
 *  
 * Neste projeto iremos apenas usar a LinkedList do tipo primitivo 'int'
 * @author MateusLuiz
 */

public class QueueLinkedList extends AbstractQueue{
	
	public QueueLinkedList() {
		elements = new LinkedList();
	}
	
}
