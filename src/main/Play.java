package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Play {

    public Paddle p1;
    public AIPaddle pAI;
    public Ball ball;
    Graphics gfx;
    public static int leftScore, rightScore;
   
    public Play() {
        init();
    }
   
    public void init() {
        p1 = new Paddle(new Rectangle(0, GameCanvas.HEIGHT / 2, 20, 100), KeyEvent.VK_W, KeyEvent.VK_S);
        pAI = new AIPaddle(ball);
        ball = new Ball(10);
        leftScore = 0;
        rightScore = 0;
    }
   
    public void paint(Graphics g) {
         gfx.setColor(Color.black);
         gfx.fillRect(0, 0, GameCanvas.WIDTH, GameCanvas.HEIGHT);
         if  (leftScore == 6 || rightScore == 6) {
             gfx.setColor(Color.red);
             gfx.drawString("Game Over", GameCanvas.WIDTH, GameCanvas.HEIGHT);
         } else {
                 p1.draw(g);
                 ball.draw(g);
                 pAI.draw(g);
         }
    }
   
    public void update() {
        p1.update();
        pAI.update(ball);
        ball.update();
        ball.paddleCollision(p1, pAI);

        if(leftScore == 4 || rightScore == 4) {
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }
   
    // Draws everything
    public void draw(Graphics g) {
       g.setColor(Color.black);
       g.fillRect(0, 0, GameCanvas.WIDTH, GameCanvas.HEIGHT);
       p1.draw(g);
       pAI.draw(g);
       ball.draw(g);

       g.setFont(new Font("Arial", Font.PLAIN, 100));
       g.drawString(Integer.toString(leftScore), GameCanvas.WIDTH / 2 - 120, 100);
       g.drawString(Integer.toString(rightScore), GameCanvas.WIDTH / 2 + 80, 100);

       // Drawing Center Dashed line
       for(int i = 0; i < 16; i++) {
           g.fillRect(GameCanvas.WIDTH / 2 - 10, 10 + i * 20 + i * 30, 20, 20);
        }
    }
  
    public void keyPressed(int k) {
      p1.keyPressed(k); 
    }

    public void keyReleased(int k) {
        p1.keyReleased(k); 
    }
  
    public void keyTyped(KeyEvent e) {

    } 
}