/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 1 (Linked List)
Last modified: Feb 5, 2014
List.java
This class is a Linked List class to be used
with functions to insert a node in the front
and delete a node from the front. It has an 
inner node class for use with Linked List.
Code Status: working/tested
*/
//class list contains insert and delete functions
public class List {
    //class LinkNode makes individual nodes for use in a list
    protected class LinkNode {
	protected LinkNode next;
	protected double data;
	
	public LinkNode() {
	    next = null;
	    data = 0.0;
	}
    }
    
    protected LinkNode first;
    
    public List() {
	first = null;
    }
    
    //inserts a node in the front of a list of nodes
    public void insertFront (double x) {
	LinkNode temp = new LinkNode();
	temp.next = first;
	temp.data = x; 
	first = temp;
    }

    //deletes a node from the front of a list of nodes
    public void deleteFront() {
	if (first == null) {
	    return;
	}
	first = first.next;
    }
}