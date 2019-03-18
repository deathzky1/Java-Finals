import javax.swing.JFrame;

public class Main extends JFrame{

	private final static int WIDTH = 900;
	public final static int HEIGHT = 700;

	private final MainComp comp;

	public Main(){
	   setResizable(false);
	   comp = new MainComp();
	   setContentPane(comp);
	}
	public static void main (String[] args){
		Main frame = new Main();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.comp.start();
		
	}
}