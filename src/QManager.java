import java.util.ArrayList;

import javax.swing.*;



/**
 * QManager manages the current question and score
 * 
 * @author Nina Kaufman
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */

public class QManager {
	private GUI gui;
	private Geopanel geo;
	private int currentQ;
	private int currentScore;

	private String[] stateNames;
	private ArrayList<Integer> randState;
	private ArrayList<String> correctStateNames;
	private int randIndex;
	

	/**
	 * Constructor QManager creates a new array of the fifty state names
	 */

	public QManager() {

		stateNames = new String[50];
		
		

	}

	/**
	 * Sets the current question and score to zero and then asks the first
	 * question. Also gets the GUI and Geopanel from geomain.
	 */

	public void init() {
		correctStateNames = new ArrayList<String>();
		
		randState = new ArrayList<Integer>();
		
		for(int i=0;i<50;i++){
			randState.add(i);
		}
		randIndex = (int) (Math.random() * 50);
		gui = geomain.getGUI();
		geo = gui.getGeopanel();

		currentQ = randState.get(randIndex);
		currentScore = 0;

		this.askNextQuestion();
	}

	/**
	 * Asks the next question if the question counter is less than 50. Prints
	 * out the current state.
	 */

	public void askNextQuestion() {
		
		if(!randState.isEmpty()){
			geomain.getGUI().setText("Click on: " + stateNames[currentQ] + "\n");
			geo.setAnswer(geo.states[currentQ]);
			
			
		}
		else
			geomain.getGUI().setText("You're finished! Yay!");
		
		
	}

	/**
	 * Receives the answer from Geopanel and checks to see if the answer is
	 * equivalent to the current state. Prints out the current score and
	 * increments the counters.
	 */

	public void receiveAnswer(Object a) {
		JButton answer = (JButton) a;

		if (answer == geo.states[currentQ]) {
			geomain.getGUI().setText("Congrats! ");
			correctStateNames.add(stateNames[currentQ]);
			System.out.println(stateNames[currentQ]);
			randState.remove(randIndex);
			randIndex = (int) (Math.random() * (randState.size()-1));
			currentQ = randState.get(randIndex);
			
			currentScore++;
		} else {
			
			geomain.getGUI().setText("Nope! ");
		}

		geomain.getGUI().setText(
				"Your current score is: " + currentScore + "\n");
		this.askNextQuestion();
	}

	/**
	 * Sets the name of the state.
	 */

	public void setStateName(String name, int index) {
		stateNames[index] = name;
	}
	
	

}