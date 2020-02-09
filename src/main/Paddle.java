
package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle extends Rectangle {
    
    private boolean up = false, down = false;
    private boolean upAccel, downAccel;
    private int upKey, downKey;
    private int moveSpeed = 4;   
    double yCor;
    
    public Paddle(Rectangle r, int upKey, int downKey) {
        setBounds(r);
        upAccel = false; downAccel = false;
        y -= (height / 2);
        this.upKey = upKey;
        this.downKey = downKey;
    }
    
    public void update() {
        if(y <= 0) up = false;                            
        if(y + height >= GameCanvas.HEIGHT) down = false;
        if(up) y -= moveSpeed;  
        if(down) y += moveSpeed; 
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    
    public void keyPressed(int k) {
        if(k == upKey) up = true;
        if(k == downKey) down = true;
    }
    
    public void keyReleased(int k) {
        if(k == upKey) up = false;
        if(k == downKey) down = false;
    }
    
    public void setUpAccel(boolean upAccel) {
        this.upAccel = upAccel;
    }

    public void setDownAccel(boolean downAccel) {
        this.downAccel = downAccel;
    } 
    
}
