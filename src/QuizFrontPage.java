
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

/**
 * QuizFrontPage sets up the frame that opens up when a user starts the game.
 * 
 * @author Jenny Vien
 * @author Zhansaya Abdikarimova
 */
 
 public class QuizFrontPage extends JPanel implements ActionListener{
 	
 	private JButton stateButton;
 	private JButton capitalButton;
 	private JLabel title;
 	private BufferedImage map;
 	
 	
 	public QuizFrontPage(){
		
 		
 		try{
	    	map = ImageIO.read(getClass().getClassLoader().getResource("image/front.jpg"));
		} catch(IOException ie){}
		this.repaint();
 		
		
		title = new JLabel("Welcome to Country Quiz!",JLabel.CENTER);
		Font titleFont = new Font("TimesRoman",Font.PLAIN,50);
		title.setFont(titleFont);
		 
 		stateButton = new JButton("States");
		capitalButton = new JButton("Capitals");
		stateButton.addActionListener(this);
		//stateButton.addtActionListener(this);
		
		this.setLayout(null);
		title.setBounds(100,80,800,200);
		stateButton.setBounds(340,280,300,100);
		capitalButton.setBounds(340,400,300,100);
		
		this.add(title);
		this.add(stateButton);
 		this.add(capitalButton);
		
		
 		//this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
 		//stateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
 		//capitalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
 		
 		this.setVisible(true);
 		
 	}
 	
 	public void paintComponent(Graphics g){
	 g.drawImage(map, 0, 0,980,680, this);
	    
    }
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	} 
 
 }
 