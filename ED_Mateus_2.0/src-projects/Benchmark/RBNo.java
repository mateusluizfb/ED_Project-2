/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

/**
 *
 * @author Franco
 */
public class RBNo {
	private int valor;
	private Cor cor;
	private RBNo ancestral;
	private RBNo subEsquerda;
	private RBNo subDireita;

	
	public RBNo(int valor, Cor cor) {
		this.valor = valor;
		this.cor = cor;
	}
	
	public RBNo(int valor, RBNo ancestral, Cor cor) {
		this(valor, cor);
		this.ancestral = ancestral;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public RBNo getAncestral() {
		return ancestral;
	}
	
	public void setAncestral(RBNo ancestral) {
		this.ancestral = ancestral;
	}
	
	public RBNo getSubEsquerda() {
		return subEsquerda;
	}
	
	public void setSubEsquerda(RBNo subEsquerda) {
		this.subEsquerda = subEsquerda;
	}
	
	public RBNo getSubDireita() {
		return subDireita;
	}
	
	public void setSubDireita(RBNo subDireita) {
		this.subDireita = subDireita;
	}
}
