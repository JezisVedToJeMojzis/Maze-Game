package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import sk.stuba.fei.uim.oop.maze.InitilizationMaze;
import sk.stuba.fei.uim.oop.maze.GenerateMaze;

public class Mouse extends Canvas implements MouseListener, MouseMotionListener {

    int[][]helpingMaze;
    InitilizationMaze infoOfMaze = new InitilizationMaze();
    GenerateMaze maze = new GenerateMaze();
    private int wins;
    public Mouse(int[][] maze,int x){
        helpingMaze = maze;
        wins = x;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getY();
        int y = e.getX();
        int rectWidth = 25;
        int rectHeight = 25;
        for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
            for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                int rectX = i * 25;
                int rectY = j * 25;
                //Click on yellow
                if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 5) {
                    helpingMaze[j][i] = 2;//player green
                    for (int a = 0; a < infoOfMaze.getWidthOfMaze(); a++) {
                        for (int b = 0; b < infoOfMaze.getHeightOfMaze(); b++) {
                            if (helpingMaze[a][b] == 4 || helpingMaze[a][b] == 7) {
                                helpingMaze[a][b] = 0;
                            }
                        }
                    }
                    if (helpingMaze[infoOfMaze.getWidthOfMaze()-2][infoOfMaze.getHeightOfMaze()-2] == 2){ //Finish
                        maze.setEmptyMaze();
                        maze.setNewMaze();
                        int[][]help = maze.getMaze();
                        for (int k = 0;k<infoOfMaze.getWidthOfMaze();k++){ //Repainting whole maze
                            for(int l =0;l<infoOfMaze.getHeightOfMaze();l++){
                                helpingMaze[k][l]=help[k][l];
                            }
                        }
                        wins++;
                        break;
                    }
                }
                //Click on pink
                if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 6) {
                    helpingMaze[j][i] = 2;//player green
                    for (int a = 0; a < infoOfMaze.getWidthOfMaze(); a++) {
                        for (int b = 0; b < infoOfMaze.getHeightOfMaze(); b++) {
                            if (helpingMaze[a][b] == 4 || helpingMaze[a][b] == 7) {
                                helpingMaze[a][b] = 0;
                            }
                        }
                    }
                    if (helpingMaze[infoOfMaze.getWidthOfMaze()-2][infoOfMaze.getHeightOfMaze()-2] == 2){ //Finish
                        maze.setEmptyMaze();
                        maze.setNewMaze();
                        int[][]help = maze.getMaze();
                        for (int k = 0;k<infoOfMaze.getWidthOfMaze();k++){ //Repainting whole maze
                            for(int l =0;l<infoOfMaze.getHeightOfMaze();l++){
                                helpingMaze[k][l]=help[k][l];
                            }
                        }
                        wins++;
                        break;
                    }
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e){
        int x = e.getY();
        int y = e.getX();
        int rectWidth = 25;
        int rectHeight = 25;
        for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
            for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                int rectX = i * 25;
                int rectY = j * 25;
                //Click on green
                if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 2) {//Player
                    helpingMaze[j][i] = 7;
                    for (int k = i; k < infoOfMaze.getWidthOfMaze(); k++) {
                        if (helpingMaze[j][k] == 1) {//black
                            break;
                        }
                        if (helpingMaze[j][k] == 0 || helpingMaze[j][k] == 3) {//white or red
                            helpingMaze[j][k] = 4;//orange
                            if(j==infoOfMaze.getWidthOfMaze()-2 && k==infoOfMaze.getHeightOfMaze()-2){
                                helpingMaze[j][k] = 3;
                            }
                        }
                    }
                    for (int l = j; l < infoOfMaze.getWidthOfMaze(); l++) {
                        if (helpingMaze[l][i] == 1) {//black
                            break;
                        }
                        if (helpingMaze[l][i] == 0 || helpingMaze[l][i] == 3) {//white or red
                            helpingMaze[l][i] = 4;//orange
                            if(l==infoOfMaze.getWidthOfMaze()-2 && i==infoOfMaze.getHeightOfMaze()-2){
                                helpingMaze[l][i] = 3;
                            }
                        }
                    }
                    for (int m = j; m > 0; m--) {
                        if (helpingMaze[m][i] == 1) {//black
                            break;
                        }
                        if (helpingMaze[m][i] == 0 || helpingMaze[m][i] == 3) {//white or red
                            helpingMaze[m][i] = 4;//orange
                        }
                    }
                    for (int n = i; n > 0; n--) {
                        if (helpingMaze[j][n] == 1) {//black
                            break;
                        }
                        if (helpingMaze[j][n] == 0 || helpingMaze[j][n] == 3) {//white or red
                            helpingMaze[j][n] = 4;//orange
                        }
                    }
                }
                //Clicking on green again
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 7){
                    helpingMaze[j][i] = 2;//player green
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 4 || helpingMaze[u][v] == 5 || helpingMaze[u][v] == 6) {
                                if(helpingMaze[u][v] == 6) {
                                    helpingMaze[u][v] = 3;
                                    break;
                                }
                                helpingMaze[u][v] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
    public void mouseMoved(MouseEvent e) {
        int x = e.getY();
        int y = e.getX();
        int rectWidth = 25;
        int rectHeight = 25;
        for (int i = 0; i < infoOfMaze.getWidthOfMaze(); i++) {
            for (int j = 0; j < infoOfMaze.getHeightOfMaze(); j++) {
                int rectX = i * 25;
                int rectY = j * 25;
                //Leaving and creating yellow button
                if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 4) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                        helpingMaze[j][i] = 5;
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 7) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 1) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 3) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                        helpingMaze[j][i] = 6;
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 0) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 6) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 5) {
                                helpingMaze[u][v] = 4;
                            }
                        }
                    }
                }
                //Leaving pink button
                if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 4) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 7) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 1) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 0) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 5) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }
                else if (x > rectX && x < rectX + rectWidth && y > rectY && y < rectY + rectHeight && helpingMaze[j][i] == 2) {
                    for (int u = 0; u < infoOfMaze.getWidthOfMaze(); u++) {
                        for (int v = 0; v < infoOfMaze.getHeightOfMaze(); v++) {
                            if (helpingMaze[u][v] == 6) {
                                helpingMaze[u][v] = 3;
                            }
                        }
                    }
                }

            }
        }

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){

    }
}
