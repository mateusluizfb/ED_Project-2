package testEdges;


import ClassificacaoArestas.Grafo;
import ClassificacaoArestas.Vertice;
import junit.framework.TestCase;

public class testEdges extends TestCase {

	
	public void testEdgePrint(){
		Grafo<Character> g = new Grafo<>(true);
	
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
		g.showEdges();
		System.out.println();
		g.showValues();
		
	}
	
}
