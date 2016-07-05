/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosMenorCaminho;

/**
 *
 * @author Franco
 */
enum TipoAresta {
	TREE_EDGE,
	FORWARD_EDGE,
	BACKWARD_EDGE,
	CROSS_EDGE;
}

public class Aresta<T> {
	private Vertice<T> verticeOrigem;
	private Vertice<T> verticeDestino;
	private int custoAresta;
	private TipoAresta tipoAresta;
	private boolean classificada;
	
	
	public boolean getClassificada() {
		return classificada;
	}
	
	public void setClassificada(boolean classificada) {
		this.classificada = classificada;
	}
	
	public Aresta(Vertice<T> origem, Vertice<T> destino, int custo) {
		verticeOrigem = origem;
		verticeDestino = destino;
		custoAresta = custo;
	}
	
	public void setVerticeOrigem(Vertice<T> origem) {
		verticeOrigem = origem;
	}
	
	public Vertice<T> getVerticeOrigem() {
		return verticeOrigem;
	}
	
	
	public void setVerticeDestino(Vertice<T> destino) {
		verticeDestino = destino;
	}
	
	public Vertice<T> getVerticeDestino() {
		return verticeDestino;
	}
	
	public void setCustoAresta(int custo) {
		custoAresta = custo;
	}
	
	public int getCustoAresta() {
		return custoAresta;
	}
	
	public void setTipoAresta(TipoAresta tipo) {
		tipoAresta = tipo;
	}
	
	public TipoAresta getTipoAresta() {
		return tipoAresta;
	}
}
