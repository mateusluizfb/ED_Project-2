package Queue;

import Lists.LinkedListGeneric;

public class QueueGeneric<T> {

	private LinkedListGeneric<T> lista;
	
	public QueueGeneric() {
		lista = new LinkedListGeneric<T>();
	}
	
	public void enqueue(T valor) {
		lista.insert(0, valor);
	}
	
	public T dequeue() {
		int tamanho = lista.size();
		T valor = lista.elementAt(tamanho-1);
		lista.remove(tamanho-1);
		return valor;
	}
	
	public boolean isEmpty() {
		return lista.size() == 0;
	}
}
