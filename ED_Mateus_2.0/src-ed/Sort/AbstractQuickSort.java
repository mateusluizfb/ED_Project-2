package Sort;

import Lists.List;

/**
 * Classe abstrata para QuickSort fornece os metodos essenciais
 * para um QuickSort comum
 * 
 * Para este projeto todos as classes serao implementadas
 * com o tipo primitivo 'int'
 * @author MateusLuiz
 *
 */

abstract class AbstractQuickSort implements AbstractSort {

	protected int[] array;
		
	public List sort(List array) {
		int size = array.size();
		this.array = new int[size];
		for(int i = 0; i < size; i++){
			this.array[i] = array.elementAt(i);
		}
		quickSort(0, size - 1);
		array.addAll(this.array);
		return array;
	}
	
	/**
	 * O metodo quickSort eh onde ocorre a recursão dele mesmo,
	 * nele o array eh ordenado pela escolha do pivot.
	 * 
	 * A implementacao dele depende de implementacao para 
	 * implementacao, alguns usam o pivot como sendo o ultimo
	 * elemento ou o primeiro, ou entao qualquer outra forma de escolha.
	 * 
	 * A implemetacao dele fica a cargo da classe que herdar AbstractQuickSort
	 * 
	 * Por padrão a escolha do pivot eh o ultimo elemento.
	 * @param left indice esquerdo do array
	 * @param right indice direito do array
	 */
	
	protected void quickSort(int left, int right) {
		if (right - left <= 0){
			return;
		} else {
			// pivot sendo o ultimo elemento
			int pivot = array[right];
			int partition = partition(left, right, pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}
	
	/**
	 * O metodo partition executa efetivamente a ordenacao 
	 * do array atravez de sucessivas particoes e trocas de elementos
	 * 
	 * @param left indice esquerdo do array
	 * @param right indice direito do array
	 * @param pivot pivot escolhido no metodo quickSort
	 * @return
	 */
	
	protected int partition(int left, int right, int pivot){
		
		int tempLeft = left - 1;
		int tempRight = right;
		
		while(true){
			
			while(array[++tempLeft] < pivot);
			while(array[--tempRight] > pivot && tempRight > 0);
			
			if (tempLeft >= tempRight){
				break;
			} else {
				swap(tempLeft, tempRight);
			}
		}
		swap(tempLeft, right);
		
		return tempLeft;
		
	}
	
	/**
	 * Metodo swap faz a troca de dois elementos
	 * 
	 * @param index elemento maior
	 * @param index2 elemento menor
	 */
	
	protected void swap(int index,int index2){
		int temp = array[index];
		array[index] = array[index2];
		array[index2] = temp;
	}
	
}
