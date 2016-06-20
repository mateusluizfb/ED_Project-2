package Lists;

/**
 * Uma especificacao do tipo lista usando 
 * a construcao <i>interface</i> da linguagem 
 * Java. 
 * 
 * <p>
 * 
 * Uma interface nao possui implementacao de comportamento, 
 * apenas especifica um conjunto de operacoes que caracteriza
 * um tipo. Eh o que existe de mais proximo a um tipo abstrato 
 * de dados. 
 * 
 * <p>
 * A principio, vamos assumir que lidamos apenas com 
 * listas de inteiros. Depois generalizamos isso. 
 * 
 * @author rbonifacio
 */
public interface List {
	/**
	 * Recupera a posicao do elemento na lista com valor 
	 * igual a <code>value</code>
	 * 
	 * @param value chave usada na busca. 
	 * 
	 * @return      Indice do elemento (zero <= res <= size()) usado como chave na busca. 
	 *              Caso o elemento nao seja encontrado, retorna <code>-1</code>.
	 */
	public int find(int value);
	
	/**
	 * Recupera o valor do elemento na posicao <code>pos</code>
	 * 
	 * @param  pos indice usado para recuperar o elemento. 
	 * @return    valor do elemento na posicao pos
	 * @throws InvalidArgumentException Caso <code>pos < 0</code> ou <code>pos >= size() </code>
	 */
	public int elementAt(int pos) throws InvalidArgumentException;
	
	/**
	 * Insere um valor (<code>value</code>) na posicao <code>pos</code>
	 * @param pos  posicao na lista a ser adicionado o valor
	 * @param value  valor a ser adicionado na lista. 
	 * @throws InvalidArgumentException Caso <code>pos < 0</code> ou <code>pos > size() </code>
	 */
	public void insert(int pos, int value) throws InvalidArgumentException;
	
	/**
	 * Remove o valor da lista na posicao pos
	 * @param pos posicao na lista do elemento a ser removido. 
	 * @throws InvalidArgumentException Caso <code>pos < 0</code> ou <code>pos >= size() </code>
	 */
	public void remove(int pos) throws InvalidArgumentException;
	
	/**
	 * Retorna a quantidade de elementos inseridos na lista.
	 * @return quantidade de elementos presentes na lista. 
	 */
	public int size();
	
	/**
	 * Exibe os elementos da lista em ordem reversa se 'true' e 
	 * em ordem normal de 'false'
	 * 
	 * @param reverse se a os elementos vao ser mostrados em ordem reversa ou nao
	 */
	
	public void show(boolean reverse);
	
	/**
	 * Troca o elemento 'um' pelo elemento 'dois'
	 * 
	 * @param index elemento um
	 * @param index2 elemento dois
	 */
	
	public void swap(int index, int index2);
	
	/**
	 * Recebe um array de inteiros e passa todos seus itens para 
	 * a Lista
	 * 
	 * @param array de inteiros
	 */
	
	public void addAll(int[] array);
}
