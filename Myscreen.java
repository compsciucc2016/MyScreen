import javax.swing.JFrame;

public class Myscreen extends JFrame {

	public Myscreen() {
		this.setSize(1200,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("The Chosen One");
		this.setFocusable(true);
	}

	public static void main(String[] args) {
		Myscreen screen = new Myscreen();
		Mycanvas canvas = new Mycanvas();
		screen.getContentPane().add(canvas);
	}

}