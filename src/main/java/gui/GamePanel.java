package gui;

import component.Ball;
import component.Paddle;
import component.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    public static final int GAME_WIDTH = 1500;
    public static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
    protected static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    int PADDLE_HEIGHT = 100;
    int PADDLE_WIDTH = 20;
    int BALL_RADIUS = 25;
    int id1 = 1;
    int id2 = 2;
    int player1 = 0;
    int player2 = 0;
    Thread gameThread;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    Random random;

    GamePanel() {
        createPaddles();
        createBall();
        score = new Score(player1, player2);

        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setBackground(Color.BLACK);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void createPaddles() {
        paddle1 = new Paddle(0, GAME_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, id1);
        paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH,GAME_HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, id2);
    }

    public void createBall() {
        random = new Random();
        ball = new Ball(GAME_WIDTH / 2 - BALL_RADIUS / 2, random.nextInt(GAME_HEIGHT / 2) - BALL_RADIUS / 2, BALL_RADIUS, BALL_RADIUS);
    }

    public void handleCollision() {
        paddle1.borderCollision();
        paddle2.borderCollision();

        ball.borderCollision();
        ball.paddleCollision(paddle1);
        ball.paddleCollision(paddle2);

        if (ball.isGoal(score)) {
            createPaddles();
            createBall();
        }
    }

    public void paint(Graphics g) {
        draw(g);
    }

    public void draw(Graphics graphics) {
        paddle1.draw(graphics);
        paddle2.draw(graphics);
        ball.draw(graphics);
        score.draw(graphics);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    @Override
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >=1) {
                move();
                handleCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            paddle1.keyPressed(event);
            paddle2.keyPressed(event);
        }

        public void keyReleased(KeyEvent event) {
            paddle1.keyReleased(event);
            paddle2.keyReleased(event);
        }
    }

}