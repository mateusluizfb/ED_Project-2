package Queue;

	/**
	 * Interface Queue (Fila) dita os metodos 
	 * basicos para o Tipo Abstrato Queue
	 * 
	 * Neste projeto iremos apenas usar a Queue do tipo primitivo 'int'
	 * @author MateusLuiz
	 */

public interface Queue{
	
	/**
	 * Checa se a Queue estah cheia ou vazia
	 * 
	 * @return true ou false dependendo de como estah a Queue
	 */
	public boolean isEmpty();
	
	/**
	 * Enfilera o valor na ultima posicao da Queue
	 * 
	 * @param valor a ser enfilerado
	 */
	
	public void enqueue(int value);
	
	/**
	 * Retira o primeiro valor da Queue e retorna ela para quem chamou
	 * 
	 * @return valor da primeira posição da Queue
	 */
	
	public int dequeue();
	
	/**
	 * Retorna o tamanho da Queue para quem chamou
	 * 
	 * @return tamanho da Queue
	 */
	
	public int size();
	
	/**
	 * Apaga todos os elementos da Queue
	 */
	
	public void clear();
}
