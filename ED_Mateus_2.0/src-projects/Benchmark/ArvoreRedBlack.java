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
public class ArvoreRedBlack implements ArvoreDeBusca {
	RBNo raiz;
	
	@Override
	public void limpaArvore() {
		raiz = null;
	}
	
	@Override
	public void inserir(int valor) {
		if (raiz == null) {
			raiz = new RBNo(valor, Cor.PRETO);
		}
		
		else {
			inserir(raiz, valor);
		}
	}
	
	private void inserir(RBNo noAtual, int valor) {
		if (valor > noAtual.getValor()) {
			if (noAtual.getSubDireita() == null) {
				noAtual.setSubDireita(new RBNo(valor, noAtual, Cor.VERMELHO));
				balanceiaArvore(noAtual.getSubDireita());
			}
			
			else {
				inserir(noAtual.getSubDireita(), valor);
			}
		}
		
		else if (valor < noAtual.getValor()) {
			if (noAtual.getSubEsquerda() == null) {
				noAtual.setSubEsquerda(new RBNo(valor, noAtual, Cor.VERMELHO));
				balanceiaArvore(noAtual.getSubEsquerda());
						
			}
			
			else {
				inserir(noAtual.getSubEsquerda(), valor);
			}
		}
		
		else {
			//NAO INSERER VALORES REPETIDOS
		}
	}
	
	private void balanceiaArvore(RBNo noAtual) {
		insercaoCaso1(noAtual);
	}
	
	private void insercaoCaso1(RBNo noAtual) {
		if (noAtual.getAncestral() == null) {
			noAtual.setCor(Cor.PRETO);
		}
		
		else {
			insercaoCaso2(noAtual);
		}
	}
	
	private void insercaoCaso2(RBNo noAtual) {
		if (noAtual.getAncestral().getCor() != Cor.PRETO) {
			insercaoCaso3(noAtual);
		}
	}
	
	private void insercaoCaso3(RBNo noAtual) {
		RBNo tioAux = retornaTio(noAtual);
		RBNo avoAux = retornaAvo(noAtual);
		Cor tioCor = retornaCor(tioAux);
		
		if (tioAux != null && tioCor == Cor.VERMELHO) {
			tioAux.setCor(Cor.PRETO);
			noAtual.getAncestral().setCor(Cor.PRETO);
			avoAux.setCor(Cor.VERMELHO);
			insercaoCaso1(avoAux);
		}
		
		else {
			insercaoCaso4(noAtual);
		}
	}
	
	private void insercaoCaso4(RBNo noAtual) {
		RBNo paiAux = noAtual.getAncestral();
		
		if (filhoDireita(noAtual) && filhoEsquerda(paiAux)) {
			//FAZ ROTACAO A ESQUERDA
			rotacionaEsquerda(noAtual.getAncestral());
			noAtual = noAtual.getSubEsquerda();
		}
		
		else if (filhoEsquerda(noAtual) && filhoDireita(paiAux)) {
			//FAZ ROTACAO A DIREITA
			rotacionaDireita(noAtual.getAncestral());
			noAtual = noAtual.getSubDireita();
		}
		
		insercaoCaso5(noAtual);
	}
	
	private void insercaoCaso5(RBNo noAtual) {
		RBNo avoAux = retornaAvo(noAtual);
		
		noAtual.getAncestral().setCor(Cor.PRETO);
		avoAux.setCor(Cor.VERMELHO);
		
		if (filhoEsquerda(noAtual) && filhoEsquerda(noAtual.getAncestral())) {
			rotacionaDireita(avoAux);
		}
		
		else if (filhoDireita(noAtual) && filhoDireita(noAtual.getAncestral())) {
			int i  = 0;
			rotacionaEsquerda(avoAux);
		}
	}

	private RBNo retornaTio(RBNo noAtual) {
		RBNo avoAux = retornaAvo(noAtual);
		if (noAtual.getAncestral() == avoAux.getSubDireita()) {
			return avoAux.getSubEsquerda();
		}
		else {
			return avoAux.getSubDireita();
		}
	}
	
	private RBNo retornaAvo(RBNo noAtual) {
		return noAtual.getAncestral().getAncestral();
	}
	
