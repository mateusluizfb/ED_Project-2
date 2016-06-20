package Sort;

/**
 * QuickSort implementado com o pivot sendo
 * o ultimo elemento do array
 * 
 * @author MateusLuiz
 *
 */

public class QStLastPivot extends AbstractQuickSort {
	
	protected void quickSort(int left, int right){
		if (right - left <= 0){
			return;
		} else {
			// privot sendo o ultimo elemento
			int pivot = array[right];
			int partition = partition(left, right, pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}
}
