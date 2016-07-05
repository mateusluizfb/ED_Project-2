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
public class ArvoreAVL implements ArvoreDeBusca {
	private AVLNo raiz;
	
	@Override
	public void limpaArvore() {
		raiz = null;
	}
	
	@Override
	public int altura() {
		if (raiz == null) {
			return 0;
		}
		
		return alturaNo(raiz);
	}
	
	@Override
	public void inserir(int valor) {
		if (raiz == null) {
			raiz = new AVLNo(valor);
		}
		
		else {
			inserir(raiz, valor);
		}
	}
	
	private void inserir(AVLNo noAtual, int valor) {
		if (valor > noAtual.getValor()) {
			if (noAtual.getSubDireita() != null) {
				inserir(noAtual.getSubDireita(), valor);
			}
			
			else {
				//INSERE NOVO NO NA ARVORE DA DIREITA DO noAtual
				//E VERIFICA SE A ARVORE ESTA BALANCEADA
				noAtual.setSubDireita(new AVLNo(valor, noAtual));
				verificaBalanceamento(noAtual.getSubDireita());
			}
		}
		
		else if (valor < noAtual.getValor()) {
			if (noAtual.getSubEsquerda() != null) {
				inserir(noAtual.getSubEsquerda(), valor);
			}
			
			else {
				//INSERE NOVO NO NA ARVORE DA ESQUERDA DO noAtual
				//E VERIFICA SE A ARVORE ESTA BALANCEADA
				noAtual.setSubEsquerda(new AVLNo(valor, noAtual));
				verificaBalanceamento(noAtual.getSubEsquerda());
			}
		}
		
		else {
			//NAO INSERE VALORES REPETIDOS
		}
	}

	@Override
	public void remover(int valor) {
		remover(raiz, valor);
	}

	private void remover(AVLNo noAtual, int valor) {
		if (noAtual != null) {
			if (valor > noAtual.getValor()) {
				remover(noAtual.getSubDireita(), valor);
			}
			
			else if (valor < noAtual.getValor()) {
				remover(noAtual.getSubEsquerda(), valor);
			}
			
			else {
				removerNo(noAtual);
			}
		}
	}
	
	private void removerNo(AVLNo noRemover) {
		AVLNo ancestralAux = noRemover.getAncestral();
		AVLNo noSubstituto;
		AVLNo noParaBalancear;
		
		//REMOCAO DO NO CASO SEJA FOLHA
		if (noRemover.getSubDireita() == null && noRemover.getSubEsquerda() == null) {
			noParaBalancear = noRemover.getAncestral();
			if (ancestralAux != null) {
				if (ancestralAux.getSubDireita() == noRemover) {
					ancestralAux.setSubDireita(null);
				}
				
				else {
					ancestralAux.setSubEsquerda(null);
				}
				
				
			}
			
			else {
				//REMOVER A RAIZ SEM FILHOS
				raiz = null;
			}
		}
		
		//REMOCAO DO NO CASO NAO TENHA FILHO A DIREITA
		else if (noRemover.getSubDireita() == null){
			noParaBalancear = noRemover.getSubEsquerda();
			if (ancestralAux != null) {
				if (ancestralAux.getSubDireita() == noRemover) {
					ancestralAux.setSubDireita(noRemover.getSubEsquerda());
				}
			
				else {
					ancestralAux.setSubEsquerda(noRemover.getSubEsquerda());
				}
				
				if (noRemover.getSubEsquerda() != null) {
					noRemover.getSubEsquerda().setAncestral(ancestralAux);
				} 
			}
			
			else {
				//REMOVER RAIZ COM FILHOS A ESQUERDA
				raiz.getSubEsquerda().setAncestral(null);
				raiz = raiz.getSubEsquerda();
			}
		}
		
		//REMOCAO CASO HAJA SUCESSOR
		else {
			noSubstituto = sucessor(noRemover);
			noParaBalancear = noSubstituto.getAncestral();
			
			if (noRemover.getSubDireita() != noSubstituto) {
				noSubstituto.getAncestral().setSubEsquerda(null);
				noSubstituto.setSubDireita(noRemover.getSubDireita());
				noSubstituto.getSubDireita().setAncestral(noSubstituto);
				noSubstituto.setSubEsquerda(noRemover.getSubEsquerda());
				noSubstituto.setAncestral(ancestralAux);
				
				if (noSubstituto.getSubEsquerda() != null) {
					noSubstituto.getSubEsquerda().setAncestral(noSubstituto);
				}
				
				if (ancestralAux != null) {
					if (ancestralAux.getSubDireita() == noRemover) {
						ancestralAux.setSubDireita(noSubstituto);
					}
					
					else {
						ancestralAux.setSubEsquerda(noSubstituto);
					}
				}
				
				else {
					//CASO SEJA A RAIZ
					raiz = noSubstituto;
				}
			}
			
			else {
				//CASO O A ARVORE A DIREITA DO NO A REMOVER SEJA O SUCESSOR
				noSubstituto.setSubEsquerda(noRemover.getSubEsquerda());
				noSubstituto.setAncestral(ancestralAux);
				
				if (noSubstituto.getSubEsquerda() != null) {
					noSubstituto.getSubEsquerda().setAncestral(noSubstituto);
				}
				
				if (ancestralAux != null) {
					if (ancestralAux.getSubEsquerda() == noRemover) {
						ancestralAux.setSubEsquerda(noSubstituto);
					}
					
					else {
						ancestralAux.setSubDireita(noSubstituto);
					}
				}
				
				else {
					//REMOVER RAIZ COM O SUCESSOR SENDO O FILHO A DIREITA
					raiz = noSubstituto;
				}
			}
		}
		
		verificaBalanceamento(noParaBalancear);
	}
	
