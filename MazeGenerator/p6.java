/**                                                                                    
Nadia Trautwein                                                                        
trautwein.nadia@gmail.com                                                              
ntrautwe                                                                               
Assignment 6: Maze Generation with Disjoint Sets                                       
Last modification: April 25, 2014                                                      
p6.java
p6 takes a number from the command line and uses that to generage a sizeXsize maze
Code status: working/tested                                                            
Compiles fine                                                                          
*/

import java.lang.Integer;

//Runs mazeMaker.java with proper command line input
public class p6 {
    public static void main(String args[]) {
	for (String s: args) {
	    int n = Integer.parseInt(s);
	    if (n>2) {
		mazeMaker M = new mazeMaker(n);
		M.makeMaze();
		M.print();
	    }
	    else {
		System.out.println("Please enter a value greater than 2!");
	    }
	}
    }
}