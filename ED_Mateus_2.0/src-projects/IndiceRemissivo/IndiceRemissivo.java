package IndiceRemissivo;
/**
 * 
 * @author mateus
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.StringTokenizer;

import Lists.LinkedListGeneric;


public class IndiceRemissivo {
	
	HashMap<String, LinkedListGeneric<String>> map;

	
	public IndiceRemissivo(){
		map = new HashMap<String, LinkedListGeneric<String>>();
	}
	
	public void populateMap(String keyWord){
		map.put(keyWord, new LinkedListGeneric<String>());
	}
	
	public boolean findKeyword(String keyWord){
		return map.containsKey(keyWord);
	}

	public void check() {
		String file = "text.txt";
		String line = null;
		 
		try { // vai ler as linhas do arquivo
	            FileReader fileReader = new FileReader(file);

	            BufferedReader bufferedReader =  new BufferedReader(fileReader);
	            
	            while((line = bufferedReader.readLine()) != null) {
	            	line = line.replaceAll(",", "");
	            	line = line.replaceAll(".", "");
	            	line = line.replaceAll(":", "");
	            	line = line.replaceAll("?", "");
	            	line = line.replaceAll(";", "");
	            	line = line.replaceAll("!", "");
	            	checkLine(line);
	            } 
	            
	            
	            bufferedReader.close();         
	    }catch(FileNotFoundException ex) {
	            System.out.println( "Unable to open file '" + file + "'");                
        }catch(IOException ex) {
	            System.out.println("Error reading file '"  + file + "'");                  
        }
		
	}
	
	protected void checkLine(String line){
		StringTokenizer lineTokens = new StringTokenizer(line); // linha para procurar a palavra
		StringTokenizer lineTokens2 = new StringTokenizer(line); // linha para procurar o numero
		String token2 = "";
		String token = "";
		String number= "";
		
		while(true){	
			token2 = lineTokens2.nextToken();
			
			if(isNumeric(token2)){
				number = token2;
				break;
			}
		}
		
		while(lineTokens.hasMoreTokens()){
			token = lineTokens.nextToken().toLowerCase();
			for(String s : map.keySet()){
				if (s.equals(token)){
					map.get(s).insert(0, number);
				}
			}
		}
	}
	
	protected static boolean isNumeric(String str){
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	
	public void resultArchive(){
		
		try {
			PrintWriter archive = new PrintWriter("result.txt", "UTF-8");
			
			for(String s: map.keySet()){
				archive.print(s + ": ");
				for(int i = 0; i < map.get(s).size(); i++){
					archive.print(map.get(s).elementAt(i) + " ");
				}
				archive.println();
			}
			
			archive.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
