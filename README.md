# Maze
A simple maze game implemented using Linear Data Structures in Java.
Given the starting point in a maze, the program **finds and marks a path out of the maze**, which is represented by a *20x20* array of 1s (representing hedges) and 0s (representing the foot-paths). There is only one exit from the maze (represented by E).

## Features
* The pathfinder moves vertically or horizontally in any direction that contains a 0.
* The pathfinder does not move into a square with a 1.
* If the pathfinder moves into the square with an E, it has exited the maze.
* If the pathfinder is in a square with 1s on three sides, it must go back the way it came and try another path.  
* The pathfinder not move diagonally. 

## Implementation
* This program, uses a single linked list for finding the path.
* Input data is the following array of characters (1s, 0s, and E) from an ASCII text data file **(maze.txt)**.
* Each data line consists of one row of maze. Starting points (i.e. a row, column pair) in the maze will be input from the keyboard.

## Output
Prints the maze complete with numbered rows and columns prior to asking the user for their starting point. For each entry into the maze, it prints the complete maze with an S in the starting point followed by the words **‘I am free’** if it has found a path out of the maze or the words **‘Help, I am trapped’** if it cannot. It prints the path as a single linked list.

## Usage
Run in your IDE

## Screenshot
![Maze screenshot](/screenshot/screenshot.png)
