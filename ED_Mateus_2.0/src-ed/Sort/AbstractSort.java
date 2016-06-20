package Sort;

import Lists.List;

/**
 * Interface AbstractSort que dita que todos
 * os Sorts precisam ter um metodo sort
 * 
 * Para este projeto todos as classes serao implementadas
 * com o tipo primitivo 'int'
 * @author MateusLuiz
 *
 */

public interface AbstractSort {
	
	/**
	 * Metodo que fica encarregado de receber e retornar
	 * um array do tipo List, independente da sua implementacao;
	 * 
	 * @param array recebe um 'array' do tipo List
 	 * @return um array ordenado do tipo List
	 */
	
	public List sort(List array);
	
}
