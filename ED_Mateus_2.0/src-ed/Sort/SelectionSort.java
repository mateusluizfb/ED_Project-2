package Sort;

import Lists.List;

/**
 * Implemetacao de um SelectionSort que implementa AbstractSort
 * para tipos primitivos 'int'
 * 
 * A descricao dos metodos utilizados estao em AbstractSort
 * @author MateusLuiz
 *
 */

public class SelectionSort implements AbstractSort{

	public List sort(List array){
        int index;
        int size = array.size();
        for (int i = 0; i < size - 1; i++){
            index = i;
            for (int j = i + 1; j < size; j++){
                if (array.elementAt(j) < array.elementAt(index)){
                    index = j;
                }
            }           
            array.swap(index, i);
        }
    
        return array;
    }
	
	
}