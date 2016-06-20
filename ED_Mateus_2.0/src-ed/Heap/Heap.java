package Heap;

import Queue.Queue;

public class Heap implements Queue {

	private static final int MAX_SIZE = 100;
	private int size; 
	private int elements[]; 

	
	public Heap() {
		this.size = 0;
		elements = new int[MAX_SIZE];
	}
	public int[] elements() {
		return elements;
	}
	
	private int parent(int idx) {
		return (idx-1)/2;
	}
	
	private int left(int idx) {
		return 2 * idx + 1;
	}
	
	private int right(int idx) {
		return 2 * idx + 2;
	}
	
	private void swap(int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	public void maxHeapify(int idx) {
		int largest = idx;
		int left = left(idx);
		int right = right(idx);
		
		if(left < size && elements[left] > elements[largest]) {
			largest = left;
		}
		
		if(right < size && elements[right] > elements[largest]) {
			largest = right;
		}
		
		if(largest != idx) {
			swap(largest, idx);
			maxHeapify(largest);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int value) {
		if(size < MAX_SIZE) {
			elements[size++] = value;
			int idx = size-1;
			while(idx > 0 && elements[idx] > elements[parent(idx)]) {
				swap(idx, parent(idx));
				idx = parent(idx);
			}
		}
		else {
			throw new RuntimeException("overflow");
		}
	}

	public int dequeue() {
		int max = elements[0];
		swap(0, size-1);
		size--;
		maxHeapify(0);
		return max;
	}

	public int size() {
		return size;
	}

	public void clear() {
		size = 0;
	}

}

