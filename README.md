Java window application using Swing library. 

The user interface of the application consists of:
- canvas
- side menu

When the application starts the maze is generated  using the randomized depth first search and is drawn onto the canvas and player is places at the starting point.

The player can move their figure in 3 ways:
- by using the arrows keys on their keyboard. Always by one tile in the specified direction. They cannot enter a tile that contains a wall.
- by using the mouse. When the player figure is clicked, it can be moved like a rook chess piece (i.e. any number of tiles in the horizontal, or vertical directions).
The destination is chosen by a second mouse click. Tiles that can be moved to in this manner are highlighted, when the mouse hovers over them. When moving in this manner, the player cannot jump over walls.
- by using buttons on the side menu, that represent the arrow keys. The rules for moving in this manner are the same, as for the movement by the arrow keys on the keyboard.

When the player reaches the goal point, the application generates a new maze and the game starts over.

The side menu contain:
- a counter of successfully completed mazes
- a button that resets the counter and generates a new maze
- buttons representing the arrow keys, which can be used to move the player
