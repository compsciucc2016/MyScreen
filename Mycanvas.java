import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Mycanvas extends Canvas implements KeyListener, MouseListener {
	Image img = Toolkit.getDefaultToolkit().getImage("snake.png");
	int posx = 10;
	int posy = 10;
	int speed = 10;
	boolean soundeffect = true;
	Rectangle rect = new Rectangle(200,300,100,100);

	public Mycanvas() {
		this.setSize(1200,800);
		this.addKeyListener(this);
		this.addMouseListener(this);
		//this.setFocusable(true);
		playIt("Elevator-music.wav");
	}

	public void paint(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillOval(99,100,399,99);

		g.drawImage(img,posx,posy,200,150,this);
		g.fillRect((int)rect.getX(),(int)rect.getY(),(int)rect.getWidth(),(int)rect.getHeight());

	}

	public void mouseClicked(MouseEvent e) {
		//System.out.println("Click");
	}
	public void mouseEntered(MouseEvent e) {
		//System.out.println(e);
	}
	public void mouseExited(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {

		if (posx > this.getWidth() - 202) {
			posx = posx - speed;
		}

		if (posy > this.getHeight() - 161) {
			posy = posy - speed;
		}

		if (posx < 0) {
			posx = posx + speed;
		}

		if (posy < 0) {
			posy = posy + speed;
		}

		if (rect.contains(posx,posy)) {
			posx = 10;
			posy = 10;
		} else {
			posx = e.getX();
			posy = e.getY();
		}
		this.repaint();
	}
	public void mouseReleased(MouseEvent e) {
		//System.out.print(e);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 39) {
			posx = posx + speed;
			//playIt("verynice.wav");
			this.repaint();
		}
		if (e.getKeyCode() == 37) {
			posx = posx - speed;
			this.repaint();
			//playIt("verynice.wav");
		}
		if (e.getKeyCode() == 38) {
			posy = posy - speed;
			this.repaint();
			//playIt("verynice.wav");
		}
		if (e.getKeyCode() == 40) {
			posy = posy + speed;
			this.repaint();
			//playIt("verynice.wav");
		}
		if (e.getKeyCode() == 32) {
			img = Toolkit.getDefaultToolkit().getImage("fish.png");
			this.repaint();
			if(soundeffect == true) {
				playIt("verynice.wav");
				soundeffect = false;
			}
		}
		if (e.getKeyCode() == 27) {
			System.exit(0);
		}
		if (posx > this.getWidth() - 202) {
			posx = posx - speed;
		}
		if (posy > this.getHeight() - 161) {
			posy = posy - speed;
		}
		if (posx < 0) {
			posx = posx + speed;
		}
		if (posy < 0) {
			posy = posy + speed;
		}
		if (rect.contains(posx,posy)) {
			posx = 10;
			posy = 10;
		}
		this.repaint();

		}
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println(e);
		if (e.getKeyCode() == 32) {
			img = Toolkit.getDefaultToolkit().getImage("snake.jpeg");
			this.repaint();
			soundeffect = true;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println(e);
	}
	public static void playIt(String MySong) {
		try {
			InputStream in = new FileInputStream(MySong);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println("y u do dis");
		}
	}
}
