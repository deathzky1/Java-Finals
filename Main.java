import java.awt.Window;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

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
	
	
	public static class Music{
		private static Clip clip;
		private static AudioInputStream stream;
		private static Thread t;

		private static void loadMusic() {
			if(clip != null) return;
			try {
				AudioFormat format;
				DataLine.Info info;
				
				stream = AudioSystem.getAudioInputStream(Window.class.getResource("/music/bgm.wav"));
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void playMusic(boolean loop) {
			loadMusic();
			if(clip == null) return;
			if(t != null && t.isAlive()) try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
			else clip.start();
		}
		
		public static void stopMusic() {
			t = new Thread(new Runnable() {
				public void run() {
					clip.stop();
					clip.setMicrosecondPosition(0);
				}
			});
			t.start();
		}
	}

	public static void main (String[] args){
		Main frame = new Main();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.comp.start();
		frame.
		
		
	}
}