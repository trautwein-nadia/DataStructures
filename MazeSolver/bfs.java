/**                                                                                    
Nadia Trautwein                                                                        
trautwein.nadia@gmail.com                                                              
ntrautwe                                                                               
Assignment 8: Breadth-First Search                                                     
Last Modification: May 17, 2014                                                        
bfs.java
Takes Integer ArrayList (maze) and uses Breadth-First Search to find shortest path
Code Status: working/tested                                                            
Compiles fine                                                                         
*/

import java.util.ArrayList;
import java.lang.Math;
import java.lang.Integer;

//bfs contains functions relating to the search, printing, and adjacent squares
public class bfs {
    private char[] color; //black (b), white (w), grey(g)
    private int[] distance;
    private int[] parent;
    private int[] adj;   
    private queue Q;
    private int size;
    private int dim;

    //constructor initilizes all arrays, calls search and print 
    public bfs(ArrayList<Integer> input) {
	size = input.size(); //0-8 means size 9
	dim = (int) Math.sqrt(size); //size of 1 row/column
	color = new char[size];
	distance = new int[size];
	parent = new int[size];
	BFsearch(input);
	print();
    }

    //prints answer coordinates (row,column)
    private void print() {
	System.out.println("(0,0)");
	int p = parent[0];
	while (p != -1) {
	    System.out.println("(" + p/dim + "," + p%dim + ")");
	    p = parent[p];
	}
    }

    //finds shortest path through maze using a queue and adjacent function
    private void BFsearch(ArrayList<Integer> maze) {
	for (int i = 0; i < size; i++) {
	    color[i] = 'w';
	    distance[i] = -1;
	    parent[i] = -1;
	}
	color[size -1] = 'g';
	distance[size -1] = 0;
	Q = new queue();
	Q.enque(size -1);
	while(!Q.isEmpty()) {
	    int t = Q.front();
	    adj = new int[4];
	    adjacent(maze, t);
	    for (int i = 0; i < adj.length; i++) {
		if (adj[i] != -1 && color[adj[i]] == 'w'){
		    color[adj[i]] = 'g';
		    parent[adj[i]] = t;
		    distance[adj[i]] = distance[t] + 1;
		    Q.enque(adj[i]);
		}
	    }
	    Q.deque();
	    color[t] = 'b';
	}
    }

    //uses bitwise functions to find adjacent squares
    private void adjacent(ArrayList<Integer> maze, int t) {
	if (t >= 0 && t < size) {
	    for (int i = 0; i < adj.length; i++) { //erase values each time
		adj[i] = -1; 
	    }
	    int count = 0;
	    if (t == 0) { //if first index
		int first = maze.get(0).intValue();                            
		if ((first&1) != 1) { //if right is open
		    adj[count] = 1;
		    count++;
		}                                                                    
		if ((first&2) != 2) { //if down is open                                
		    adj[count] = dim;
		}        
	    }
	    else if (t == size-1) { //if last index
		int index = maze.size() -1;                                          
		int num = maze.get(index).intValue();                                
		if ((num&8) != 8) { //if up is open 
		    adj[count] = size-dim - 1;
		    count++;
		}                                                                    
		if ((num&4) != 4) { //if left is open
		    adj[count] = size - 2;
		}         
	    }
	    else { //for all other indexes
		int x = maze.get(t).intValue();    
		if ((x&1) != 1) { //if right is open
		    adj[count] = t+1;
		    count++;
		}                                                                 
		if ((x&4) != 4) { //if left is open  
		    adj[count] = t-1;
		    count++;
		}                                                                   
		if ((x&8) != 8) { //if up is open
		    adj[count] = t-dim;
		    count++;
		}                                                                  
		if ((x&2) != 2) { //if down is open
		    adj[count] = t+dim;
		    count++; 
		}                                                                  
	    }
	}
    }//end adjcent function 
}//end class