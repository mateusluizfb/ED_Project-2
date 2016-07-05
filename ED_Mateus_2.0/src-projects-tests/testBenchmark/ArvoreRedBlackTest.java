/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testBenchmark;

import Benchmark.ArvoreDeBusca;
import Benchmark.ArvoreRedBlack;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franco
 */
public class ArvoreRedBlackTest {
	
	public ArvoreRedBlackTest() {
	}

	/**
	 * Test of inserir method, of class ArvoreRedBlack.
	 */
	@Test
	public void testInserir() {
		ArvoreDeBusca arvore = new ArvoreRedBlack();
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			arvore.inserir(random.nextInt(100));
		}
		
		arvore.infoPreOrder();
	}

	/**
	 * Test of remover method, of class ArvoreRedBlack.
	 */
	@Test
	public void testRemover() {
	}

	/**
	 * Test of pesquisa method, of class ArvoreRedBlack.
	 */
	@Test
	public void testPesquisa() {
	}

	/**
	 * Test of altura method, of class ArvoreRedBlack.
	 */
	@Test
	public void testAltura() {
	}

	/**
	 * Test of infoInOrder method, of class ArvoreRedBlack.
	 */
	@Test
	public void testInfoInOrder() {
	}

	/**
	 * Test of sucessor method, of class ArvoreRedBlack.
	 */
	@Test
	public void testSucessor() {
	}
	
}
