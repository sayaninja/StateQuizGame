import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * GUI sets up the GUI with the frame that holds the text for questions and answers and the scrollbar.
 * 
 * @author Nina Kaufman
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */


public class GUI {

	private GamePanel geo; // geo is a GamePanel reference
	private JFrame frame;
	private JTextArea questionTextArea; // text area on bottom where question displays
	private JScrollPane questionScrollPane;
	private JTextArea answerTextArea; // text area on right for correct answers
	private JScrollPane answerScrollPane;
	private Font ourFont;
	
	private QuizFrontPage frontPage;
	

	public GUI() {
	    ourFont = new Font("Arial", Font.PLAIN, 24);
	    geo = new GamePanel();
	    
	    frontPage = new QuizFrontPage();
		
	    //Setting up the text area to display questions
	    questionTextArea = new JTextArea(4, 20);
	    questionTextArea.setLineWrap(true);	

	    questionScrollPane = new JScrollPane(questionTextArea);
	    questionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    questionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    questionScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
		    public void adjustmentValueChanged(AdjustmentEvent e) {  
			e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
		    }
	    });

	    questionTextArea.setFont(ourFont);
	    questionTextArea.append("Welcome to the USA map quiz!\n");
	    questionTextArea.setEditable(false);
		
	    //Set up text area to display answers
	    answerTextArea = new JTextArea(20,10);
	    answerTextArea.setLineWrap(true);
	    answerScrollPane = new JScrollPane(answerTextArea);
	    answerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    answerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
	    answerTextArea.setFont(ourFont);
	    answerTextArea.append("Correct Answers:\n");
	    answerTextArea.setEditable(false);
		
		
		
	    frame = new JFrame();

	    frame.setSize(980, 680);
	    frame.setTitle("You think you know all US states?");
	    
	    frame.getContentPane().add(frontPage);
	    
	    //frame.getContentPane().add(BorderLayout.CENTER, geo);
	    //frame.getContentPane().add(BorderLayout.SOUTH, questionScrollPane);
	    //frame.getContentPane().add(BorderLayout.EAST, answerScrollPane);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocation(20, 40);
	    frame.setResizable(false);
	    frame.setVisible(true);

	    geo.repaint();

	}

	/**
	 * @return questionTextArea the Text Area with questions
	 */
	public JTextArea getQuestionTextArea() {
	    return this.questionTextArea;
	}

	/**
	 * Adds text to the questionTextArea.
	 * @param txt 
	 */
	public void setQuestionTextArea(String txt) {
	    this.questionTextArea.append(txt);
	}
	
	/**
	 * @return answerTextArea the Text Area with correct answers
	 */
	public JTextArea getAnswerTextArea() {
	    return this.answerTextArea;
	}

	/**
	 * @param txt answer that goes into answerTextAres
	 */
	public void setAnswerTextArea(String txt) {
	    this.answerTextArea.append(txt + "\n");
	}

	/**
	 * @return geo panel of the map 
	 */
	public GamePanel getGamePanel() {
	    return this.geo;
	}
}
