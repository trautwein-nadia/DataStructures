/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe 
Assignment 1 (Linked List)
Last modified: Feb 5, 2014
Stack.java
This class uses a Linked List to make a Stack 
of doubles, and has a run method that takes 
input from STDIN, stores it, and then "pops"
it back out (now in reverse order of input).
Code Status: working/tested
*/

import java.util.Scanner;
import java.text.*;

//this Stack class uses Linked List to store numbers
//on top of each other and then pop out the one on top
public class Stack extends List {
    
    //push puts the input onto the top of a list/stack
    public void push(double x) {	
	insertFront(x);
    }

    //pop takes teh first piece of data off the top of a 
    //stack, deletes the top value, and then returns the 
    //value 
    public double pop(){
	double temp = first.data;
	deleteFront();
	return temp;
    }

    //run is used in main (located in p1 class). It takes 
    //input and pushes it onto the stack, then popping it
    //off  in reverse order of input while printing the 
    //input out
    public void run(){
	Scanner in = new Scanner(System.in);
	double temp;
	
	while (in.hasNextDouble()) {
	    temp = in.nextDouble();
	    push(temp);
	}

	while (first != null) {
	    DecimalFormat df = new DecimalFormat("#.000");
	    System.out.println(df.format(pop()));
	}
    }
}