class Node {
    
    private int x, y; 
    private int dir; 
    
    public Node(int a, int b) { 
        x = a; 
        y = b; 
        
        // default value for direction set to 0 (Up) 
        dir = 0; 
    } 
    
    public int getX() { 
        return x; 
    } 
    
    public void setX(int a) { 
        x = a; 
    } 
    
    public int getY() { 
        return y; 
    } 
    
    public void setY(int b) { 
        y = b; 
    } 
    
    public int getDir() { 
        return dir; 
    } 
    
    public void setDir(int c) { 
        dir = c; 
    } 
} 