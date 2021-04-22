package sk.stuba.fei.uim.oop.graphic;

import sk.stuba.fei.uim.oop.keyboard.KeyDown;
import sk.stuba.fei.uim.oop.keyboard.KeyLeft;
import sk.stuba.fei.uim.oop.keyboard.KeyRight;
import sk.stuba.fei.uim.oop.keyboard.KeyUp;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import sk.stuba.fei.uim.oop.Mouse;
import java.awt.*;


public class MyCanvas extends Canvas {

    InitilizationMaze mazeInfo = new InitilizationMaze();
    private int [][] newMaze;
    private int helpingCounter;
    Image backBuffer;
    Graphics bBG;

    public MyCanvas(int[][] maze,int counter){
        setBackground(Color.PINK);
        newMaze =  maze;
        helpingCounter = counter;
        //MouseListener
        addMouseListener(new Mouse(newMaze,counter));
        addMouseMotionListener(new Mouse(newMaze,counter));
        //KeyListeners
        addKeyListener(new KeyDown(newMaze,counter));
        addKeyListener(new KeyUp(newMaze));
        addKeyListener(new KeyLeft(newMaze));
        addKeyListener(new KeyRight(newMaze,counter));
    }
    public void update( Graphics g ){
        paint(g);
    }//this avoids flickering of canvas

    @Override
    public void paint(Graphics g){
        if( backBuffer == null ) { //this avoids flickering of canvas
            backBuffer = createImage( getWidth(), getHeight() );
            bBG = backBuffer.getGraphics();
        }
        //Draw the maze
        for (int i =0;i< mazeInfo.getHeightOfMaze(); i++) {
            for (int j = 0; j< mazeInfo.getWidthOfMaze(); j++) {
                if (newMaze[i][j]==0) {//Road
                    g.setColor(Color.WHITE);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 2){//Player
                    g.setColor(Color.GREEN);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 3){//Finish
                    g.setColor(Color.RED);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 4){//Possible road
                    g.setColor(Color.ORANGE);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 5){//Possible road when mouse moves over it
                    g.setColor(Color.YELLOW);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 6){//Possible finish when mouse moves over it
                    g.setColor(Color.PINK);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else if (newMaze[i][j]== 7){//Another player implementation
                    g.setColor(Color.GREEN);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
                else{//Walls
                    g.setColor(Color.BLACK);
                    g.fillRect(i * 25, j * 25, 25, 25);
                }
            }
        }
        g.setColor(Color.red);//Counter
            String s = "TOTAL WINS: " + this.helpingCounter;
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.drawString(s, 206, 650); //WHY DOESNT IT REPAINT
        repaint();
    }
}
