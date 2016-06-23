package testIndice;

import IndiceRemissivo.IndiceRemissivo;
import junit.framework.TestCase;

public class testIndice extends TestCase {
	
	IndiceRemissivo indice = new IndiceRemissivo();
	
	public void setUp(){
		
		indice.populateMap("and");
		indice.populateMap("be");
		indice.populateMap("by");
		indice.populateMap("easy");
		indice.populateMap("human-engineered");
		indice.populateMap("programming");
		indice.populateMap("programs");
		indice.populateMap("to");
		
		
	}
	
	public void testAddMap(){
		
		assertEquals(true, indice.findKeyword("and"));
		assertEquals(true, indice.findKeyword("be"));
		assertEquals(true, indice.findKeyword("by"));
		assertEquals(true, indice.findKeyword("easy"));
		assertEquals(true, indice.findKeyword("human-engineered"));
		assertEquals(true, indice.findKeyword("programming"));
		assertEquals(true, indice.findKeyword("programs"));
		assertEquals(true, indice.findKeyword("to"));
		assertEquals(false, indice.findKeyword("robot"));
		assertEquals(false, indice.findKeyword("Java"));
		assertEquals(false, indice.findKeyword("hue"));
	}
	
	public void testCheck(){
		
		indice.check();
		indice.resultArchive(); //arquivo é gerado na pasta do projeto, apos executar apenas rode um "Refresh"
		
	}

}
