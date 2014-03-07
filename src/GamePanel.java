import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.*;



/** 
    MapPanel is a class that extends JPanel and implements ActionListener. It prints out the image of the blank map and holds all of the information about each of the states. It sets up the buttons for each of the states and sends QuestionManager the user's input.
   
    @author Nina Kaufman
    @author Jenny Vien
    @author Zhansaya Abdikarimova
*/

public class GamePanel extends JPanel implements ActionListener{

   
	
    public JButton[] stateButtons;
    public ArrayList<State> statesArray;
    public int totalscore = 0;
    public JButton answer;
    
    private QuestionManager questionManager;
    private Country c;
    private BufferedImage map;

    public GamePanel(){
	questionManager = geomain.getQuestionManager();
	this.setLayout(null);
	try{
	    map = ImageIO.read(getClass().getClassLoader().getResource("map-of-united-states.jpg"));
	} 
	catch(IOException ie){}
	this.repaint();


       	stateButtons = new JButton[50];

       	int x=0;
	int y=0;
       	int width=25;
       	int height=25;
		
		
	File fileName = new File("States.txt");  
		
       	c = new Country();
	try {
      		c.addStates(50,fileName);
       	} catch (Exception e) {}
		
        statesArray = new ArrayList<State>();
	statesArray = c.getStatesArray();
	for(int i=0;i<statesArray.size();i++){
	    stateButtons[i] = new JButton();
	    this.add(stateButtons[i]);
	    x = statesArray.get(i).getXCoord();
	    y = statesArray.get(i).getYCoord();
	    stateButtons[i].setBounds(x,y,width,height);
	    stateButtons[i].addActionListener(this);	
	}
		
		
    }
    /**
	@param g Graphics object that prints the image of the map
    */

     public void paintComponent(Graphics g){
	 g.drawImage(map, 0, 0, this);
	    
     }

    /**
	@param button button that was clicked by a user
    */

    public void setAnswer(JButton button){
	this.answer = button;
    }

    /**
	Sends the button clicked to QuestionManager.
	@param e ActionEvent if user answered the question
    */

    public void actionPerformed(ActionEvent e){
	questionManager.receiveAnswer(e.getSource());
    }

    /**
     @return Country object 
    */

    public Country getCountry(){
	return c;
    }
}