	@Override
	public boolean pesquisa(int valor) {
		if (raiz != null) {
			return pesquisa(raiz, valor);
		}
		
		return false;
	}
	
	private boolean pesquisa(AVLNo noAtual, int valor) {
		if (noAtual.getValor() == valor) {
			return true;
		}
		
		if (valor > noAtual.getValor()) {
			if (noAtual.getSubDireita() != null) {
				return pesquisa(noAtual.getSubDireita(), valor);
			}
		}
			
		else {
			if (noAtual.getSubEsquerda() != null) {
				return pesquisa(noAtual.getSubEsquerda(), valor);
			}
		}
		
		return false;
	}
	
	private void verificaBalanceamento(AVLNo noAtual) {
		if (noAtual == null) {return;}
		//CONFIGURA A VARIAVEL fatorBalanceamento DO NO ATUAL
		//FATOR BALANCEAMENTO = ESQUERDA - DIREITA
		configuraBalanceamento(noAtual);
		
		if (noAtual.getFatorBalanceamento() == 2) {
			if (noAtual.getSubEsquerda().getFatorBalanceamento() >= 0) {
				//CHAMA ROTACAO PARA DIREITA 
				noAtual = rotacionaDireita(noAtual);
			}
			
			else if (noAtual.getSubEsquerda().getFatorBalanceamento() <  0) {
				//CHAMA DUPLA ROTACAO ESQUERDA-DIREITA
				noAtual = rotacionaEsquerdaDireita(noAtual);
			}
		}
		
		else if (noAtual.getFatorBalanceamento() == -2) {
			if (noAtual.getSubDireita().getFatorBalanceamento() <= 0) {
				//CHAMA ROTACAO PARA ESQUERDA
				noAtual = rotacionaEsquerda(noAtual);
			}
			
			else if (noAtual.getSubDireita().getFatorBalanceamento() > 0) {
				//CHAMA DUPLA ROTACAO DIREITA-ESQUERDA
				noAtual = rotacionaDireitaEsquerda(noAtual);
			}
		}
		
		if (noAtual.getAncestral() == null) {
			raiz = noAtual;
		}
		
		else {
			verificaBalanceamento(noAtual.getAncestral());
		}
	}
	
	private AVLNo sucessor(AVLNo noAtual) {
		AVLNo sucessor;
		
		if (noAtual.getSubDireita() != null) {
			sucessor = noAtual.getSubDireita();
			
			while (sucessor.getSubEsquerda() != null) {
				sucessor = sucessor.getSubEsquerda();
			}
		}
		
		else {
			if (noAtual == noAtual.getAncestral().getSubEsquerda()) {
				sucessor = noAtual.getAncestral();
			}
			
			else {
				sucessor = noAtual;
			
				while (sucessor!= null && sucessor == sucessor.getAncestral().getSubDireita()) {
					sucessor = sucessor.getAncestral();
				}
				
				sucessor = sucessor.getAncestral();
			}
		}
		
		return sucessor;
	}
	
	private int  alturaNo(AVLNo noAtual) {
		int maxAltura = 0;
		
		if (noAtual != null) {
			maxAltura = 1 + Math.max(alturaNo(noAtual.getSubEsquerda()), alturaNo(noAtual.getSubDireita()));
		}
		
		return maxAltura;
	}
	
