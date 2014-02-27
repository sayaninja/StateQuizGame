import java.util.ArrayList;

import javax.swing.*;



/**
 * QuestionManager manages the current question and score
 * 
 * @author Nina Kaufman
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */

public class QuestionManager {
	private GUI gui;
	private MapPanel geo;
	
	private int currentQuestion;
	private int currentScore;

	//private String[] stateNames;
	
	private ArrayList<State> states;
	private ArrayList<Integer> randStateIndexes;
	private ArrayList<State> correctStates;
	private int randIndex;
	

	/**
	 * Constructor QuestionManager creates a new array of the fifty state names
	 */

	public QuestionManager() {

		states = new ArrayList<State>(); 
		
		
		

	}

	/**
	 * Sets the current question and score to zero and then asks the first
	 * question. Also gets the GUI and MapPanel from geomain.
	 */

	public void init() {
		correctStates = new ArrayList<State>();
		randStateIndexes = new ArrayList<Integer>();
		
		
		
		
		gui = geomain.getGUI();
		geo = gui.getMapPanel();
		states = geo.getCountry().getStatesArray();
		for(int i=0;i<states.size();i++){
			randStateIndexes.add(i);
			
		}
		randIndex = (int) (Math.random() * states.size());
		currentQuestion = randStateIndexes.get(randIndex);
		currentScore = 0;

		this.askNextQuestion();
	}

	/**
	 * Asks the next question if the question counter is less than 50. Prints
	 * out the current state.
	 */

	public void askNextQuestion() {
		
		if(!randStateIndexes.isEmpty()){
			geomain.getGUI().setQuestionTextArea("Click on: " + states.get(currentQuestion).getName() + "\n");
			geo.setAnswer(geo.stateButtons[currentQuestion]);
		}
		else
			geomain.getGUI().setQuestionTextArea("You're finished! Yay!");
	}

	/**
	 * Receives the answer from MapPanel and checks to see if the answer is
	 * equivalent to the current state. Prints out the current score and
	 * increments the counters.
	 */

	public void receiveAnswer(Object o) {
		JButton answer = (JButton) o;

		if (answer == geo.stateButtons[currentQuestion]) {
			geomain.getGUI().setQuestionTextArea("Congrats! ");
			geomain.getGUI().setAnswerTextArea(states.get(currentQuestion).getName());
			
			correctStates.add(states.get(currentQuestion));
			
			randStateIndexes.remove(randIndex);
			randIndex = (int) (Math.random() * (randStateIndexes.size()-1));
			currentQuestion = randStateIndexes.get(randIndex);
			currentScore++;
		} else {
			
			geomain.getGUI().setQuestionTextArea("Nope! ");
		}

		geomain.getGUI().setQuestionTextArea(
				"Your current score is: " + currentScore + "\n");
		this.askNextQuestion();
	}

	/**
	 * Sets the name of the state.
	 */

	
	
	

}