
package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GameCanvas extends JPanel implements Runnable, KeyListener {
    
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static Dimension size = new Dimension(WIDTH, HEIGHT);
    public boolean isRunning = false;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    private Play play;

    public GameCanvas() {
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

        start();
    }
   
    public void start() {
        addKeyListener(this);
        setFocusable(true);
        isRunning = true;
        new Thread(this, "Game Loop").start();
    }

    public void stop() {
        isRunning = false;
        System.exit(0);
    }

    @Override
    public void run() {
        
        long start;
        long elapsed;
        long wait;
        
        play = new Play();
        
        while(isRunning) {
            start = System.nanoTime();
            
            tick();
            repaint();
            
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed;
            if(wait < 0) wait = 5;
            
            // sleeps amount of time to keep FPS consistent
            try {
                Thread.sleep(wait);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public void tick() {
        play.update();
    }
    
    public void paint(Graphics g) {
        play.draw(g);
    }
    
    public void keyPressed(KeyEvent e) {
       int key = e.getKeyCode();
       play.keyPressed(key);
    }

    
    public void keyReleased(KeyEvent e) {
       int key = e.getKeyCode();
       play.keyReleased(key);
    }
    
    public void keyTyped(KeyEvent arg0) {
        
    }
 
}
