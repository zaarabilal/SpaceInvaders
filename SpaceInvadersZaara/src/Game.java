import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key, count; 
	private ArrayList <Alienship> alienlist;
	private Playership ps;
	//private ImageIcon pship;
	private ArrayList <PlayerP> pMissiles;
	private ArrayList <AlienP> aMissiles;
	private PlayerP pp;
	private AlienP ap;
	private Alienship as;
private int score;
private ImageIcon banner;
	private int lives;
	private Player p;
	private boolean play;
	private boolean play2;


	
	

	
	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		count=0;
		lives=3;
		alienlist= setAliens();
	ps= new Playership(200,465);
	//pship= new ImageIcon(ps.getPic());
	pMissiles=new ArrayList <PlayerP> ();
	aMissiles=new ArrayList <AlienP> ();
	pp= new PlayerP(getX(), getY());
	ap= new AlienP(getX(), getY());
	as= new Alienship();
	banner= new ImageIcon ("Banner.png");
	p=new Player();
	score=0;
	play=false;
	play2=false;
	
	

	}
	
	public ArrayList <Alienship> setAliens(){
		ArrayList <Alienship> temp= new ArrayList<Alienship>();

		
		int x=40;
		int y=10;
		int offset= -10;
		for(int i=0; i<4; i++) {
			for (int j=0; j<10; j++) {
				temp.add(new Alienship (i+x, y+j));
			
		
		x+=70;

		}
			
			y+=50;
			x=40;
		}
		System.out.println(temp);
		return temp;
	}

	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		//for(AlienP a: aMissiles) {
			//int a= Math.random()*(195-0+1)+0;
		//int a= alienlist(Math.random()*(-0+1))+0);
			//for(int i=0; i<aMissiles.size(); i++) {
		
			//g2d.setFont(");
		
		//g2d.drawString("KEY"+key, 100, 400);

			if(key==90) {
				if (count%20==0) {
					
					pMissiles.add(new PlayerP(ps.getX(),pp.getX()));
					pp.setdy(3);
					
			}
			}
		
		g2d.drawImage(ps.getPic().getImage(), ps.getX(),ps.getY(), 100,100, this);
	
	
		ps.move();
		check();
		reverse();
		 count++;
		 
		 Color color= new Color(11,117,112);
			g2d.setColor(color);
			g2d.setFont(new Font("Calligraphy",Font.BOLD, 30));
			g2d.drawString("LIVES:"+lives, 100, 50);
			g2d.drawString("SCORE:"+score, 250, 50);
		
		 AlienShoot();
		 System.out.println(count);
		 for(AlienP b: aMissiles) {
				g2d.drawImage(ap.getPic().getImage(), b.getX(),b.getY(),b.getW(),b.getH(), this);
				b.move();
				
				}

				for(PlayerP a: pMissiles) {
					a.move();
					g2d.drawImage(pp.getPic().getImage(), a.getX(), a.getY(), a.getW(), a.getH(), this);
					
				}
				
		for(Alienship a: alienlist) {
			g2d.drawImage(a.getPic().getImage(), a.getX(), a.getY(), a.getW(), a.getH(), this);
			a.move();
			if(a.getY()>=460) {
				Color losecolor= new Color (196,88,124);
				g2d.setColor(losecolor);
				g2d.fillRect(0, 0, 800, 600);
				g2d.setColor(Color.WHITE);
				g2d.setFont(new Font("Calligraphy",Font.BOLD, 70));
				g2d.drawString("YOU LOSE",200,200);
				g2d.drawString("SCORE: "+score+"/1000",70,400);
				g2d.setFont(new Font("Calligraphy",Font.BOLD, 30));
				g2d.drawString("RESTART TO PLAY AGAIN",200,500);
				count=0;
				
			}
			
			
		}
		
		
			
				for(int m=0; m<pMissiles.size(); m++) {
					
					for(int i=0; i<alienlist.size(); i++) {
						if(!pMissiles.isEmpty()) {
						if (pMissiles.get(m).Collision(alienlist.get(i))){
							alienlist.remove(i);
							
							pMissiles.remove(m);
							score+=25;
							play=true;
						}
						}
					}
				}
						
					for(int l=0; l<aMissiles.size(); l++) {
					
					if(!aMissiles.isEmpty()) {
					if (aMissiles.get(l).Collision(ps)){
						lives--;
						
						aMissiles.remove(l);
						play2=true;
						}
						}
					}
					
					
					
					g2d.setFont(new Font("Calligraphy",Font.BOLD, 60));
						if (alienlist.isEmpty()) {
				Color wincolor= new Color(105,133,224);
				g2d.setColor(wincolor);
							g2d.fillRect(0,0,800,600);
							g2d.setColor(Color.WHITE);
							g2d.drawImage(banner.getImage(),20,100,700,1200,this);
							g2d.drawString("YOU WIN!",225,200);
							g2d.setFont(new Font("Calligraphy",Font.BOLD, 30));
							g2d.drawString("RESTART TO PLAY AGAIN",200,500);
					        count=0;
					}
					if(lives==0 ) {
						//for(int l=aMissiles.size();;) {
						
						Color losecolor= new Color (196,88,124);
						g2d.setColor(losecolor);
						g2d.fillRect(0, 0, 800, 600);
						g2d.setColor(Color.WHITE);
						g2d.setFont(new Font("Calligraphy",Font.BOLD, 70));
						g2d.drawString("YOU LOSE",200,200);
						g2d.drawString("SCORE: "+score+"/1000",70,400);
						g2d.setFont(new Font("Calligraphy",Font.BOLD, 30));
						g2d.drawString("RESTART TO PLAY AGAIN",200,500);
						count=0;
						
						}
						
					
		if (play) {
			p.playmusic("psa.wav");
			play=false;
		}
		if (play2) {
			p.playmusic("explosion.wav");
			play2=false;
		}
		
	
					
							twoDgraph.drawImage(back, null, 0, 0);
					}
	
						
			


	//public int getsize() {
		//return alienlist.size();
	//}
	public void AlienShoot() {
		int als=alienlist.size();
		int b= (int)((Math.random()*(als-1+0+1))+0);
				if (count%200==0) {
					
				aMissiles.add(new AlienP(alienlist.get(b).getX(),alienlist.get(b).getY()));
				System.out.println("passed");
	}
}
	
	public boolean check() {
		for (Alienship a: alienlist) {
			if(a.getX()+a.getW()>=800 || a.getX()<=0) 
				
				return true;
			
				}
			 {
				return false;
				
			}
			
	}
	public void reverse() {

		for (Alienship a: alienlist){
			if (check()==true) {
				a.setdx(a.getdx()*-1);
				//a.moved(5);
				a.setdy(10);
				a.moved();
				
		}
		}
		}

		/*public void moved() {
			for (Alienship a: alienlist) {
				if (check()==true)
				//a.setdy(a.getdy()+10);
				//a.moved();
			}
		}*/
		

	
	/*for(int i=0; i<alienlist.size(); i++) {
		as=alienlist.get(i);
		if(pp.collisionb(as)){
			alienlist.remove(i);
			i--;
		}
	}*/


	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);

		 if(key==39) {
				ps.setdx(3);
			}
			if(key==37) {
				ps.setdx(-3);
			}
		//code for missile
			if (key== 32) {
		pMissiles.add (new PlayerP (ps.getX(),pp.getX()));
		pp.setdy(3);
	
	System.out.println("passed");
		
			}
		
		if(key==65) {
		ps.setdx(-6);
		}
		if(key==68) {
			ps.setdx(6);
		}
		
		if (key==76) {
			lives=5;
			p.playmusic("collision.wav");
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==39||e.getKeyCode()==37) {
			ps.setdx(0);
				}
		if(e.getKeyCode()==65||e.getKeyCode()==68) {
			ps.setdx(0);
		}
		
		
		
		
		
		
	}
	
	
	

	
}



	
	

	