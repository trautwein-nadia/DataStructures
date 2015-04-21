/**                                                                                   
Nadia Trautwein                                                                       
trautwein.nadia@gmail.com                                                              
ntrautwe                                                                              
Assignment 6: Maze Generation with Disjoint Sets                                       
Last modification: April 25, 2014                                                      
mazeMaker.java
mazeMaker uses unionSet to generate a maze of size dimXdim
Code status: working/tested                                                            
Compiles fine                                                                          
*/

import java.lang.Integer;

//Class contains functions to create and print a maze of hex characters 
public class mazeMaker {
    private unionSet M;
    private int[] A; 
    private int size; //s*s
    private int dim; //length/height 
    private final int L = 4;
    private final int R = 1;
    private final int U = 8;
    private final int D = 2;
        
    //Constructor takes in a size s and initializes an empty maze
    public mazeMaker(int s) { 
	dim = s;
	size = s*s;
	M = new unionSet(size); 
	A = new int[size];
	for (int i = 0; i < size; i++) {
	    A[i] = 15;
	}
	A[0] = 11;
	A[size-1] = 14;
    }
    
    //Prints maze as dimXdim hex characters
    public void print(){
	for (int i = 0; i < size; i++) {
	    if (i != 0 && i%dim == 0) {
		System.out.println();
	    }
	    System.out.print(Integer.toHexString(A[i]));
	}
	System.out.println();
    }

    //Generates a random maze from an initialized one
    public void makeMaze() {
	while(M.numSets() > 1) { 
	    int randI = (int)(Math.random()*(size)); 
	    int w = (int)(Math.random()*4); //tells which way to "look"
	    for (int i = 0; i < 3; i++) { 
		if (w == 0) { //left wall
		    if(randI%dim !=0){
			if (M.union(randI, randI - 1)) {
				A[randI] = A[randI] - L;
				A[randI-1] = A[randI-1] - R;
			}
		    }
		}
		else if (w == 2) { //right wall
		    if ((randI+1)%dim != 0) {
			if (M.union(randI, randI + 1)) {
			    A[randI] = A[randI] - R;
			    A[randI+1] = A[randI+1] - L;
			}
		    }
		}
		else if (w == 1){ //up wall
		    if (randI >= dim) {
			if (M.union(randI, randI - dim)) {
                            A[randI] = A[randI] - U;
                            A[randI-dim] = A[randI-dim] - D;
                        }
		    }
		}
		else if (w == 3) { //down wall
		    if (randI < (size-dim)) {
			if (M.union(randI, randI + dim)) {
                            A[randI] = A[randI] - D;
                            A[randI+dim] = A[randI+dim] - U;
                        }
		    }
		}
	    }
	}
    }  
}