	private AVLNo rotacionaDireita(AVLNo noAtual) {
		AVLNo esquerdaAux = noAtual.getSubEsquerda();
		AVLNo ancestralAux = noAtual.getAncestral();
		
		esquerdaAux.setAncestral(ancestralAux);
		noAtual.setAncestral(esquerdaAux);
		noAtual.setSubEsquerda(esquerdaAux.getSubDireita());
		
		if (noAtual.getSubEsquerda() != null) {
			noAtual.getSubEsquerda().setAncestral(noAtual);
		}
		
		esquerdaAux.setSubDireita(noAtual);
		
		if(ancestralAux != null) {
			if (ancestralAux.getSubDireita() == noAtual) {
				ancestralAux.setSubDireita(esquerdaAux);
			}
			
			else if (ancestralAux.getSubEsquerda() == noAtual) {
				ancestralAux.setSubEsquerda(esquerdaAux);
			}
		}
		
		configuraBalanceamento(noAtual);
		configuraBalanceamento(esquerdaAux);
		
		return esquerdaAux;
	}
	
	private AVLNo rotacionaEsquerda(AVLNo noAtual) {
		AVLNo direitaAux = noAtual.getSubDireita();
		AVLNo ancestralAux = noAtual.getAncestral();
		
		direitaAux.setAncestral(ancestralAux);
		noAtual.setAncestral(direitaAux);
		noAtual.setSubDireita(direitaAux.getSubEsquerda());
		
		if (noAtual.getSubDireita() != null) {
			noAtual.getSubDireita().setAncestral(noAtual);
		}
		
		direitaAux.setSubEsquerda(noAtual);
		
		if (ancestralAux != null) {
			if (ancestralAux.getSubDireita() == noAtual) {
				ancestralAux.setSubDireita(direitaAux);
			}
			
			else if (ancestralAux.getSubEsquerda() == noAtual) {
				ancestralAux.setSubEsquerda(direitaAux);
			}
		}
		
		configuraBalanceamento(noAtual);
		configuraBalanceamento(direitaAux);
		
		return direitaAux;
	}
	
	private AVLNo rotacionaEsquerdaDireita(AVLNo noAtual) {
		noAtual = rotacionaEsquerda(noAtual.getSubEsquerda());
		noAtual = rotacionaDireita(noAtual.getAncestral());
		return noAtual;
	}
	
	private AVLNo rotacionaDireitaEsquerda(AVLNo noAtual) {
		noAtual = rotacionaDireita(noAtual.getSubDireita());
		noAtual = rotacionaEsquerda(noAtual.getAncestral());
		return noAtual;
	}
	
	private void configuraBalanceamento(AVLNo noAtual) {
		noAtual.setFatorBalanceamento(alturaNo(noAtual.getSubEsquerda()) - alturaNo(noAtual.getSubDireita()));
	}
	
	@Override
	public void infoInOrder() {
		if (raiz!= null) {
			infoInOrder(raiz);
		}
	}
	
	@Override
	public void infoPreOrder() {
		if (raiz != null) {
			infoPreOrder(raiz);
		}
	}
	
	private void infoPreOrder(AVLNo noAtual) {
		System.out.printf("Val: %d  FatBalanc: %d\n", noAtual.getValor(), noAtual.getFatorBalanceamento());
		
		if (noAtual.getSubEsquerda() != null) {
			infoPreOrder(noAtual.getSubEsquerda());
		}
		
		if (noAtual.getSubDireita() != null) {
			infoPreOrder(noAtual.getSubDireita());
		}
	}
	
	private void infoInOrder(AVLNo noAtual) {
		if (noAtual.getSubEsquerda() != null) {
			infoInOrder(noAtual.getSubEsquerda());
		}
		
		System.out.printf("Val: %d  FatBalanc: %d\n", noAtual.getValor(), noAtual.getFatorBalanceamento());
		
		if (noAtual.getSubDireita() != null) {
			infoInOrder(noAtual.getSubDireita());
		}
	}
	
	@Override
	public int sucessor(int chave) {
		return sucessor(raiz, chave);
	}
	
	private int sucessor(AVLNo noAtual, int chave) {
		if (noAtual == null) {
			System.out.println("Chave nao encontrada");
			return -10000;
		}
		
		else if (chave >  noAtual.getValor()) {
			return sucessor(noAtual.getSubDireita(), chave);
		}
		
		else if (chave < noAtual.getValor()) {
			return sucessor(noAtual.getSubEsquerda(), chave);
		}
		
		else {
			noAtual = sucessor(noAtual);
			if (noAtual != null) {
				return noAtual.getValor();
			}
			
			else {
				System.out.println("Nao ha sucessor");
				return -10000;
			}
		}
	}
}
