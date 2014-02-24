import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class JustCheck {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File fileName = new File("States.txt");  
	    Scanner inFile = new Scanner(fileName);  
	    
	    String line = inFile.nextLine();
		System.out.println(line);
	    
	        
	      
	        
	    inFile.close();  
	}

}
