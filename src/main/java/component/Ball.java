package component;

import gui.GamePanel;

import java.awt.*;
import java.util.Random;

public class Ball  extends Rectangle {

    private int speed = 6;
    private int yVelocity = 8;
    private int xVelocity = -8;
    Random random;

    public Ball(int x, int y, int BALL_HEIGHT, int BALL_WIDTH) {
        super(x, y, BALL_WIDTH, BALL_HEIGHT);
        random = new Random();

        if (random.nextInt(2) == 1) {
            setXDirection(speed);
        } else {
            setXDirection(-speed);
        }
    }

    public void paddleCollision(Paddle paddle) {
        if (this.intersects(paddle)) {
            if (paddle.getId() == 1) {setXDirection(speed);}
            else {setXDirection(-speed);}
        }
    }

    public void borderCollision() {
        if (y <= 0) {
            setYDirection(speed);
        } else if (y >= GamePanel.GAME_HEIGHT - height) {
            setYDirection(-speed);
        }
    }

    public boolean isGoal(Score score) {
        if (x <= 0) {
            score.setId2(1);
            return true;
        } else if (x >= GamePanel.GAME_WIDTH - width) {
            score.setId1(1);
            return true;
        }
        return false;
    }

    public void setYDirection(int direction) {
        yVelocity = direction;
    }

    public void setXDirection(int direction) {
        xVelocity = direction;
    }

    public void move () {
        y += yVelocity;
        x += xVelocity;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillOval(x, y, height, width);
    }

}
