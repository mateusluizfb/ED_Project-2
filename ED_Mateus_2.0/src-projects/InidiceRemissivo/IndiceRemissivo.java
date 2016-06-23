package InidiceRemissivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;


public class IndiceRemissivo<T> {
	
	HashMap<String, String> map;

	
	public IndiceRemissivo(){
		map = new HashMap<String, String>();
	}
	
	public void populateMap(String keyWord){
		map.put(keyWord, " ");
	}

	public void check() {
		String file = "text.txt";
		String line = null;
		 
		try {
	            FileReader fileReader = new FileReader(file);

	            BufferedReader bufferedReader =  new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {   
	            	checkLine(line);
	            	
	                System.out.println(line);
	            }   
	            bufferedReader.close();         
	    }catch(FileNotFoundException ex) {
	            System.out.println( "Unable to open file '" + file + "'");                
        }catch(IOException ex) {
	            System.out.println("Error reading file '"  + file + "'");                  
        }
		
	}
	
	public void checkLine(String line){
		StringTokenizer lineTokens = new StringTokenizer(line);
		StringTokenizer lineTokens2 = new StringTokenizer(line);
		String token2 = "";
		String token = "";
		String number= "";
		
		if(lineTokens2.hasMoreTokens()){
			token2 = lineTokens.nextToken();
		} else if(isNumeric(token2)){
			number = token2;
		}
		
		if(lineTokens.hasMoreTokens()){
			token = lineTokens.nextToken();
			for(String s : map.keySet()){
				if (s == token){
					map.put(s, number);
				}
			}
		}
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

}
