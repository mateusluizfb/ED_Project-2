package Sort;

public class MergeSortInteiros {
	
	private int[] array;
	private int[] tempArray;
	private int size;
	
	public void sort(int[] array){
		this.array = array;
		size = array.length;
		tempArray = new int[size];
		divideAndConquer(0, size - 1);
	}
	
	public void divideAndConquer(int low, int high){
		int middle = (high + low)/ 2;
		if (low < high){
			divideAndConquer(low, middle);
			divideAndConquer(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	public void merge(int low, int middle, int high){
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high){
			if (tempArray[i] < tempArray[j]){
				array[k++] = tempArray[i++];
			} else {
				array[k++] = tempArray[j++];
			}
		}
		
		while (i <= middle){
			array[k++] = tempArray[i++];
		}
		
		while (j <= high) {
			array[k++] = tempArray[j++];
		}
	}
	
}
