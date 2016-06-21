package GrafoBuscaEmProfundidade;

enum Color {
	WHITE,
	GRAY,
	BLACK;
}

public class Vertice<T> {

	Color color;
	T value;
	int range;
	int iniRange;
	int lastRange;
	Vertice<T> ancestor;
	
	public Vertice(T value){
		this.value = value;
	}
	
	public String toString() {
		return value.toString() + " - " + color + " - " + range;
	}
	
}
