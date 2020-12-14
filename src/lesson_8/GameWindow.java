package lesson_8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 400;
    static final int WINDOW_Y = 100;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;
    private String rezultgame;
    static final int GAME_REZULT_WINDOW_X = 500;
    static final int GAME_REZULT_WINDOW_Y = 200;
    static final int GAME_REZULT_WINDOW_WIDTH = 300;
    static final int GAME_REZULT_WINDOW_HEIGHT = 300;
    private SettingWindow settingWindow;
    private BattleMap battleMap;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        settingWindow = new SettingWindow(this);
        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnStartNewGame = new JButton("Start New Game");
        panel.add(btnStartNewGame);
        JButton btnExit = new JButton("Exit");
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        btnStartNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }
    public GameWindow(String s) {
        rezultgame=s;
        setBounds(GAME_REZULT_WINDOW_X, GAME_REZULT_WINDOW_Y, GAME_REZULT_WINDOW_WIDTH, GAME_REZULT_WINDOW_HEIGHT);
        setTitle("РЕЗУЛЬТАТ ИГРЫ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton btnGameRezult = new JButton(rezultgame);
        add(btnGameRezult, BorderLayout.CENTER);

        btnGameRezult.addActionListener(e -> {
            this.setVisible(false);
        });
        setVisible(true);
    }


    public void startNewGame(int mode, int fieldSize, int winningLength){
        battleMap.startNewGame(mode, fieldSize, winningLength);
    }
}
