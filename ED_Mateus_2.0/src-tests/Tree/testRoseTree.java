package Tree;

import junit.framework.TestCase;

public class testRoseTree extends TestCase {
	private RoseTree rt;
	
	@Override
	public void setUp() {
		rt = new RoseTree(1);
		
		rt.inserir(1, 2);
		rt.inserir(1, 3);
		rt.inserir(1, 4);
		rt.inserir(1, 4);
		rt.inserir(1, 5);
		rt.inserir(1, 6);
		rt.inserir(1, 7);
		
		rt.inserir(4, 8);
		
		rt.inserir(5, 9);
		rt.inserir(5, 10);
		
		rt.inserir(10, 11);
		rt.inserir(10, 12);
	
		rt.inserir(6,13);
		rt.inserir(6,14);
		rt.inserir(6,15);
	}

	public void testInsercao() {
		assertNotNull(rt.pesquisar(1));
		assertNotNull(rt.pesquisar(2));
		assertNotNull(rt.pesquisar(3));
		assertNotNull(rt.pesquisar(4));
		assertNotNull(rt.pesquisar(5));
		assertNotNull(rt.pesquisar(6));
		assertNotNull(rt.pesquisar(7));
		
		assertNull(rt.pesquisar(1).ancestral);
		assertEquals(rt.pesquisar(1), rt.pesquisar(2).ancestral);
		assertEquals(rt.pesquisar(1), rt.pesquisar(7).ancestral);
		
		assertEquals(rt.pesquisar(4), rt.pesquisar(8).ancestral);
		assertEquals(rt.pesquisar(1), rt.pesquisar(8).ancestral.ancestral);
		
		assertEquals(rt.pesquisar(10), rt.pesquisar(11).ancestral);
		assertEquals(rt.pesquisar(10), rt.pesquisar(12).ancestral);
		
		assertEquals(rt.pesquisar(6), rt.pesquisar(13).ancestral);
		assertEquals(rt.pesquisar(6), rt.pesquisar(14).ancestral);
		assertEquals(rt.pesquisar(6), rt.pesquisar(15).ancestral);
		
		assertEquals(rt.pesquisar(1), rt.pesquisar(15).ancestral.ancestral);
	}
	
	public void testDeletar() {
		assertEquals(rt.pesquisar(6), rt.pesquisar(13).ancestral);
		assertEquals(rt.pesquisar(6), rt.pesquisar(14).ancestral);
		assertEquals(rt.pesquisar(6), rt.pesquisar(15).ancestral);
		
		
		rt.remover(6);
	
		assertNotNull(rt.pesquisar(1));
		assertNotNull(rt.pesquisar(2));
		assertNotNull(rt.pesquisar(3));
		assertNotNull(rt.pesquisar(4));
		assertNotNull(rt.pesquisar(5));
		assertNotNull(rt.pesquisar(7));
	
		assertEquals(rt.pesquisar(10), rt.pesquisar(11).ancestral);
		assertEquals(rt.pesquisar(10), rt.pesquisar(12).ancestral);
		
		assertNull(rt.pesquisar(6));
		assertNull(rt.pesquisar(13));
		assertNull(rt.pesquisar(14));
		assertNull(rt.pesquisar(15));
		
	}
	
	public void testAltura() {
		assertEquals(4, rt.altura());
		
		assertEquals(1, rt.pesquisar(11).altura());
		assertEquals(2, rt.pesquisar(10).altura());
		assertEquals(3, rt.pesquisar(5).altura());
		assertEquals(4, rt.pesquisar(1).altura());
		
	}
}
