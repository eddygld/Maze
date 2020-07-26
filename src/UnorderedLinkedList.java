//Class: UnorderedLinkedList extends 
//Class: LinkedListIntClass 
public class UnorderedLinkedList extends LinkedListClass { 
    //Default constructor 
    public UnorderedLinkedList() { 
        super(); 
    } 
    public boolean search(int searchItem)  { 
        LinkedListNode current; //variable to traverse the list 
        current = first; 
        while (current != null) 
            if (current.info.equals(searchItem)) 
            return true; 
        else 
            current = current.link; 
        return false; 
    } 
    public void insertFirst(Node newItem) { 
        LinkedListNode newNode;  //variable to create the new node 
        //create and insert newNode before first 
        newNode = new LinkedListNode(newItem, first); 
        first = newNode; 
        if (last == null) 
            last = newNode; 
        count++; 
    }
    
    
    public String toString() {
        LinkedListNode current;
        current = first;
        String temp = "";
        while (current != null) {
            temp += current.info + ", ";
            current = current.link;
            if (current.link == null) {
                temp += current.info;
                current = current.link;
            }
        }
        return "["+temp+"]";
    }
    public void insertLast(Node newItem)  { 
        LinkedListNode newNode; //variable to create the new node 
        //create newNode 
        newNode = new LinkedListNode(newItem, null); 
        if (first == null) { 
            first = newNode; 
            last = newNode; 
        } 
        else { 
            last.link = newNode; 
            last = newNode; 
        } 
        count++; 
    } 
    
    public void deleteNode() { 
        LinkedListNode current; //variable to traverse the list 
        LinkedListNode trailCurrent; //variable just before current 
        trailCurrent = first; //trailCurrent points to first node 
        current = first.link; //current points to second node 
        while (current != null) { 
            if (last == current)  //node to be deleted was the last node  
                       last = trailCurrent;
            trailCurrent = current; 
            current = current.link;
             
        } 
        
        count--;
        if(count ==0)
            first = null;
        
         
    } 
    
} 

