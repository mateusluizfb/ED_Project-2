package ClassificacaoArestas;

import Lists.ListGeneric;

public interface GrafoInterface<T> {
	
	public void addVertice(Vertice<T> vertice);
	public void addAresta(T current, T target);
	public ListGeneric<Vertice<T>> verticesAdjacentes(T v); 
	public int quantidadeVertices();
	public int range(T current, T target);

}