	private Cor retornaCor(RBNo no) {
		if (no == null) {
			return Cor.PRETO;
		}
		
		return no.getCor();
	}
	
	private boolean filhoDireita(RBNo noAtual) {
		return noAtual == noAtual.getAncestral().getSubDireita();
	}
	
	private boolean filhoEsquerda(RBNo noAtual) {
		return noAtual == noAtual.getAncestral().getSubEsquerda();
	}
	
	private void rotacionaEsquerda(RBNo noAtual) {
		RBNo direitaAux = noAtual.getSubDireita();
		RBNo ancestralAux = noAtual.getAncestral();
		
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
		
			else {
				ancestralAux.setSubEsquerda(direitaAux);
			}
		}
		
		else {
			raiz = direitaAux;
		}
	}
	
	private void rotacionaDireita(RBNo noAtual) {
		RBNo ancestralAux = noAtual.getAncestral();
		RBNo esquerdaAux = noAtual.getSubEsquerda();
		
		esquerdaAux.setAncestral(ancestralAux);
		noAtual.setAncestral(esquerdaAux);
		noAtual.setSubEsquerda(esquerdaAux.getSubDireita());
		
		if (noAtual.getSubEsquerda() != null) {
			noAtual.getSubEsquerda().setAncestral(noAtual);
		}
		
		esquerdaAux.setSubDireita(noAtual);
		
		if (ancestralAux != null) {
			if (ancestralAux.getSubDireita() == noAtual) {
				ancestralAux.setSubDireita(esquerdaAux);
			}
		
			else {
				ancestralAux.setSubEsquerda(esquerdaAux);
			}
		}
		
		else {
			raiz = esquerdaAux;
		}
	}
	
	@Override
	public void remover(int valor) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean pesquisa(int valor) {
		if (raiz != null) {
			return pesquisa(raiz, valor);
		}
		
		return false;
	}
	
	private boolean pesquisa(RBNo noAtual, int valor) {
		if (noAtual.getValor() == valor) {
			return true;
		}
		
		if (valor > noAtual.getValor()) {
			if (noAtual.getSubDireita() != null) {
				return pesquisa(noAtual.getSubDireita(), valor);
			}
			
			else {
				if (noAtual.getSubEsquerda() != null) {
					return pesquisa(noAtual.getSubEsquerda(), valor);
				}
			}
		}
		
		return false;
	}

	@Override
	public int altura() {
		if (raiz == null) {
			return 0;
		}
		
		return altura(raiz);
	}
	
	private int altura(RBNo noAtual) {
		int maxAltura = 0;
		
		if (noAtual != null) {
			maxAltura = 1 + Math.max(altura(noAtual.getSubEsquerda()), altura(noAtual.getSubDireita()));
		}
		
		return maxAltura;
	}

	@Override
	public void infoInOrder() {
		if (raiz != null) {
			infoInOrder(raiz);
		}
	}
	
	@Override public void infoPreOrder() {
		if (raiz != null) {
			infoPreOrder(raiz);
		}
	}
	
	private void infoInOrder(RBNo noAtual) {
		if (noAtual.getSubEsquerda() != null) {
			infoInOrder(noAtual.getSubEsquerda());
		}
		
		System.out.printf("Valor: %d Cor : %s\n", noAtual.getValor(), noAtual.getCor());
	
		if (noAtual.getSubDireita() != null) {
			infoInOrder(noAtual.getSubDireita());
		}
	}
	
	private void infoPreOrder(RBNo noAtual) {
		System.out.printf("Valor: %d Cor : %s\n", noAtual.getValor(), noAtual.getCor());
		
		if (noAtual.getSubEsquerda() != null) {
			infoPreOrder(noAtual.getSubEsquerda());
		}
	
		if (noAtual.getSubDireita() != null) {
			infoPreOrder(noAtual.getSubDireita());
		}
	}

	@Override
	public int sucessor(int chave) {
		return sucessor(raiz, chave);
	}
	
	private int sucessor(RBNo noAtual, int chave) {
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
	
	private RBNo sucessor(RBNo noAtual) {
		RBNo sucessor;
		
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
}
