package Scraping;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gui extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	public static String[] words;
	public static Scanner sc;
	
	// Create objects
	
	public gui( String title )
	{
		super( title );
		
		// Set layout
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
		
	}
	
	public static void main( String[] args ) throws IOException
	{
		File f = new File("list2.txt");
		
		if(!f.exists()){
			back.init();
		}else{
			back.init2();
		}
		
		gui frame  = new gui( "Urban Dicts" );
	    
   		frame.setSize( 500, 175 );
    	frame.setVisible(true);  
	}
}
