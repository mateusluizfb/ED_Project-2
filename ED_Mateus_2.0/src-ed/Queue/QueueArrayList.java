package Queue;

import Lists.ArrayList;

/**
 * Implementacao de uma Queue (Fila) usando ArrayList, a especificacao 
 * dos metodos herdados de AbstractQueue estah na Interface Queue 
 *  
 * Neste projeto iremos apenas usar a ArrayList do tipo primitivo 'int'
 * @author MateusLuiz
 */

public class QueueArrayList extends AbstractQueue{

	public QueueArrayList(){
		elements = new ArrayList();
	}
}
