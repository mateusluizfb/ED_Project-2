package Tree;

import java.util.LinkedList;
import java.util.List;

class NoDaArvore {
	int valor;
	NoDaArvore ancestral;
	List<NoDaArvore> subarvores;
	
	public NoDaArvore(int valor) {
		this.valor = valor;
		subarvores = new LinkedList<NoDaArvore>();
	}
	
	public NoDaArvore(int valor, NoDaArvore ancestral) {
		this(valor); // chama contrutor original
		this.ancestral = ancestral;
	}

	public NoDaArvore pesquisar(int chave) {
		if(valor == chave) {
			return this;
		}
		
		for(int i = 0; i < subarvores.size(); i++) {
			NoDaArvore resultado = subarvores.get(i).pesquisar(chave);
			if(resultado != null) {
				return resultado;
			}
		}
		return null; //caso a pesquisa nao seja bem sucedida, retorna null.
	}

	public int altura() {
		if(subarvores.size() == 0) {
			return 1;
		}
		
		int max = 0; 
		
		for(int i = 0; i < subarvores.size(); i++) {
			int alturaSubArvore = subarvores.get(i).altura();
			
			max = max < alturaSubArvore ? alturaSubArvore : max;
		}
		return 1 + max;
	}
	
	public boolean equals(Object other) {
		return (other instanceof NoDaArvore) && ((NoDaArvore)other).valor == this.valor;
	}
}

public class RoseTree {

	NoDaArvore raiz;
	
	public RoseTree(int valor) {
		raiz = new NoDaArvore(valor);
	}
	
	public void inserir(int chaveNoAncestral, int valor) {
		NoDaArvore ancestral = raiz.pesquisar(chaveNoAncestral);
		
		if(ancestral == null) {
			throw new RuntimeException();
		}
		else {
			ancestral.subarvores.add(0, new NoDaArvore(valor, ancestral));
		}
	}
	
	public void remover(int chave) {
		NoDaArvore elemento = raiz.pesquisar(chave);
		NoDaArvore ancestral = elemento.ancestral;
		ancestral.subarvores.remove(elemento);
	}
	
	public NoDaArvore pesquisar(int chave) {
		return this.raiz.pesquisar(chave);
	}
	
	public int altura() {
		return this.raiz.altura();
	}
	
}