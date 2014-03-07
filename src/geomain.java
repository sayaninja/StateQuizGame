
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

/** Geomain sets and initializes the frame and QuestionManager.
    @author Nina Kaufman
    @author Jenny Vien
    @author Zhansaya Abdikarimova
*/

public class geomain{

	private static GUI frame;
	private static QuizFrontPage frame1;
	private static QuestionManager questionManager;

	public static void main (String[] args){
		questionManager = new QuestionManager();		
		frame = new GUI();
		//frame1 = new QuizFrontPage();
		
		questionManager.init();
	}

	/**
	 * @return GUI frame the whole window of the game
	 */
	public static GUI getGUI(){
		return frame;
	}
	/**
	 * @return questionManager  
	 */

	public static QuestionManager getQuestionManager()
	{
		return questionManager;
	}


}
