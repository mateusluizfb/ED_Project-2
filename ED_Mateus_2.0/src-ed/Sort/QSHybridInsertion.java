package Sort;

import Lists.List;

/**
 * QSHibidInsertion implementa junto ao QuickSort o InsertionSort.
 * Ele usara o InsertionSort caso o array seja de  até 10 elementos
 * Caso entre no quickSort, o pivot escolhido vai ser o ultimo elemento. 
 * 
 * A descricao de cada metodo se encontra na classe AbstractQuickSort
 * @author MateusLuiz
 *
 */

public class QSHybridInsertion extends AbstractQuickSort {
	
	public List sort(List array) {
		int size = array.size();
		if (size < 10){
			insertion(array);
			return array;
		}
		this.array = new int[size];
		for(int i = 0; i < size; i++){
			this.array[i] = array.elementAt(i);
		}
		quickSort(0, size - 1);
		array.addAll(this.array);
		return array;
	}
	
	protected void quickSort(int left, int right){
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
	 * Metodo chamado no metodo sort para se caso
	 * o array seja de ate 10 elementos
	 * 
	 * @param array do tipo List
	 */
	
	protected void insertion(List array){
		int size = array.size();
		for(int i = 1 ; i < size; i++){
			for(int j = i; j > 0; j--){
				if (array.elementAt(j) < array.elementAt(j - 1)){
					array.swap(j, j - 1);
				}
			}
		}
	}
}
