package Benchmark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Franco
 */
public interface ArvoreDeBusca {
	void limpaArvore();
	
	void inserir(int valor);
	
	void remover(int valor);
	
	boolean pesquisa(int valor);
	
	int altura();
	
	void infoInOrder();
	
	void infoPreOrder();
	
	int sucessor(int chave);
}
