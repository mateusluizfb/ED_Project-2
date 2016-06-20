package Sort;

import Heap.Heap;
import Lists.LinkedList;
import Lists.List;

public class HeapSort implements AbstractSort {

	public List sort(List list) {
		Heap heap = new Heap();
		
		for(int i = 0; i < list.size(); i++) {
			heap.enqueue(list.elementAt(i));
		}
		
		while(heap.size() > 1) {
			heap.dequeue();
		}
		
		List res = new LinkedList();
		for(int i = 0; i < list.size(); i++) {
			res.insert(i, heap.elements()[i]);
		}
		return res;
	}

}
