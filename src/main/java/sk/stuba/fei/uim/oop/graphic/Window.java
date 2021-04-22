package sk.stuba.fei.uim.oop.graphic;

import javax.swing.*;
import sk.stuba.fei.uim.oop.button.*;
import java.awt.*;

public class Window extends JFrame{

    private int[][]helpingMaze;
    private int helpingCounter;
    public  Window(int[][] maze,int counter){
        helpingMaze = maze;
        helpingCounter=counter;
        createWindow();
    }

    public void createWindow(){
        //JFrame
        JFrame window = new JFrame();
        window.setTitle("Maze Game");
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 745;
        int width = 639;
        window.setSize(width,height);

        window.add("Center",new MyCanvas(helpingMaze,helpingCounter));

        //Buttons
        MyButtonQuit quit = new MyButtonQuit("Quit Game");
        MyButtonRestart restart = new MyButtonRestart("Restart",helpingMaze,helpingCounter);
        MyButtonUp up = new MyButtonUp("↑", helpingMaze);
        MyButtonDown down = new MyButtonDown("↓", helpingMaze,helpingCounter);
        MyButtonLeft left = new MyButtonLeft("←",helpingMaze);
        MyButtonRight right = new MyButtonRight("→",helpingMaze,helpingCounter);

        //JPanel
        JPanel P = new JPanel();
        P.setLayout(new GridLayout(2,3));
        P.add(restart);
        P.add(up);
        P.add(quit);
        P.add(left);
        P.add(down);
        P.add(right);
        window.add("South" ,P);
        window.setVisible(true);
    }

}
