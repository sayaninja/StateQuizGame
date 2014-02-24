
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.imageio.*;

/** 
	Geopanel is a class that extends JPanel and implements ActionListener. It prints out the image of the blank map and holds all of the information about each of the 		states. It sets up the buttons for each of the states and sends QManager the user's input.
    @author Nina Kaufman
	@author Jenny Vien
	@author Zhansaya Abdikarimova
*/

public class Geopanel extends JPanel implements ActionListener{

	public JButton[] states;

	private BufferedImage map;
	public int totalscore = 0;
	public JButton answer;
	private QManager qManager;

	public Geopanel(){


		qManager = geomain.getQManager();

		this.setLayout(null);

		try{
			map = ImageIO.read(getClass().getClassLoader().getResource("map-of-united-states.jpg"));
		} 
		catch(IOException ie){}

		this.repaint();

//have to create an array of all the buttons with the states
//also have to fill in the array that holds all of the names of the states and which state number they are

		states = new JButton[50];
		
		int x=0;
		int y=0;
		int width=0;
		int height=0;
		String line;
		
		File fileName = new File("States.txt");  
		Scanner scanner = null;
		try {
			scanner = new Scanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<50;i++){
			
			line = scanner.nextLine();
			String[] splitted = line.split(",");
			
			states[i] = new JButton();
			this.add(states[i]);
			x=Integer.parseInt(splitted[1]);
			y=Integer.parseInt(splitted[2]);
			width = Integer.parseInt(splitted[3]);
			height = Integer.parseInt(splitted[4].trim());
			states[i].setBounds(x,y,width,height);
			states[i].addActionListener(this);	
			qManager.setStateName(splitted[0], i);			
		}
		
		scanner.close();
		
	}
/**
	Prints the image of the blank map.
*/

	public void paintComponent(Graphics g){

		g.drawImage(map, 0, 0, this);
	}

/**
	Sets the answer to a.
*/

	public void setAnswer(JButton a){
		this.answer = a;
	}

/**
	Sends the button clicked to qManager. 
*/

	public void actionPerformed(ActionEvent e){
		qManager.receiveAnswer(e.getSource());
	}
}