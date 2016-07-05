/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;


import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe que representa uma medicao do processo de ordenacao.
 * 
 * @author rbonifacio
 */
class Medicao {
	private static final String SEP = ",";

	private String algoritmo;
	private int tamanhoAmostra;
	private int repeticao;
	private long tempoOrdenacao;

	public Medicao(String algoritmo, int tamanhoAmostra, int repeticao, long tempoOrdenacao) {
		this.algoritmo = algoritmo;
		this.tamanhoAmostra = tamanhoAmostra;
		this.repeticao = repeticao;
		this.tempoOrdenacao = tempoOrdenacao;
	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public int getTamanhoAmostra() {
		return tamanhoAmostra;
	}

	public int getRepeticao() {
		return repeticao;
	}

	public long getTempoOrdenacao() {
		return tempoOrdenacao;
	}

	@Override
	public String toString() {
		return algoritmo + SEP + tamanhoAmostra + SEP + repeticao + SEP + tempoOrdenacao;
	}
}

/**
 * Classe que representa o programa principal, e que eh responsavel por coletar
 * o tempo de ordenacao de diferentes algoritmos.
 * 
 * @author rbonifacio
 */
public class BenchmarkInsercao {
	private static final int REPETICOES = 10;
	private static final int AMOSTRAS[] = { 100, 1000, 10000 };
	
	private static void insereValores(ArvoreDeBusca arvore, int tamanhoAmostra) {
		for (int i = 0; i <	tamanhoAmostra; i++) {
			arvore.inserir(ThreadLocalRandom.current().nextInt(0, tamanhoAmostra + 1));
		}
	}
	
	public static void main(String[] args) {
		//array com as implementacoes dos tipos
		//de arvores binarias de busca, onde cada
		//arvore implementa a interface ArvoreDeBusca
		//que contem os metodos de insercao e busca dentre outros
		
		ArvoreDeBusca[] arrayDeArvores = { new ArvoreAVL(), new ArvoreRedBlack() };
		
		String nomeArquivo = "bench-insercao-" + System.currentTimeMillis();
		Path arquivo = Paths.get(nomeArquivo);
		
		try (BufferedWriter writer = Files.newBufferedWriter(arquivo)){
			for (ArvoreDeBusca arvore : arrayDeArvores) {
				for (int tamanhoAmostra : AMOSTRAS) {
					for (int i = 0; i < REPETICOES; i++) {
						long t1 = System.nanoTime();
						
						insereValores(arvore, tamanhoAmostra);
						long t2 = System.nanoTime();
						
						Medicao m  = new Medicao(arvore.getClass().toString(), tamanhoAmostra, i, t2 - t1);
						writer.write(m.toString() + "\n");
						arvore.limpaArvore();
					}
				}
			}
		}
		
		catch (Exception e) {
			System.out.println("Um problema ocorreu na execucao do benchmarking");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
