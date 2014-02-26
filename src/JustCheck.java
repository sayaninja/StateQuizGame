import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class JustCheck {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File fileName = new File("States.txt");  
	    Country c = new Country();
	    c.addStates(50, fileName);
	    ArrayList<State> stet = new ArrayList<State>();
	    
	    stet = c.getStatesArray();
	    
	    for(int i=0;i<50;i++)
	    	System.out.println(stet.get(i).toString());
	    
	     
	}

}
