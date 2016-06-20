package Stack;

	/**
	 * Interface Stack (pilha) dita os metodos
	 * padroes de uma Stack
	 * 
	 * Neste projeto iremos apenas usar Stack do tipo primitivo 'int'
	 * @author MateusLuiz
	 *
	 */

public interface Stack {

	/**
	 * 	Metodo que retorna se a Stack está vazia ou se tem 
	 * 	algum elemento
	 * 
	 * @return true ou false dependo de como estah a Stack
	 */
	public boolean isEmpty();
	
	/**
	 * Metodo que empilha um determinado valor 
	 * no topo da Stack
	 * 
	 * @param valor a ser empilhado na Stack
	 */
	public void push(int value);
	
	/**
	 * Metodo que retira e retorna o valor 
	 * do topo da Stack
	 * 
	 * @return valor do topo da Stack
	 */
	public int pop();
	
	/**
	 * Metodo que soh retorna o valor do 
	 * topo da Stack sem retirar
	 * 
	 * @return valor do topo da Stack
	 */
	public int top();
	
	/**
	 * Metodo que retorna o tamanho
	 * atual da Stack
	 * 
	 * @return tamanho da Stack
	 */
	public int size();
	
	/**
	 * Metodo que limpa todos os itens da Stack
	 */
	public void clear();
}
