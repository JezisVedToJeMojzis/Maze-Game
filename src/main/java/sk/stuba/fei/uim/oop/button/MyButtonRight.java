package sk.stuba.fei.uim.oop.button;

import sk.stuba.fei.uim.oop.maze.GenerateMaze;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyButtonRight extends JButton implements ActionListener {

    private int[][] helpingMaze;
    private int wins;
    public MyButtonRight(String label, int[][] maze,int x){
        super(label);
        helpingMaze = maze;
        wins = x;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

