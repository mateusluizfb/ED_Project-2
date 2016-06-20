package Lists;

/**
 * Excecao usada para reportar que um argumento 
 * invalido foi passado para uma operacao. 
 * 
 * @author rbonifacio
 */
public class InvalidArgumentException extends RuntimeException {
	
	public InvalidArgumentException(){
		
	}
	
	public InvalidArgumentException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;
}
