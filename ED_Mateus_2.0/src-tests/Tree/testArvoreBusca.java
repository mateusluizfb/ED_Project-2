package Tree;

import junit.framework.TestCase;

public class testArvoreBusca extends TestCase {

	private BSTRecursive arvore; 
	
	@Override
	public void setUp() {
		arvore = new BSTRecursive(6);
		
		arvore.inserir(4);
		arvore.inserir(7);
		
		arvore.inserir(2);
		arvore.inserir(5);
		
		arvore.inserir(8);
	}
	
	public void testInserir() {
		assertNotNull(arvore.pesquisar(6));
		
		assertNull(arvore.pesquisar(6).ancestral);
		
		assertNotNull(arvore.pesquisar(4));
		assertEquals(arvore.pesquisar(6), arvore.pesquisar(4).ancestral);
		assertNotNull(arvore.pesquisar(7));
		assertEquals(arvore.pesquisar(6), arvore.pesquisar(7).ancestral);
		
		assertEquals(arvore.pesquisar(4), arvore.pesquisar(2).ancestral);
		assertEquals(arvore.pesquisar(4), arvore.pesquisar(5).ancestral);
		assertEquals(arvore.pesquisar(6), arvore.pesquisar(5).ancestral.ancestral);
		
		
	}
	
}

