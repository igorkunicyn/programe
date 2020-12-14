package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static lesson_8.Logic.*;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;
    static final int SCALE = 30;
    static final char X = 'X';
    static final char O = 'O';
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.gameFinished) {
                    Logic.humanTurn(cellX, cellY);
                    gameFinished = false;
                }
                repaint();
            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(checkWinLines(map[i][j],DOTS_TO_WIN)&&map[i][j]!=DOT_EMPTY){
//                    draw(g);
                    drawRect(g);
                }
            }
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }
            }
        }
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(10));
//        g.
        g.setColor(Color.BLUE);
        g.drawLine(cellX * cellWidth+cellWidth/4, cellY * cellHeight+cellHeight/4,
                (cellX + 1) * cellWidth-cellWidth/4, (cellY + 1) * cellHeight-cellHeight/4);
        g.drawLine((cellX) * cellWidth+cellWidth-cellWidth/4, (cellY) * cellHeight+cellHeight/4,
                (cellX) * cellWidth+cellWidth/4, (cellY) * cellHeight+cellHeight-cellHeight/4);
    }
    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(10));
        g.setColor(Color.RED);
        g.drawOval(cellX * cellWidth+cellWidth/4, cellY * cellHeight+cellHeight/4,
                cellWidth-cellWidth/2, cellHeight-cellHeight/2);
    }
//    Рисует победную линию
//    private void draw(Graphics g) {
//        ((Graphics2D) g).setStroke(new BasicStroke(6));
//        g.setColor(Color.YELLOW);
//        g.drawLine(START_X*cellWidth+cellWidth/2 ,START_Y*cellHeight+cellHeight/2 ,
//                END_X*cellWidth+cellWidth/2, END_Y*cellHeight+cellHeight/2);
//    }
    private void drawRect(Graphics g) {
        ((Graphics2D) g).setStroke(new BasicStroke(cellWidth/4));
        g.setColor(Color.YELLOW);
        for (int i = 0; i <DOTS_TO_WIN; i++) {
            g.drawRect((START_X+VX*i) * cellWidth+cellWidth/4, (START_Y+VY*i) * cellHeight+cellHeight/4,
                    cellWidth/2, cellHeight/2);
            g.fillRect((START_X+VX*i) * cellWidth+cellWidth/4, (START_Y+VY*i) * cellHeight+cellHeight/4,
                    cellWidth/2, cellHeight/2);
        }
    }



}
