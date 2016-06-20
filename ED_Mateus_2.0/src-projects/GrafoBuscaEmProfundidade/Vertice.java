package GrafoBuscaEmProfundidade;

enum Color {
	WHITE,
	SILVER,
	BLACK;
}

public class Vertice<T> {

	Color color;
	T value;
	int range;
	Vertice<T> ancestor;
	
	public Vertice(T value){
		this.value = value;
	}
	
	public String toString() {
		return value.toString() + " - " + color + " - " + range;
	}
	
}
