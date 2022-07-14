import javax.swing.ImageIcon;

public class Playership extends Spaceship {
	

	public Playership() {
		super();
	}
	public Playership(int x, int y) {
		super(x,y,50,50,new ImageIcon("playership.png"));
	}
	public void move() { 
		setX(getX()+getdx());
		
	}
}
