
package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle extends Rectangle {
    
    double yCor, xCor, yVel;
    private boolean moving = true, upAccel = false, downAccel = false;
    private Ball ball;

    public AIPaddle(Ball ball) {
        upAccel = false; downAccel = false;
        this.ball = ball;
        yCor = 200;
        xCor = GameCanvas.WIDTH - 20;
        yVel = -2;
    }
    
    public void update(Ball ball) {
        setyCor(ball.getY() - 50);
    }
        
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)xCor, (int)yCor, 20, 100);
    }

    public int getyCor() {
        return (int)yCor;
    }

    public void setyCor(double yCor) {
        this.yCor = yCor;
    }
    
    public void setUpAccel(boolean input) {
        upAccel = input;
    }

    public void setDownAccel(boolean input) {
        downAccel = input;
    } 
}
