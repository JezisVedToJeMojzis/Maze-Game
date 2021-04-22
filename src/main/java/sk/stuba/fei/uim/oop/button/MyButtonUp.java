package sk.stuba.fei.uim.oop.button;

import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonUp extends JButton implements ActionListener {

    private int[][] helpingMaze;
    public MyButtonUp(String label, int[][] maze){
        super(label);
        helpingMaze = maze;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InitilizationMaze infoOfMaze = new InitilizationMaze();
        for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
            for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                if (helpingMaze[i][j]==2) { //Player
                    if(helpingMaze[i][j-1]==0) {
                        helpingMaze[i][j] = 0;
                        helpingMaze[i][j-1] = 2;
                        break;
                    }
                }//Dont need to take care of finish because u can never reach it by going up
            }
        }
    }
}
