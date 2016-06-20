package Sort;

/**
 * QuickSort implementado com o pivot sendo
 * o primeiro elemento do array
 * 
 * @author MateusLuiz
 *
 */

public class QSFirstPivot extends AbstractQuickSort{
	
	protected void quickSort(int left, int right){
		if (right - left <= 0){
			return;
		} else {
			// pivot sendo o primeiro elemento
			int pivot = array[left];
			int partition = partition(left, right, pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}
}
