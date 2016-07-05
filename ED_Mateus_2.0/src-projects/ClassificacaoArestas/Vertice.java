package ClassificacaoArestas;
/**
 * 
 * @author mateus
 *
 */
enum Color {
	WHITE,
	SILVER,
	BLACK;
}

public class Vertice<T> {
    
	public Color color;
	public T value;
	public int range;
	public Vertice<T> ancestor;
	public int finalRange;
	public boolean visited;
	
	public Vertice(T value){
		this.value = value;
	}
	
	public String toString() {
		return value.toString() + " / Range inicial: " + range + " - Range final: " + finalRange;
	}
	
}
