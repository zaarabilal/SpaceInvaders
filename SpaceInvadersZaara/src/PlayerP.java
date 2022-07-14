

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PlayerP extends Projectiles {

	public PlayerP() {
		super();
	}
	public PlayerP(int x, int y) {
		super(x,400,60,60,new ImageIcon("PlayerP.png"));
	}
	public void move() { 
		setY(getY()+getdy());
		
	}
	/*public boolean collisionb(Alienship a) {
		
		if (getX()<=a.getX()+a.getW()&&getY()<=a.getY()+a.getH()&&getX()+getW()>=a.getX()) {
			
			System.out.println("collision");
	      return true;
		}
		return false;
	}*/
	
	public boolean Collision (Alienship c) {
		Rectangle player= new Rectangle (getX(), getY(), getW(), getH());
		Rectangle enemy= new Rectangle (c.getX(), c.getY(), c.getW(), c.getH());
	
		if(player.intersects(enemy)) {
			return true;
			
			
		}
		return false;
		
	}
		
}
