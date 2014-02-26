import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * @author Zhansaya Abdikarimova
 *
 */

public class Country {
	private String name;
	private String capital;
	private ArrayList<State> states;
	
	
	public Country(){
		states = new ArrayList<State>();
		this.name = null;
		this.capital = null;

	}

	/**
	 * @param name
	 * @param capital
	 */
	public Country(String name, String capital){
		states = new ArrayList<State>();
		this.name = name;
		this.capital = capital;
		
	}
	
	/**
	 * @return
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @return
	 */
	public String getCapital(){
		return this.capital;
	}
	
	/**
	 * @param name
	 */
	
	public void setName(String name){
		 this.name = name;
	}
	
	/**
	 * @param capital
	 */
	public void setCapital(String capital){
		 this.capital = capital;
	}
	
	
	/**
	 * @param numberOfStates
	 * @param file
	 */
	public void addStates(int numberOfStates, File file) throws Exception {
		Scanner scanner = new Scanner(file);
		
		String line;
		int x;
		int y;
		
		for(int i=0;i<numberOfStates;i++){
			line = scanner.nextLine();
			String[] splitted = line.split(",");
			
			x=Integer.parseInt(splitted[2]);
			y=Integer.parseInt(splitted[3]);
			states.add(new State(splitted[0],splitted[1],x,y));
			//System.out.println(states.get(i));
		}
	}
	
	public ArrayList<State> getStatesArray(){
		return states;
	}
	@Override
	public String toString(){
		return this.getName()+" "+this.getCapital();
		
	}
}
