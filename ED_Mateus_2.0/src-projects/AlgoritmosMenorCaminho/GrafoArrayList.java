/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosMenorCaminho;

import java.util.ArrayList;
import java.util.Stack;


/**
 *
 * @author Franco
 * @param <T>
 */
public class GrafoArrayList<T> implements Grafo<T> {
	public static final int INFINITO = 100000;
	
	/*representa um vertice com uma lista de vertices adjacentes*/
	private class VerticeTable<T> {
		Vertice<T> vertice;
		ArrayList<Aresta<T>> arestasAdjacentes;
		
		public VerticeTable(Vertice<T> vertice) {
			this.vertice = vertice;
			arestasAdjacentes = new ArrayList();
		}
		
		public void adicionaAresta(Vertice<T> destino, int custo) {
			if (procuraAresta(destino.getValor()) == null) {
				arestasAdjacentes.add(new Aresta(vertice, destino, custo));
			}
			
			else {
				//TODO : ARESTA JA EXISTE NA LISTA DE ARESTAS ASSOCIADAS
			}
		}
		
		private Aresta<T> procuraAresta(T valor) {
			for (Aresta<T> aux : arestasAdjacentes) {
				if (aux.getVerticeDestino() == valor) {
					return aux;
				}
			}
			
			return null;
		}
		
		public void mostraAresta() {
			System.out.printf("Valor: %s	Arestas:", vertice.getValor());
			
			for (Aresta<T> aux : arestasAdjacentes) {
				System.out.printf(" -> %s", aux.getVerticeDestino().getValor());
			}
		}
		
		public void printaTiposArestas() {
			for (Aresta<T> aresta : arestasAdjacentes) {
				System.out.printf("%s com %s : %s\n", aresta.getVerticeOrigem().getValor(), aresta.getVerticeDestino().getValor(), aresta.getTipoAresta());
			}
		}
	}

	/*representacao do grafo em si, uma lista de VerticesTable*/
	private ArrayList<VerticeTable<T>> grafo;
	
	private final boolean dirigido;
	
	private final boolean ponderado;
	
	public GrafoArrayList(boolean dirigido, boolean ponderado) {
		this.dirigido = dirigido;
		this.ponderado = ponderado;
		grafo = new ArrayList();
	}
	
	@Override
	public void adicionaVertice(T valor) {
		Vertice<T> novoVertice = new Vertice(valor);
		
		adicionaVertice(novoVertice);
	}
	
	@Override
	public void adicionaVertice(Vertice<T> novoVertice) {
		if (procuraVertice(novoVertice.getValor()) == null) {
			grafo.add(new VerticeTable(novoVertice));
		}
	}
	
	private VerticeTable<T> procuraVertice(T valorProcurado) {
		for (VerticeTable<T> verticeTable : grafo) {
			if (verticeTable.vertice.getValor() == valorProcurado) {
				return verticeTable;
			}
		}
		
		return null;
	}
	
	@Override
	public void adicionaAresta(T origem, T destino, int custo) {
		/*encontra os vertices na representacao*/
		VerticeTable origemTable = procuraVertice(origem);
		VerticeTable destinoTable = procuraVertice(destino);
		
		/*se o grafo nao for ponderado peso recebe 1*/
		if (!ponderado) {
			custo = 1;
		}
		
		if (origemTable != null && destinoTable != null) {
			origemTable.adicionaAresta(destinoTable.vertice, custo);
			
			if (!dirigido) {
				destinoTable.adicionaAresta(origemTable.vertice, custo);
			}
		}
	}

	@Override
	public ArrayList<Aresta<T>> arestasAdjacentes(T valor) {
		VerticeTable<T> aux = procuraVertice(valor);
		
		if (aux != null) {
			return aux.arestasAdjacentes;
		}
		
		return null;
	}

	@Override
	public int quantidadeVertices() {
		return grafo.size();
	}

	@Override
	public int distancia(T origem, T destino) {
		VerticeTable<T> verticeOrigem = procuraVertice(origem);
		VerticeTable<T> verticeDestino = procuraVertice(destino);
		
		if (verticeOrigem != null && verticeDestino != null) {
			buscaEmLargura(verticeOrigem);
			return verticeDestino.vertice.getDistancia();
		}
		
		else {
			//TODO :  VERTICES INVALIDOS 
			//LANCAR ERRO
		}
		
		return INFINITO;
	}
	
	private void buscaEmProfundidade(Stack pilha) {
		int tempo = 0;
		
		for (VerticeTable<T> representVent : grafo) {
			representVent.vertice.setCor(Cor.BRANCO);
			representVent.vertice.setAntecessor(null);
		}
		
		for (VerticeTable representaVertice : grafo) {
			if (representaVertice.vertice.getCor() == Cor.BRANCO) {
				tempo = visita(representaVertice.vertice, tempo, pilha);
			}
		}
	}
	
