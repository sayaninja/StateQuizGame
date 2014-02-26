/**
 * 
 */

/**
 * @author Zhansaya Abdikarimova
 *
 */

public class State {
	
	private String name;
	private String capital;
	private int xCoord;
	private int yCoord;
	
	public State(){
		
	}

	/**
	 * @param name
	 * @param capital
	 * @param x
	 * @param y
	 */
	public State(String name, String capital, int x, int y){
		this.name = name;
		this.capital = capital;
		this.xCoord = x;
		this.yCoord = y;
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
	 * @return
	 */
	public int getXCoord(){
		return this.xCoord;
	}
	
	public int getYCoord(){
		return this.yCoord;
	}
	
	public void setName(String name){
		 this.name = name;
	}
	
	public void setCapital(String capital){
		 this.capital = capital;
	}
	

	public void setXCoord(int x){
		 this.xCoord = x;
	}
	
	public void setYCoord(int y){
		 this.yCoord = y;
	}
	
	@Override
	public String toString(){
		return this.getName()+" "+this.getCapital();
		
	}
	
	
}
