package sk.stuba.fei.uim.oop.button;

import sk.stuba.fei.uim.oop.maze.GenerateMaze;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyButtonRestart extends JButton implements ActionListener {

    private int [][] helpingMaze;
    private int[][] help;
    private int wins;
    public MyButtonRestart(String label,int[][] maze,int x){
        super(label);
        helpingMaze = maze;
        wins = x;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GenerateMaze maze = new GenerateMaze();
        InitilizationMaze infoOfMaze = new InitilizationMaze();

        maze.setEmptyMaze();
        maze.setNewMaze();;
        help = maze.getMaze();
        for (int k = 0;k<infoOfMaze.getWidthOfMaze();k++){ //Repainting whole maze
            for(int l =0;l<infoOfMaze.getHeightOfMaze();l++){
                helpingMaze[k][l]=help[k][l];
            }
        }
        wins = 0;
    }
}
