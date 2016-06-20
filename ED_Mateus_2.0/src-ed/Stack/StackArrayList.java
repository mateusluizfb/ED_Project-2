package Stack;

import Lists.ArrayList;

/**
 * Implementacao de uma Stack usando ArrayList, a especificacao
 * dos metodos herdados de AbstractQueue estah na Interface Stack
 * 
 * Neste projeto iremos apenas usar a ArrayList do tipo primitivo 'int'
 * @author MateusLuiz
 */

public class StackArrayList extends AbstractStack {
	
	public StackArrayList(){
		elements = new ArrayList();
	}
}
