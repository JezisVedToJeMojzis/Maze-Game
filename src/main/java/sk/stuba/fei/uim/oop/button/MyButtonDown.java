package sk.stuba.fei.uim.oop.button;

import sk.stuba.fei.uim.oop.maze.GenerateMaze;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonDown extends JButton implements ActionListener {

    private int[][] helpingMaze;
    private int x;
    public MyButtonDown(String label, int[][] maze,int wins){
        super(label);
        helpingMaze = maze;
        x=wins;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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