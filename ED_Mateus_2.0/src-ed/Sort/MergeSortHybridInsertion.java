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

public class MergeSortHybridInsertion extends MergeSort{

	@Override
	public List sort(List array) {
		this.size = array.size();
		if (size < 10){
			insertion(array);
			return array;
		}
		tempArray = new int[size];
		for(int i = 0; i < size; i++){
			tempArray[i] = array.elementAt(i);
		}
		workspaceArray = new int[size];
		divideAndConquer(0, size - 1);
		array.addAll(tempArray);
		return array;
	}
	
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
