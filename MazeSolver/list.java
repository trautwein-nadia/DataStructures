/**                                                                                    
Nadia Trautwein                                                                        
trautwein.nadia@gmail.com                                                              
ntrautwe                                                                               
Assignment 8: Breadth-First Search                                                     
Last Modification: May 17, 2014                                                        
list.java                                                                             
Doubly Linked List data structure
Code Status: working/tested                                                            
Compiles fine                                                                          
*/

//list contains functions to make a Doubly Linked List 
public class list {
    //inner node class for linking
    protected class LinkNode {
	protected LinkNode next;
	protected LinkNode prev;
	protected int data;

	//constructor
	private LinkNode() {
	    next = prev = null;
	    data = -1;
	}
    } //end node class

    protected LinkNode first;
    protected LinkNode last;

    //constructor
    public list() {
	first = last = null;
    }

    //returns data at front of list (for queue)
    public int getFirstData() {
	return first.data;
    }

    //returns true if the list is empty
    public boolean listIsEmpty() {
	return first == null;
    }

    //inserts a node in the front of a list of nodes                                 
    public void insertFront (int x) {
        LinkNode temp = new LinkNode();
        temp.data = x;
        if (first == null) {
            first = last = temp;
            return;
        }
        first.prev = temp;
        temp.next = first;
        first = temp;
    }

    //inserts a node into the list's rear (hehehe)
    public void insertRear(int x) {
	LinkNode temp = new LinkNode();
	temp.data = x;
	if (first == null) {
	    insertFront(x);
	    return;
	}
	temp.prev = last;
	last.next = temp;
	last = temp;
    }

    //deletes a node from the front of a list of nodes
    public void deleteFront() {
	if (first == null) {
	    return;
	}
	if (first == last) {
	    first = last = null;
	    return;
	}
	first.next.prev = null;
	first = first.next;
    }

    //printing for testing
    public void listPrint() {
	LinkNode temp = first;
	while (temp != null) {
	    System.out.print(temp.data);
	    System.out.print(" ");
	    temp = temp.next;
	}
	System.out.println();
    }
}//end class