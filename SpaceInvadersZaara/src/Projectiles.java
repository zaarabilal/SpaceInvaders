

	import javax.swing.ImageIcon;

	public class Projectiles {
		private int  x, y, dx, dy, width, height;
		private ImageIcon image;
		private boolean reverse;
		private boolean reversey;
		private boolean moveup;
		private boolean moveright;
		
		public Projectiles() {
			
			x=0;
			y=0;
			dx=0;
			dy=0;
			width=0;
			height=0;
			image= new ImageIcon();
			reverse=false;
			reversey=false;
			moveup=false;
			moveright=false;
		}
	public Projectiles (int xv, int yv, int w, int h, ImageIcon i) {
		
		x=xv;
		y=yv;
		dx=0;
		dy=-2;
		width=w;
		height=h;
		image= i;
		reverse=false;
		reversey=false;
		moveup=false;
		moveright=false;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
	public void setdx(int dx1) {
		dx=dx1;
	}
	public int getdy() {
		return dy;
	}
	public int getdx() {
		return dx;
	}
	public void setdy(int dy1) {
		dy=dy1;
	}
	public void setX(int xv1) {
		x=xv1;
	}
	
	public void setY(int yv1) {
		y=yv1;
	}
	public ImageIcon getPic() {
		return image;
	}
	public void move() {
		y-=dy;
		//y+=dy;
		//x+=dx;
	}
	
	/*public void minusX() {
		x--;
	}
	public void minusY() {
		y--;
	}
	public void addX() {
		x++;
	}
	public void addY() {
		y++;
	}
	public boolean getreverse() {
		return reverse;
	}
	public boolean getreversey() {
		return reversey;
	}
	
	public void setMoveup() {
		reverse=!reverse;
	}
	public void setMovedown() {
		reversey=!reversey;
	}*/
	/*if(moveup) {
		y-=dy;
	}
	else {
		y+=dy;
	}
	if(moveright) {
		x+=dx;
	}
	else {
		x-=dx;
	}*/
	

	
	}


