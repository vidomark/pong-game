package component;

import gui.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {

    private final int id;
    private int yVelocity = 0;
    private int speed = 5;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public int getId() {return id;}

    public void borderCollision() {
        if (y <= 0) {
            y = 0;
        } else if (y >= GamePanel.GAME_HEIGHT - this.height) {
            y = GamePanel.GAME_HEIGHT - this.height;
        }
    }

    public void keyPressed(KeyEvent event) {
        switch (id) {
            case 1:
                if (event.getKeyCode() == KeyEvent.VK_W) {setYDirection(-speed);}
                else if (event.getKeyCode()==KeyEvent.VK_S) {setYDirection(speed);}
                break;

            case 2:
                if (event.getKeyCode() == KeyEvent.VK_UP) {setYDirection(-speed);}
                else if (event.getKeyCode()==KeyEvent.VK_DOWN) {setYDirection(speed);}
                break;
        }
    }

    public void keyReleased(KeyEvent event) {
        switch (id) {
            case 1:
                if (event.getKeyCode()==KeyEvent.VK_W) {setYDirection(0);}
                else if (event.getKeyCode()==KeyEvent.VK_S) {setYDirection(0);}
                break;

            case 2:
                if (event.getKeyCode() == KeyEvent.VK_UP) {setYDirection(0);}
                else if (event.getKeyCode()==KeyEvent.VK_DOWN) {setYDirection(0);}
                break;
        }
    }

    public void setYDirection(int direction) {
        yVelocity = direction;
    }

    public void move() {
        y += yVelocity;
    }

    public void draw(Graphics graphics) {
        if (id == 1) {
            graphics.setColor(Color.blue);
        } else {
            graphics.setColor(Color.RED);
        }
        graphics.fillRect(x, y, width, height);
    }

}