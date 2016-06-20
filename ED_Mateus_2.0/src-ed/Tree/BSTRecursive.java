package Tree;

class NoArvoreBinaria {
	int valor;
	int altura; 
	
	NoArvoreBinaria subArvoreEsquerda;
	NoArvoreBinaria subArvoreDireita;
	NoArvoreBinaria ancestral;
	
	
	public NoArvoreBinaria(int valor) {
		this.valor = valor;
		altura = 0;
	}
	
	public NoArvoreBinaria(int valor, NoArvoreBinaria ancestral) {
		this(valor);
		this.ancestral = ancestral;
	}
	
	/**
	 * Pesquisa na arvore binaria por uma determinada chave
	 * @param chave chave usada como objeto de busca 
	 * @return o no da arvore que satisfaz o criterio de busca
	 */
	public NoArvoreBinaria pesquisar(int chave) {
		if(chave == this.valor) {
			return this;
		}
		else if(chave < this.valor && subArvoreEsquerda != null) {
			return subArvoreEsquerda.pesquisar(chave);
		}
		else if(subArvoreDireita != null) {
			return subArvoreDireita.pesquisar(chave);
		}
		return null;
	}
		
	/**
	 * Insere um novo valor na arvore binaria de busca, a 
	 * partir do no da arvore atual (this).
	 * 
	 * @param novoValor valor a ser adicionado.
	 */
	public void inserir(int novoValor) {
		if(novoValor <= valor) {
			inserirNaSubArvoreEsquerda(novoValor);
		}
		else {
			inserirNaSubArvoreDireita(novoValor);
		}
		altura = 1 + Math.max(alturaSubEsquerda(), alturaSubDireita());
	}
	
	

	/*
	 * Metodo auxiliar que permite adicionar um novo 
	 * elemento na sub-arvore da esquerda. 
	 */
	private void inserirNaSubArvoreEsquerda(int valor) {
		if(subArvoreEsquerda == null) {
			subArvoreEsquerda = new NoArvoreBinaria(valor, this);
		}
		else {
			subArvoreEsquerda.inserir(valor);
		}
	}
	
	/*
	 * Metodo auxiliar que permite adicionar um novo 
	 * elemento na sub-arvore da direita.
	 */
	private void inserirNaSubArvoreDireita(int valor) {
		if(subArvoreDireita == null) {
			subArvoreDireita = new NoArvoreBinaria(valor, this);
		}
		else {
			subArvoreDireita.inserir(valor);
		}
	}
	
	private int alturaSubEsquerda() {
		if(subArvoreEsquerda == null) {
			return 0;
		}
		return subArvoreEsquerda.altura;
	}
	
	private int alturaSubDireita() {
		if(subArvoreDireita == null) {
			return 0;
		}
		return subArvoreDireita.altura;
	}
	
}

public class BSTRecursive {
	private NoArvoreBinaria raiz;
	
	public BSTRecursive(int valor) {
		this.raiz = new NoArvoreBinaria(valor);
	}
	
	
	/**
	 * Insere um valor na arvore de busca. Na essencia, 
	 * delega para o no raiz a insercao, tornando mais 
	 * simples a implementacao recursiva. 
	 * 
	 * @param valor valor a ser adicionado na arvore
	 */
	public void inserir(int valor) {
		raiz.inserir(valor);
	}
	
	/**
	 * Pesquisa por um valor especifico na arvore binaria de 
	 * busca. 
	 * 
	 * @param chave chave usada na pesquisa
	 * @return retorna o no da arvore que satisfaz ao criterio da busca.
	 */
	public NoArvoreBinaria pesquisar(int chave) {
		return this.raiz.pesquisar(chave);
	}
}
