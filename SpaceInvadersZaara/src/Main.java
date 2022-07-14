import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
	
	private static final int WIDTH =800;
	private static final int HEIGHT=600;
	
	
	public Main(){
		super("Space Invaders- Zaara Bilal");
		setSize(WIDTH,HEIGHT); 
		Game play = new Game(); 
		
		((Component)play).setFocusable(true);
		Color background= new Color (100,237,180);
		setBackground(background);
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		
		
	
	public static void main(String[] args) {
		
		Main run = new Main(); 
		
	}

	
	
	
}