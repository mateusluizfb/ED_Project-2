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
public class AVLNo {
	private int valor;
	private AVLNo ancestral;
	private AVLNo subDireita;
	private AVLNo subEsquerda;
	private int fatorBalanceamento;
	
	public AVLNo(int valor) {
		this.valor = valor;
	}
	
	public AVLNo(int valor, AVLNo ancestral) {
		this(valor);
		this.ancestral = ancestral;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public AVLNo getAncestral() {
		return ancestral;
	}
	
	public void setAncestral(AVLNo ancestral) {
		this.ancestral = ancestral;
	}
	
	public AVLNo getSubEsquerda() {
		return subEsquerda;
	}
	
	public void setSubEsquerda(AVLNo subEsquerda) {
		this.subEsquerda = subEsquerda;
	}
	
	public AVLNo getSubDireita() {
		return subDireita;
	}
	
	public void setSubDireita(AVLNo subDireita) {
		this.subDireita = subDireita;
	}
	
	public int getFatorBalanceamento() {
		return fatorBalanceamento;
	}
	
	public void setFatorBalanceamento(int fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}
	
	public int getAltura() {
		int alturaDireita = 0;
		int alturaEsquerda = 0;
		
		if (subEsquerda != null) {
			alturaEsquerda = subEsquerda.getAltura();
		}
		
		if (subDireita != null) {
			alturaDireita = subDireita.getAltura();
		}
		
		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}
}
