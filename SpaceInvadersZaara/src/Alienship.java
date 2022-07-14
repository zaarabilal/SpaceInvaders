import javax.swing.ImageIcon;

public class Alienship extends Spaceship {

	public Alienship() {
		super();
		
	}
	public Alienship(int x, int y) {
		super(x,y,45,45,new ImageIcon("alien.png"));
		setdx();
		
		
	}
	public void setdx() {
		super.setdx(1);
	}
	
		
	
	public void move() { 
		setX(getX()+getdx());
	
	}
	/*public void moved(int d) {
		setY(getY()+ d);
	}*/
	public void moved() {
		setY(getY()+getdy());
	}
	
	//public void setdx(int dx1) {
		//;
	//}
}
//put player missile in arraylist. 
