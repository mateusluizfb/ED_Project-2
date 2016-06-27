package ClassificacaoArestas;


public class Aresta<T> {
	
	public Vertice<T> origem;
	public Vertice<T> destino;
	public String type;
	
	public Aresta(Vertice<T> origem, Vertice<T> destino){
		this.origem = origem;
		this.destino = destino;
	}
	
	public String toString(){
		return ("Start: " + origem.value + " ,End: " + destino.value + " / Type: " + type);
	}
	
}
