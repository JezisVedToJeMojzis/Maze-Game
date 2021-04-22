package sk.stuba.fei.uim.oop.keyboard;

import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


public class KeyLeft implements KeyListener {
    private int[][]helpingMaze;
    public KeyLeft(int[][]maze){
        helpingMaze=maze;
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            InitilizationMaze infoOfMaze = new InitilizationMaze();
            for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
                for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                    if (helpingMaze[i][j] == 2) { //Player
                        if (helpingMaze[i-1][j] == 0) {
                            helpingMaze[i][j] = 0;
                            helpingMaze[i-1][j] = 2;
                            break;
                        }
                    } //Dont need to take care of finish because u can never reach it by going left
                }
            }
        }
    }
}

