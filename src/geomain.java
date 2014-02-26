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
	private static QuestionManager QuestionManager;

	public static void main (String[] args){
		QuestionManager = new QuestionManager();		
		frame = new GUI();
		QuestionManager.init();
	}

	public static GUI getGUI(){
		return frame;
	}

	public static QuestionManager getQuestionManager()
	{
		return QuestionManager;
	}


}