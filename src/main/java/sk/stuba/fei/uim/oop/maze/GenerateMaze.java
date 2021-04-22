package sk.stuba.fei.uim.oop.maze;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class GenerateMaze {

    //Maze: 1 = wall , 0 = road
    private int[][] maze;
    private int way = 4; //up,down,right,left
    Random rand = new Random();
    InitilizationMaze basicMaze = new InitilizationMaze();
    private int height = this.basicMaze.getHeightOfMaze();
    private int width = this.basicMaze.getWidthOfMaze();

    //Setting empty maze without roads
    public void setEmptyMaze(){
        maze = this.basicMaze.getMaze();
    }

    //Generate new maze
    public void setNewMaze(){
        int row = rand.nextInt(height);
        while (row % 2 == 0) {
            row = rand.nextInt(width);
        }
        int column = rand.nextInt(width);
        while (column % 2 == 0) {
            column = rand.nextInt(width);
        }
        maze[row][column]= 0; //starting point from where the maze will be drawn (0 = road)

        recursion(row, column);

        maze[1][1]= 2; //2 = player
        maze[height - 2][width - 2]= 3; //3 = finish
    }

    public void recursion(int row, int column) { //Recursive DFS
        Integer[] ways = generateRandomDirections();
        for (int i = 0; i < ways.length; i++) {
            if (ways[i] == 1) {//Up
                if (row - 2 <= 0)
                    continue;
                if (maze[row - 2][column] != 0) {
                    maze[row - 2][column] = 0;
                    maze[row - 1][column] = 0;
                    recursion(row - 2, column);
                }
            }
            if(ways[i]==2) {//Right
                if (column + 2 >= width - 1)
                    continue;
                if (maze[row][column + 2] != 0) {
                    maze[row][column + 2] = 0;
                    maze[row][column + 1] = 0;
                    recursion(row, column + 2);
                }
            }
            if(ways[i]==3) {//Down
                if (row + 2 >= height - 1)
                    continue;

                if (maze[row + 2][column] != 0) {
                    maze[row + 2][column] = 0;
                    maze[row + 1][column] = 0;
                    recursion(row + 2, column);
                }
            }
            if(ways[i]==4) {//Left
                if (column - 2 <= 0)
                    continue;
                if (maze[row][column - 2] != 0) {
                    maze[row][column - 2] = 0;
                    maze[row][column - 1] = 0;
                    recursion(row, column - 2);
                }
            }
        }
    }

    //Generating random collection of ways
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randomWays = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            randomWays.add(i + 1);
        }
        Collections.shuffle(randomWays);
        return randomWays.toArray(new Integer[4]);
    }

    //To get maze
    public int[][] getMaze(){
       return this.maze;
    }

}
