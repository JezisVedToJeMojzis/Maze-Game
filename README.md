Java window application using Swing library. 

The user interface of the application consists of:
* canvas
* side menu (you can choose the location of this side menu freely)

When the application starts, generate a maze using the [randomized depth first search](https://www.baeldung.com/cs/maze-generation#dfs-maze) algorithm and draw it onto the canvas.
The grid containing the maze must be at least 11x11 tiles large (including wall tiles). The entire maze must be surrounded by walls (no paths in the maze can touch the borders of the window).

In the generated maze choose in any way a starting and a goal point. Place the player figure on the starting point. The player can move their figure in 3 ways:
* by using the arrows keys on their keyboard. Always by one tile in the specified direction. They cannot enter a tile that contains a wall.
* by using the mouse. When the player figure is clicked, it can be moved like a rook chess piece (i.e. any number of tiles in the horizontal, or vertical directions).
The destination is chosen by a second mouse click. Tiles that can be moved to in this manner must be highlighted, when the mouse hovers over them. When moving in this manner, the player cannot jump over walls.
* by using buttons on the side menu, that represent the arrow keys. The rules for moving in this manner are the same, as for the movement by the arrow keys on the keyboard.

When the player reaches the goal point, the application should generate a new maze and the game starts over.

The side menu must contain:
* a counter of successfully completed mazes
* a button that resets the counter and generates a new maze
* buttons representing the arrow keys, which can be used to move the player. These buttons must be placed in the same way, they are placed on a regular keyboard.
