package sk.stuba.fei.uim.oop.keyboard;

import sk.stuba.fei.uim.oop.maze.GenerateMaze;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


public class KeyDown implements KeyListener {
    private int[][]helpingMaze;
    int x;
    public KeyDown(int[][]maze,int wins){
        helpingMaze=maze;
        x=wins;
        addKeyListener(this);
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            GenerateMaze maze = new GenerateMaze();
            InitilizationMaze infoOfMaze = new InitilizationMaze();
            for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
                for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                    if (helpingMaze[i][j]==2) { //Player
                        if(helpingMaze[i][j+1]==0) { //If rect on his right is road
                            helpingMaze[i][j] = 0;
                            helpingMaze[i][j+1] = 2;
                            break;
                        }
                        if (helpingMaze[i][j+1] == 3){ //Finish
                            helpingMaze[i][j] = 0;
                            helpingMaze[i][j+1] = 2;

                            maze.setEmptyMaze();
                            maze.setNewMaze();
                            int[][]help = maze.getMaze();
                            for (int k = 0;k<infoOfMaze.getWidthOfMaze();k++){ //Repainting whole maze
                                for(int l =0;l<infoOfMaze.getHeightOfMaze();l++){
                                    helpingMaze[k][l]=help[k][l];
                                }
                            }
                            x++;
                            break;
                        }
                    }
                }
            }
        }
    }
}
