
// Maze Assignment
// Edmund Gladzah
// 10 / 10 / 2019

import java.util.*;
	import java.io.*;
	
	
	
	public class MazeAssignment { 
	    
	    private static final int MAX_ROW = 20; 	// Set Max row number
	    private static final int MAX_COL = 20; 	// Set Max column number
	    
	    
	    int n = MAX_ROW;
	    int m = MAX_COL; 
	    
	    private static boolean[][] notVisited = new boolean[MAX_ROW][MAX_COL]; // Array to keep track of paths not visited
	    
	    
	    public static void main(String[] args) { 
	        
	        
	        
	        notChecked(true);  // Sets all unvisited paths to true
	        
	        /* Reads data from maze.txt file, stores 
	         * the data into a two dimensional array[maze]
	         * and prints out the array
	         */
	        boolean isOpen;
	        Scanner inputFile = null;
	        File SomeFile = new File("maze.txt");
	        String[][] maze = new String [20][20];
	        int row = 0;
	        int col = 0;
	        
	        
	        try{
	            inputFile = new Scanner(SomeFile);
	            isOpen = true;
	        }
	        catch(FileNotFoundException e) {
	            System.out.println("File not Found!");
	            isOpen = false;
	            
	        }
	        
	        if(isOpen && inputFile.hasNext()) {
	            while(inputFile.hasNext()) {
	                maze[row][col] = inputFile.next();
	                col++;
	                if(col ==20){
	                    row++;
	                    col = 0;
	                }
	                
	            }
	        }
	        printFile(maze);
	        
	        
	        
	        
	        
	        
	        if (isValid(maze))
	            
	            System.out.println("I am free!\n"); 
	        else
	            
	            System.out.println("\nHelp, I am trapped!\n"); 
	        
	    } 
	    
	    // Method to set all unvisited paths to true
	    private static void notChecked(boolean b) { 
	        
	        for (int i = 0; i < notVisited.length; i++) {
	            
	            for (int j = 0; j < notVisited[i].length; j++) { 
	                
	                notVisited[i][j] = b; 
	            } 
	        } 
	        
	    } 
	    
	    // Method to find valid pathways in the maze
	    private static boolean isValid(String maze[][]) { 
	        
	        Scanner coord = new Scanner(System.in);
	        
	        // Input validation to make sure user input is right
	        int i = getInt(coord,"\nPlease enter your initial row number: ");
	        while(i< 0 || i > 19) {
	            System.out.println("Invalid! Enter number between 0 & 19");
	            i = getInt(coord,"\nPlease enter your initial row number: ");
	        }
	
	        int j = getInt(coord, "\nPlease enter your initial column number: ");
	        while(j< 0 || j > 19) {
	            System.out.println("Invalid! Enter number between 0 & 19");
	            j = getInt(coord,"\nPlease enter your initial column number: ");
	        }
	        
	        maze[i][j] = "S";	//Sets beginning to S
	        System.out.println();
	        printFile(maze); // Print maze with beginning shown as S
	   
	        int destinationX, destinationY; 
	        destinationX = 0; 
	        destinationY = 0; 
	        
	        Stack<Node> holder = new Stack<Node>(); // Stack to reverse the path stored in the linked list for printing
	        UnorderedLinkedList s = new UnorderedLinkedList(); // Linked list to store path
	        Node temp = new Node(i, j); 
	        
	        s.insertLast(temp); 
	        
	        /* Takes the last node in the linked list and
	         * moves up, left, down or right according
	         * to the nodes dir variable
	         * (--The dir variable determines the direction to be checked--)
	         */
	        while (!s.isEmptyList()) { 
	            
	            
	            temp = s.back(); 
	            int d = temp.getDir(); 
	            i = temp.getX(); 
	            j = temp.getY();
	            
	            
	            /* Increases temp's dir variable and inserts back 
	             * into linked list
	             */
	            temp.setDir(temp.getDir() + 1); 
	            s.deleteNode(); 
	            s.insertLast(temp); 
	            
	           // If destination is reached, print path and return true
	            if (i == destinationX && j == destinationY) {
	                
	                while (!s.isEmptyList()) {
	                    temp = s.back(); 
	                    i = temp.getX(); 
	                    j = temp.getY();
	                    s.deleteNode();
	                    holder.push(temp);
	                    
	                }
	                
	                System.out.println("\n---Path from S to E---");
	                
	                while (!holder.empty()) {
	                    temp = holder.peek(); 
	                    i = temp.getX(); 
	                    j = temp.getY();
	                    holder.pop();
	                    System.out.print("("+i+","+j+") -> ");
	                }
	                return true; 
	            } 
	            
	            if (d == 0) { 
	                
	                // Checking the Up direction. 
	                if (i - 1 >= 0 && maze[i - 1][j].equals("0") && 
	                    notVisited[i - 1][j] || i - 1 >= 0 && maze[i - 1][j].equals("E") && 
	                    notVisited[i - 1][j] || i - 1 >= 0 && maze[i - 1][j].equals("S") && 
	                    notVisited[i - 1][j]) { 
	                    
	                    Node temp1 = new Node(i - 1, j); 
	                    notVisited[i - 1][j] = false; 
	                    s.insertLast(temp1);
	                    
	                } 
	            } 
	            else if (d == 1) { 
	                
	                // Checking the left direction 
	                if (j - 1 >= 0 && maze[i][j - 1].equals("0") && 
	                    notVisited[i][j - 1] || j - 1 >= 0 && maze[i][j - 1].equals("E") && 
	                    notVisited[i][j - 1] || j - 1 >= 0 && maze[i][j - 1].equals("S") && 
	                    notVisited[i][j - 1]) { 
	                    
	                    Node temp1 = new Node(i, j - 1); 
	                    notVisited[i][j - 1] = false; 
	                    s.insertLast(temp1);
	                    
	                } 
	            } 
	            else if (d == 2) { 
	                // Checking the down direction 
	                if (i + 1 < MAX_ROW && maze[i + 1][j].equals("0") && 
	                    notVisited[i + 1][j] || i + 1 < MAX_ROW && maze[i + 1][j].equals("E") && 
	                    notVisited[i + 1][j] || i + 1 < MAX_ROW && maze[i + 1][j].equals("S") && 
	                    notVisited[i + 1][j]) { 
	                    
	                    Node temp1 = new Node(i + 1, j); 
	                    notVisited[i + 1][j] = false; 
	                    s.insertLast(temp1); 
	                    
	                } 
	            } 
	            else if (d == 3) { 
	                
	                // Checking the right direction 
	                if (j + 1 < MAX_COL && maze[i][j + 1].equals("0") && 
	                    notVisited[i][j + 1] || j + 1 < MAX_COL && maze[i][j + 1].equals("E") && 
	                    notVisited[i][j + 1] || j + 1 < MAX_COL && maze[i][j + 1].equals("S") && 
	                    notVisited[i][j + 1]) { 
	                    
	                    Node temp1 = new Node(i, j + 1); 
	                    notVisited[i][j + 1] = false; 
	                    s.insertLast(temp1); 
	                    
	                } 
	            } 
	            
	            
	            else { 
	                /* If none of the directions
	                 * are valid i.e(d=4), backtrack!
	                 */
	                notVisited[temp.getX()][temp.getY()] = true; 
	                s.deleteNode(); 
	            } 
	        } 
	        
	        /* Return false when stack is empty
	         * (meaning to path could be found)
	         */
	        return false; 
	    } 
	    
	   
	    // Method to print maze with rows and column numbers
	    public static void printFile(String[][]maze) {
	        
	        for(int i = 0; i < maze.length; i++){
	            
	            System.out.printf("Row %2d  ",i);
	            
	            for(int j = 0; j < maze[i].length; j++){
	                
	                System.out.print(maze[i][j]+"  ");
	            }
	            
	            System.out.println();
	        }
	        
	        for(int i = 19; i < maze.length; i++){
	            
	            System.out.println();
	            
	            System.out.println("\t\t\tColumn   ");
	            
	            System.out.print("       ");
	            
	            for(int j = 0; j < maze[i].length; j++){
	                
	                System.out.printf("%2d ",j);
	            }
	            
	            System.out.println();
	        }
	        
	    }
	    
	    // Method to check if user input is an integer
	    public static int getInt(Scanner input, String a) {
	        
	        System.out.print(a);
	        
	        while(!input.hasNextInt()) {
	            input.next();
	            System.out.print("Please enter an integer: ");
	        }
	        
	        return input.nextInt();
	    }
	    
	} 
	
