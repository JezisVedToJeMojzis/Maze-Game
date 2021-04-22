package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.graphic.Window;
import sk.stuba.fei.uim.oop.maze.GenerateMaze;
//Author: Samuel Mojžiš
//GREEN = PLAYER
//RED = FINISH
//WHITE = ROAD
//BLACK = WALLS
//CONTROL PLAYER WITH KEYBOARD (ARROWS), BUTTONS IN WINDOW AND MOUSE (CLICK ON THE PLAYER AND POSSIBLE ROAD WILL BE SHOWN (ORANGE) - TO STOP MOUSE CONTROL CLICK ON THE PLAYER AGAIN)

public class Game {
    public Game(){
        GenerateMaze maze = new GenerateMaze();
        Counter counter = new Counter();
        maze.setEmptyMaze();
        maze.setNewMaze();
        counter.setNewCounter();
        Window window = new Window(maze.getMaze(),counter.getCounter());
    }
}
