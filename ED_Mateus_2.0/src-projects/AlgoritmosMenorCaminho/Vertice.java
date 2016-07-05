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
enum Cor {
	BRANCO,
	CINZA,
	PRETO;
}

public class Vertice<T> {
	private T valor;
	private int distancia;
	private int tempoInicial;
	private int tempoFinal;
	private Cor cor;
	private Vertice<T> antecessor;
	private boolean aberto;
	
	public boolean getAberto() {
		return aberto;
	}
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	public Vertice(T valor) {
		this.valor = valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public T getValor() {
		return valor;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public void setAntecessor(Vertice<T> antecessor) {
		this.antecessor = antecessor;
	}
	
	public Vertice<T> getAntecessor() {
		return antecessor;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %d", valor.toString(), cor.toString(), distancia);
	}
	
	public void setTempoInicial(int tempo) {
		tempoInicial = tempo;
	}
	
	public int getTempoInicial() {
		return tempoInicial;
	}
	
	public void setTempoFinal(int tempo) {
		tempoFinal = tempo;
	}
	
	public int getTempoFinal() {
		return tempoFinal;
	}
}
