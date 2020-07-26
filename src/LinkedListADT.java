//Interface: LinkedListIntADT
public interface LinkedListADT { 
    public boolean isEmptyList(); 
    public void initializeList(); 
    public void print(); 
    public int length(); 
    public Node front(); 
    public Node back(); 
    public boolean search(int searchItem); 
    public void insertFirst(Node newItem); 
    public void insertLast(Node newItem); 
    public void deleteNode(); 
}