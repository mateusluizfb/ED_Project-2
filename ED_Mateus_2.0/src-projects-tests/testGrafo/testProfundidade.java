package testGrafo;

import GrafoBuscaEmProfundidade.GrafoComBuscaEmProfundidade;
import GrafoBuscaEmProfundidade.Vertice;
import junit.framework.TestCase;

public class testProfundidade extends TestCase {
	
	public void testeaddVertices() {
		GrafoComBuscaEmProfundidade<Integer> g = new GrafoComBuscaEmProfundidade<>(true);
		
		assertEquals(0, g.quantidadeVertices());

		g.addVertice(new Vertice<>(new Integer(5)));
		g.addVertice(new Vertice<>(new Integer(10)));
		g.addVertice(new Vertice<>(new Integer(20)));
		
		assertEquals(3, g.quantidadeVertices());
	}
	
	public void testeDistancia() {
		GrafoComBuscaEmProfundidade<Character> g = new GrafoComBuscaEmProfundidade<>(false);
	
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
		
		Vertice<Character> temp = g.find('v');
		g.buscaEmProfundidade(temp);
	}
}
