import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class AlienP extends Projectiles {

	public AlienP() {
		super();
	}
	public AlienP(int x, int y) {
		super(x,y,50,50,new ImageIcon("AlienP.png"));
	}
	public void move() { 
		setY(getY()-getdy());
		
	}
	
	public boolean Collision (Playership c) {
		Rectangle player= new Rectangle (getX(), getY(), getW(), getH());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getW(), c.getH());
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
		
	}
}
