import javax.swing.ImageIcon;

public class Spaceship {
	private int lives, x, y, dx, dy, dx2,width, height;
	private ImageIcon image;
	private boolean reverse;
	public Spaceship() {
		lives=0;
		x=0;
		y=0;
		dx=0;
		dy=0;
		dx2=0;
		width=0;
		height=0;
		image= new ImageIcon();
		reverse=false;
	}
public Spaceship (int xv, int yv, int w, int h, ImageIcon i) {
	lives=0;
	x=xv;
	y=yv;
	dx=0;
	dy=0;
	dx2=0;
	width=w;
	height=h;
	image= i;
	reverse=false;
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
public int getdx() {
	return dx;
}
public int getdy() {
	return dy;
}
public void setdx(int dx1) {
	dx=dx1;
}
public void setdy(int dy1) {
	dy=dy1;
}
public void setdx2(int dxvalue) {
	dx2=dxvalue;
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
	x+=dx;
	x-=dx2;
	
	//y+=dy;
	
}



	

}
