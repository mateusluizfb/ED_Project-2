package Sort;

import Lists.List;

/**
 * Implemetacao de um MergeSort que implementa AbstractSort
 * para tipos 'int'
 * 
 * Os metodos aqui nao explicados estao documentados em AbstractSort
 * @author mateu
 *
 */

public class MergeSort implements AbstractSort{

	protected int[] tempArray;
	protected int[] workspaceArray;
	protected int size;
	
	@Override
	public List sort(List array) {
		this.size = array.size();
		tempArray = new int[size];
		for(int i = 0; i < size; i++){
			tempArray[i] = array.elementAt(i);
		}
		workspaceArray = new int[size];
		divideAndConquer(0, size - 1);
		array.addAll(tempArray);
		return array;
	}
	
	/**
	 * Metodo que se chama recursivamente para dividir o 
	 * array em diversas partes ateh um elemento e na volta 
	 * ordenar os elementos
	 * 
	 * @param left primeiro elemento do array
	 * @param right ultimo elemento do array
	 */
	
	protected void divideAndConquer(int left, int right){
		int middle = (right + left)/ 2;
		if (left < right){
			divideAndConquer(left, middle);
			divideAndConquer(middle + 1, right);
			merge(left, middle, right);
		}
	}
	
	/**
	 * Metodo que efetivamente faz a juncao das 'partes' do array
	 * e ordena eles, gerando assim o array ordenado
	 * 
	 * @param left primeiro elemento do array
	 * @param middle elemento intermetiario do array
	 * @param right ultimo elemento do array
	 */
	
	protected void merge(int left, int middle, int right){
		for (int i = 0; i < size; i++) {
			workspaceArray[i] = tempArray[i];
		}
		
		int i = left;
		int j = middle + 1;
		int k = left;
		
		while(i <= middle && j <= right){
			if (workspaceArray[i] < workspaceArray[j]){
				tempArray[k++] = workspaceArray[i++];
			} else {
				tempArray[k++] = workspaceArray[j++];
			}
		}
		
		while (i <= middle){
			tempArray[k++] = workspaceArray[i++];
		}
		
		while (j <= right) {
			tempArray[k++] = workspaceArray[j++];
		}
	}
	
	
	
	

}
