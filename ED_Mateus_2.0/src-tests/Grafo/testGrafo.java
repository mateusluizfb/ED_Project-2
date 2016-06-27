package Grafo;

import junit.framework.TestCase;

public class testGrafo extends TestCase {

	
	public void testeaddVertices() {
		Grafo<Integer> g = new Grafo<>(true);
		
		assertEquals(0, g.quantidadeVertices());

		g.addVertice(new Vertice<>(new Integer(5)));
		g.addVertice(new Vertice<>(new Integer(10)));
		g.addVertice(new Vertice<>(new Integer(20)));
		
		assertEquals(3, g.quantidadeVertices());
	}
	
	public void testeDistancia() {
		Grafo<Character> g = new Grafo<>(false);
	
		g.addVertice(new Vertice<>('s'));
		g.addVertice(new Vertice<>('r'));
		g.addVertice(new Vertice<>('t'));
		g.addVertice(new Vertice<>('u'));
		g.addVertice(new Vertice<>('w'));
		g.addVertice(new Vertice<>('v'));
		g.addVertice(new Vertice<>('x'));
		g.addVertice(new Vertice<>('y'));
		
		g.addAresta('v', 'r');
		g.addAresta('r', 's');
		g.addAresta('s', 'w');
		g.addAresta('w', 't');
		g.addAresta('w', 'x');
		g.addAresta('x', 'u');
		g.addAresta('x', 'y');
		g.addAresta('x', 't');
		g.addAresta('u', 'y');
		g.addAresta('u', 't');
		
		assertEquals(0, g.range('s', 's'));
		
		assertEquals(1, g.range('s', 'r'));
		
		assertEquals(3, g.range('s', 'y'));
		
	}
	
	public void testDFS(){
		
		Grafo<Character> g = new Grafo<>(false);
		
		g.addVertice(new Vertice<>('s'));
		g.addVertice(new Vertice<>('r'));
		g.addVertice(new Vertice<>('t'));
		g.addVertice(new Vertice<>('u'));
		g.addVertice(new Vertice<>('w'));
		g.addVertice(new Vertice<>('v'));
		g.addVertice(new Vertice<>('x'));
		g.addVertice(new Vertice<>('y'));
		
		g.addAresta('v', 'r');
		g.addAresta('r', 's');
		g.addAresta('s', 'w');
		g.addAresta('w', 't');
		g.addAresta('w', 'x');
		g.addAresta('x', 'u');
		g.addAresta('x', 'y');
		g.addAresta('x', 't');
		g.addAresta('u', 'y');
		g.addAresta('u', 't');
		
		g.dfs();
		
		System.out.println(g.find('r').range + " " + g.find('r').finalRange);
		
		assertEquals(1, g.find('r').range); //por algum motivo o programa não funciona se não for por modo debug
	}
}