	private int visita(Vertice<T> vertice, int tempo, Stack pilha) {
		vertice.setCor(Cor.CINZA);
		VerticeTable<T> verticeTable = representacaoVertice(vertice.getValor());
		tempo++;
		vertice.setTempoInicial(tempo);
		
		for (Aresta<T> aresta : verticeTable.arestasAdjacentes) {
			if (aresta.getVerticeDestino().getCor() == Cor.BRANCO) {
				aresta.setTipoAresta(TipoAresta.TREE_EDGE);
				aresta.getVerticeDestino().setAntecessor(vertice);
				tempo = visita(aresta.getVerticeDestino(), tempo, pilha);
			}
			
			else if (aresta.getVerticeDestino().getCor() == Cor.CINZA) {
				aresta.setTipoAresta(TipoAresta.BACKWARD_EDGE);
			}
			
			else {
				if (vertice.getTempoInicial() < aresta.getVerticeDestino().getTempoInicial()) {
					aresta.setTipoAresta(TipoAresta.FORWARD_EDGE);
				}
				
				else {
					aresta.setTipoAresta(TipoAresta.CROSS_EDGE);
				}
			}
		}
		
		vertice.setCor(Cor.PRETO);
		tempo++;
		vertice.setTempoFinal(tempo);
		
		if (pilha != null) {
			pilha.push(vertice);
		}
		
		return tempo;
	}
	
	@Override
	public void buscaProfundidadeComPilha() {
		Stack<VerticeTable<T>> pilha = new Stack();
		int tempo = 0;
		Vertice<T> antecessorAux;
		VerticeTable<T> tableAux;
		VerticeTable<T> proxValido;
		
		for (VerticeTable<T> verticeTable : grafo) {
			verticeTable.vertice.setCor(Cor.BRANCO);
			verticeTable.vertice.setAntecessor(null);
			for (Aresta<T> aresta : verticeTable.arestasAdjacentes) {
				aresta.setClassificada(false);
			}
		}
		
		for (VerticeTable<T> table : grafo) {
			if (table.vertice.getCor() == Cor.BRANCO) {
				table.vertice.setTempoInicial(tempo++);
				table.vertice.setCor(Cor.CINZA);
				pilha.push(table);
			}
			
			while (!pilha.empty()) {
				tableAux = pilha.lastElement();
				antecessorAux = tableAux.vertice;
				proxValido = proximoVerticeNaoVisitado(tableAux);
				
				if (proxValido != null) {
					proxValido.vertice.setCor(Cor.CINZA);
					proxValido.vertice.setTempoInicial(tempo++);
					proxValido.vertice.setAntecessor(antecessorAux);
					pilha.push(proxValido);
				}
				
				else {
					tableAux.vertice.setCor(Cor.PRETO);
					tableAux.vertice.setTempoFinal(tempo++);
					pilha.pop();
				}
			}
		}
		
		for (VerticeTable<T> vertice : grafo) {
			vertice.printaTiposArestas();
		}
	}
	
	private VerticeTable<T> proximoVerticeNaoVisitado(VerticeTable<T> vertice) {
		for (Aresta<T> aresta : vertice.arestasAdjacentes) {
			
			if (aresta.getVerticeDestino().getCor() == Cor.BRANCO) {
				aresta.setClassificada(true);
				aresta.setTipoAresta(TipoAresta.TREE_EDGE);
				return representacaoVertice(aresta.getVerticeDestino().getValor());
			}
			
			else if (aresta.getVerticeDestino().getCor() == Cor.CINZA) {
				if (!aresta.getClassificada()) {
					aresta.setClassificada(true);
					aresta.setTipoAresta(TipoAresta.BACKWARD_EDGE);
				}
			}
			
			else {
				if (!aresta.getClassificada()) {
					aresta.setClassificada(true);
					if (aresta.getVerticeOrigem().getTempoInicial() < aresta.getVerticeDestino().getTempoInicial()) {
						aresta.setTipoAresta(TipoAresta.FORWARD_EDGE);
					}
					
					else {
						aresta.setTipoAresta(TipoAresta.CROSS_EDGE);
					}
				}
			}
		}
		
		return null;
	}
	
	private void buscaEmLargura(VerticeTable<T> origem) {
		for (VerticeTable<T> representaVertice : grafo) {
			representaVertice.vertice.setCor(Cor.BRANCO);
			representaVertice.vertice.setAntecessor(null);
			representaVertice.vertice.setDistancia(INFINITO);
		}
		
		origem.vertice.setDistancia(0);
		origem.vertice.setAntecessor(null);
		
		Stack<VerticeTable<T>> pilha = new Stack();
		
		pilha.push(origem);
		
		while(!pilha.empty()) {
			VerticeTable<T> verticeTable = pilha.pop();
			
			for (Aresta<T> aresta : verticeTable.arestasAdjacentes) {
				if(aresta.getVerticeDestino().getCor() == Cor.BRANCO) {
					aresta.getVerticeDestino().setCor(Cor.CINZA);
					aresta.getVerticeDestino().setDistancia(verticeTable.vertice.getDistancia() + 1);
					aresta.getVerticeDestino().setAntecessor(verticeTable.vertice);
					pilha.push(representacaoVertice(aresta.getVerticeDestino().getValor()));
				}
			}
			
			verticeTable.vertice.setCor(Cor.PRETO);
		}
	}
	
