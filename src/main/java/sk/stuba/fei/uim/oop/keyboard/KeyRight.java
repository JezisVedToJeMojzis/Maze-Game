package sk.stuba.fei.uim.oop.keyboard;

import sk.stuba.fei.uim.oop.maze.GenerateMaze;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyRight extends Canvas implements KeyListener {
    private int[][]helpingMaze;
    int wins;
    public KeyRight(int[][]maze,int x){
        helpingMaze=maze;
        wins = x;
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            GenerateMaze maze = new GenerateMaze();
            InitilizationMaze infoOfMaze = new InitilizationMaze();
            int breaker = 0;
            for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
                for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                    if (helpingMaze[i][j] == 2) { //Player
                        if (helpingMaze[i+1][j] == 0) {
                            helpingMaze[i][j] = 0;
                            helpingMaze[i+1][j] = 2;
                            breaker=1;
                            break;
                        }
                        if (helpingMaze[i+1][j] == 3){ //Finish
                            helpingMaze[i][j] = 0;
                            helpingMaze[i+1][j] = 2;

                            maze.setEmptyMaze();
                            maze.setNewMaze();
                            int[][]help = maze.getMaze();
                            for (int k = 0;k<infoOfMaze.getWidthOfMaze();k++){ //Repaint whole maze
                                for(int l =0;l<infoOfMaze.getHeightOfMaze();l++){
                                    helpingMaze[k][l]=help[k][l];
                                }
                            }
                            wins++;
                            break;
                        }
                    }
                }
                if(breaker==1){ //Need to break for i loop so it doesnt go all the way to the right
                    break;
                }
            }
        }
    }
}
