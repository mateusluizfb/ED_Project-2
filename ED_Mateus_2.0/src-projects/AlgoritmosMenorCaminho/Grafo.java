/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosMenorCaminho;

import java.util.ArrayList;

/**
 *
 * @author Franco
 */
public interface Grafo<T> {
	public void adicionaVertice(Vertice<T> valor);
	
	public void adicionaVertice(T valor);
	
	public void adicionaAresta(T origem, T destino, int peso);
	
	public ArrayList<Aresta<T>> arestasAdjacentes(T valor);
	
	public void classificaArestas();
	
	public void buscaProfundidadeComPilha();
	
	public int quantidadeVertices();
	
	public int distancia(T origem, T destino);
	
	//ALGORITMO DE DIJSKTRA
	public int menorDistanciaDijkstra(T origem, T destino);
	
	public int menorDistanciaBellMan(T origem, T destino);
	
	public void mostraOrdenacaoTopologica();
	
	public void mostraGrafo();
}