	private VerticeTable<T> representacaoVertice(T valor) {
		for (VerticeTable<T> vertice : grafo) {
			if (vertice.vertice.getValor() == valor) {
				return vertice;
			}
		}
		
		return null;
	}
	
	@Override
	public void mostraGrafo() {
		for (VerticeTable aux : grafo) {
			aux.mostraAresta();
			System.out.println();
		}
	}
	
	@Override
	public void classificaArestas() {
		buscaEmProfundidade(null);
		for (VerticeTable<T> vertice : grafo) {
			vertice.printaTiposArestas();
		}
	}
	
	@Override
	public void mostraOrdenacaoTopologica() {
		Vertice<T> vertice;
		Stack<Vertice<T>> pilha = new Stack();
		
		buscaEmProfundidade(pilha);
		
		while(!pilha.empty()) {
			vertice = pilha.pop();
			System.out.printf("%s -> ", vertice.getValor());
		}
		
		System.out.println();
	}
	
	@Override
	public int menorDistanciaDijkstra(T origem, T destino) {
		VerticeTable<T> origemTable = procuraVertice(origem);
		VerticeTable<T> destinoTable = procuraVertice(destino);
		VerticeTable<T> tableAtual;
		int distanciaDestino;
		int distanciaOrigem;
		
		for (VerticeTable<T> aux : grafo) {
			aux.vertice.setAberto(true);
			aux.vertice.setDistancia(INFINITO);
		}
		
		origemTable.vertice.setDistancia(0);
		
		while((tableAtual = extraiMin()) != null) {
			tableAtual.vertice.setAberto(false);
			
			for (Aresta<T> aresta : tableAtual.arestasAdjacentes) {
				if (aresta.getVerticeDestino().getAberto()) {
					distanciaDestino = aresta.getVerticeDestino().getDistancia();
					distanciaOrigem = aresta.getVerticeOrigem().getDistancia();
				
				
					if (distanciaDestino > distanciaOrigem + aresta.getCustoAresta()) {
						aresta.getVerticeDestino().setDistancia(distanciaOrigem + aresta.getCustoAresta());
						aresta.getVerticeDestino().setAntecessor(aresta.getVerticeOrigem());
					}
				}	
			}
		}
		
		return destinoTable.vertice.getDistancia();
	}
	
	@Override
	public int menorDistanciaBellMan(T origem, T destino) {
		VerticeTable<T> origemTable = procuraVertice(origem);
		VerticeTable<T> destinoTable = procuraVertice(destino);
		ArrayList<Aresta<T>> listaAresta;
		int distOrigem, distDestino;
		
		//inicializa grafo
		for (VerticeTable<T> vertice : grafo) {
			vertice.vertice.setDistancia(INFINITO);
			vertice.vertice.setAntecessor(null);
		}
		
		origemTable.vertice.setDistancia(0);
		
		for (int i = 0; i < grafo.size() - 1; i++) {
			for (VerticeTable<T> vertice : grafo) {
				listaAresta = vertice.arestasAdjacentes;

				for (Aresta<T> aresta : listaAresta) {
					distOrigem = aresta.getVerticeOrigem().getDistancia();
					distDestino = aresta.getVerticeDestino().getDistancia();
					
					if (distDestino > distOrigem + aresta.getCustoAresta()) {
						aresta.getVerticeDestino().setDistancia(distOrigem + aresta.getCustoAresta());
						aresta.getVerticeDestino().setAntecessor(aresta.getVerticeOrigem());
					}
				}
			}
		}
		
		//CHECAGEM SE NAO HA CICLOS NEGATIVOS
		for (VerticeTable<T> aux : grafo) {
			for (Aresta<T> aresta : aux.arestasAdjacentes) {
				distOrigem = aresta.getVerticeOrigem().getDistancia();
				distDestino = aresta.getVerticeDestino().getDistancia();
				
				if (distOrigem + aresta.getCustoAresta() < distDestino) {
					System.out.println("Erro, ciclo negativo");
					throw new RuntimeException("Grafo contem ciclo negativo");
				}
			}
		}
		
		//TODO: RETORNAR DISTANCIA MINIMA
		
		return destinoTable.vertice.getDistancia();
	}
	
	private VerticeTable<T> extraiMin() {
		VerticeTable menorTable = null;
		
		for (VerticeTable<T> aux : grafo) {
			if (aux.vertice.getAberto()) {
				if (menorTable != null) {
					if (aux.vertice.getDistancia() < menorTable.vertice.getDistancia()) {
						menorTable = aux;
					}
				}
				
				else {
					menorTable = aux;
				}
			}
		}
		
		return menorTable;
	}
}
