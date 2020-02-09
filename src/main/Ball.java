
package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    
    private int x, y, r;
    private double xVel, yVel;
    
    public Ball(int r) {
        this.r = r;
        x = GameCanvas.WIDTH / 2;
        y = GameCanvas.HEIGHT / 2;
        xVel = 3.0;
        yVel = 3.0;
    }
    
    public void update() {
        if(getY() - getR() <= 0 || getY() + getR() >= GameCanvas.HEIGHT) yVel *= -1;
        
        if(getX() + getR() >= GameCanvas.WIDTH) {
            setX(GameCanvas.WIDTH / 2 - getR());
            setY(GameCanvas.HEIGHT / 2 - getR());
            Play.leftScore += 1;
            xVel *= -1;
        }
        
        if(getX() - getR() <= 0) {
            setX(GameCanvas.WIDTH / 2 - getR());
            setY(GameCanvas.HEIGHT / 2 - getR());
            Play.rightScore += 1;
            xVel *= -1;
        }
        
        setX(getX() + (int)xVel);
        setY(getY() + (int)yVel);
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int)x - r, (int)y - r, r * 2, r * 2);
    }
    
    // Paddle Collision for BOTH paddles
    public void paddleCollision(Paddle pUser, AIPaddle pAI) {
        if(x <= 20) {
            if(y >= pUser.getY() && y <= pUser.getY() + 100) {
                xVel = -xVel;
            }
        }
        else if(x >= 980) {
            if(y >= pAI.getyCor() && y <= pAI.getyCor() + 100) {
                xVel = -xVel;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public double getxVel() {
        return (int)xVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public double getyVel() {
        return (int)yVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
}
