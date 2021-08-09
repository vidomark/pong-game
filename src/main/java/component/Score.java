package component;

import gui.GamePanel;

import java.awt.*;

public class Score {

    private int player1;
    private int player2;

    public Score(int player1, int player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setId1(int player1) {this.player1 += player1;}

    public void setId2(int player2) {this.player2 += player2;}

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Consolas",Font.PLAIN,60));
        graphics.drawLine(GamePanel.GAME_WIDTH / 2, 0, GamePanel.GAME_WIDTH / 2, GamePanel.GAME_HEIGHT);

        graphics.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GamePanel.GAME_WIDTH/2)-85, 50);
        graphics.drawString(String.valueOf(player2 / 10)+String.valueOf(player2 %10), (GamePanel.GAME_WIDTH/2)+20, 50);
    }

}