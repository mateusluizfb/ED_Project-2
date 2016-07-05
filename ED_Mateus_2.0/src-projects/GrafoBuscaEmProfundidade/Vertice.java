package GrafoBuscaEmProfundidade;
/**
 * 
 * @author mateus
 *
 */
enum Color {
	WHITE,
	GRAY,
	BLACK;
}

public class Vertice<T> {

	public Color color;
	public T value;
	public int range;
	public int iniRange;
	public int lastRange;
	public Vertice<T> ancestor;
	
	public Vertice(T value){
		this.value = value;
	}
	
	public String toString() {
		return value.toString();
	}
	
}
