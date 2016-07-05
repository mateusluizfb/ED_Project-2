 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testBenchmark;

import java.util.Random;
import org.junit.Test;

import Benchmark.ArvoreAVL;
import Benchmark.ArvoreDeBusca;

import static org.junit.Assert.*;

/**
 *
 * @author Franco
 */
public class ArvoreAVLTest {
	
	public ArvoreAVLTest() {
	}

	/**
	 * Test of inserir method, of class ArvoreAVL.
	 */
	@Test
	public void testInserir() {
//		ArvoreDeBusca arvore = new ArvoreAVL();
//		
//		arvore.inserir(42);
//		arvore.inserir(52);
//		arvore.inserir(65);
//		arvore.inserir(79);
//		arvore.inserir(66);
//		arvore.inserir(67);
//		arvore.inserir(68);
//		arvore.inserir(85);
//		arvore.inserir(95);
//		
//		arvore.infoInOrder();
	}

	/**
	 * Test of remover method, of class ArvoreAVL.
	 */
	@Test
	public void testRemover() {
		ArvoreDeBusca arvore = new ArvoreAVL();
		Random random = new Random();
		int val;
		
		for (int i = 0; i < 20; i++) {
			val = random.nextInt(20);
			System.out.printf("%d\n", val);
			arvore.inserir(val);
		}
		
		System.out.println("NUMEROS A REMOVER");
		
		for (int i = 0; i < 5; i++) {
			val = random.nextInt(20);
			System.out.printf("%d\n", val);
			arvore.remover(val);
		}
	
		System.out.println("DEPOIS DA REMOCAO");
		arvore.infoInOrder();
	}

	/**
	 * Test of pesquisa method, of class ArvoreAVL.
	 */
	@Test
	public void testPesquisa() {
	}

	/**
	 * Test of altura method, of class ArvoreAVL.
	 */
	@Test
	public void testAltura() {
//		ArvoreDeBusca arvore = new ArvoreAVL();
//		
//		arvore.inserir(42);
//		arvore.inserir(25);
//		arvore.inserir(33);
//		arvore.inserir(12);
//		arvore.inserir(58);
//		arvore.inserir(99);
//		arvore.inserir(50);
//		
//		assertEquals(3, arvore.altura());
//		
//		arvore.inserir(100);
//		assertEquals(4, arvore.altura());
//		
//		arvore.inserir(101);
//		arvore.inserir(110);
//		arvore.inserir(120);
//		arvore.inserir(130);
//		arvore.inserir(140);
//		
//		assertEquals(9, arvore.altura());
	}

	/**
	 * Test of infoInOrder method, of class ArvoreAVL.
	 */
	@Test
	public void testInfoInOrder() {
	}

	/**
	 * Test of sucessor method, of class ArvoreAVL.
	 */
	@Test
	public void testSucessor() {
		ArvoreDeBusca arvore = new ArvoreAVL();
		
		arvore.inserir(42);
		arvore.inserir(25);
		arvore.inserir(33);
		arvore.inserir(12);
		arvore.inserir(58);
		arvore.inserir(99);
		arvore.inserir(50);
		
		assertEquals(50, arvore.sucessor(42));
		assertEquals(25, arvore.sucessor(12));
		assertEquals(42, arvore.sucessor(33));
		assertEquals(50, arvore.sucessor(42));
	}
}
