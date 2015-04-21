/**                                                                                    
Nadia Trautwein                                                                        
trautwein.nadia@gmail.com                                                              
ntrautwe                                                                               
Assignment 8: Breadth-First Search                                                     
Last Modification: May 17, 2014                                                        
queue.java                                                                            
Extends functions of a doubly linked list to create first in, first out data structure
Code Status: working/tested                                                            
Compiles fine                                                                          
*/

//queue contains functions for average Queue data structure
public class queue extends list {
    
    //returns data at front of the list (without deleting)
    public int front() {
	return getFirstData(); 
    }

    //adds an element to the back of queue
    public void enque(int x) {
	insertRear(x);
    }
    
    //returns and removes first element
    public int deque() {
	if (isEmpty()) {
	    System.err.println("Deque on empty queue, returning -1");
	    return -1;
	}
	int temp = getFirstData(); 
	deleteFront();
	return temp;
    }
    
    //checks if the queue is empty
    public boolean isEmpty() {
	return listIsEmpty();
    }

    //for testing
    public void print() {
	listPrint();
    }
}//end class