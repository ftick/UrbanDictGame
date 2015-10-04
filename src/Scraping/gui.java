package Scraping;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	static String[] words;
	static Scanner sc;
	static String word = "";
	static int ans;
	static int count = 0;
	static int total = 0;
	static BufferedImage logo;
	
	// Create objects
	JLabel guessLbl;
	JLabel correctLbl;
	JLabel imageLbl;
	
	static JButton[] buttons = new JButton[4];
	
	public gui( String title ) throws IOException
	{
		super( title );
		
		// Set layout
		setLayout(new FlowLayout());
		
		guessLbl = new JLabel("                                                                             Word(s): " + word +  "                                                                            ");
		correctLbl = new JLabel("");
		logo = ImageIO.read(new File("src/logo.jpg"));
		imageLbl = new JLabel(new ImageIcon(logo));
		
		add(guessLbl);
		for(JButton b: buttons){
			add(b);
		}
		add(imageLbl);
		add(correctLbl);
		
		buttons[0].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(ans==0){
					back.playSound("src/correct.wav");
					count++; total++;
					correctLbl.setText("Correct! " + count + "/" + total);
				}else{
					back.playSound("src/incorrect.wav");
					total++;
					correctLbl.setText("Incorrect! " + count + "/" + total);
				}
				newWord();
				guessLbl.setText("                                                                             Word(s): " + word +  "                                                                            ");
				ans = (int) (Math.random()*4);
				try{
					if(ans==0){
						buttons[0].setText(back.getDef(word));
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getDef(word));
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getDef(word));
						buttons[3].setText(back.getRandomDef());
					}
					else{
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getDef(word));
					}
				}catch(IOException e){}
			}
		});
		
		buttons[1].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(ans==1){
					back.playSound("src/correct.wav");
					count++; total++;
					correctLbl.setText("Correct! " + count + "/" + total);
				}else{
					back.playSound("src/incorrect.wav");
					total++;
					correctLbl.setText("Incorrect! " + count + "/" + total);
				}
				newWord();
				guessLbl.setText("                                                                             Word(s): " + word +  "                                                                            ");
				ans = (int) (Math.random()*4);
				try{
					if(ans==0){
						buttons[0].setText(back.getDef(word));
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getDef(word));
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getDef(word));
						buttons[3].setText(back.getRandomDef());
					}
					else{
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getDef(word));
					}
				}catch(IOException e){}
			}
		});
		
		buttons[2].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(ans==2){
					back.playSound("src/correct.wav");
					count++; total++;
					correctLbl.setText("Correct! " + count + "/" + total);
				}else{
					back.playSound("src/incorrect.wav");
					total++;
					correctLbl.setText("Incorrect! " + count + "/" + total);
				}
				newWord();
				guessLbl.setText("                                                                             Word(s): " + word +  "                                                                            ");
				ans = (int) (Math.random()*4);
				try{
					if(ans==0){
						buttons[0].setText(back.getDef(word));
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getDef(word));
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getDef(word));
						buttons[3].setText(back.getRandomDef());
					}
					else{
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getDef(word));
					}
				}catch(IOException e){}
			}
		});
		
		buttons[3].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(ans==3){
					back.playSound("src/correct.wav");
					count++; total++;
					correctLbl.setText("Correct! " + count + "/" + total);
				}else{
					back.playSound("src/incorrect.wav");
					total++;
					correctLbl.setText("Incorrect! " + count + "/" + total);
				}
				newWord();
				guessLbl.setText("                                                                             Word(s): " + word +  "                                                                            ");
				ans = (int) (Math.random()*4);
				try{
					if(ans==0){
						buttons[0].setText(back.getDef(word));
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getDef(word));
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getRandomDef());
					}
					else if(ans==1){
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getDef(word));
						buttons[3].setText(back.getRandomDef());
					}
					else{
						buttons[0].setText(back.getRandomDef());
						buttons[1].setText(back.getRandomDef());
						buttons[2].setText(back.getRandomDef());
						buttons[3].setText(back.getDef(word));
					}
				}catch(IOException e){}
			}
		});
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void newWord(){
		word = back.randomWord();
	}
	
	public static void randomizeSpots() throws IOException{
		ans = (int) (Math.random()*4);
		
		if(ans==0){
			buttons[0] = new JButton(back.getDef(word));
			buttons[1] = new JButton(back.getRandomDef());
			buttons[2] = new JButton(back.getRandomDef());
			buttons[3] = new JButton(back.getRandomDef());
		}
		else if(ans==1){
			buttons[0] = new JButton(back.getRandomDef());
			buttons[1] = new JButton(back.getDef(word));
			buttons[2] = new JButton(back.getRandomDef());
			buttons[3] = new JButton(back.getRandomDef());
		}
		else if(ans==1){
			buttons[0] = new JButton(back.getRandomDef());
			buttons[1] = new JButton(back.getRandomDef());
			buttons[2] = new JButton(back.getDef(word));
			buttons[3] = new JButton(back.getRandomDef());
		}
		else{
			buttons[0] = new JButton(back.getRandomDef());
			buttons[1] = new JButton(back.getRandomDef());
			buttons[2] = new JButton(back.getRandomDef());
			buttons[3] = new JButton(back.getDef(word));
		}
	}
	
	public static void main( String[] args ) throws IOException
	{
		File f = new File("list2.txt");
		
		if(!f.exists()){
			back.init();
		}else{
			back.init2();
		}
		
		newWord();
		randomizeSpots();
		
		gui frame  = new gui( "Urban Dicts" );
	    
   		frame.setSize( 750, 500 );
    	frame.setVisible(true);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
