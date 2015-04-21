/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 6: Maze Generation with Disjoint Sets
Last modification: April 25, 2014
unionSet.java
Unionset will join sets together by naming their parent
Code status: working/tested
Compiles fine
*/

//Class unionSet contains functions to join sets (for use with mazeMaker.java)
public class unionSet {
    private int[] rank;
    private int[] parent;
    private int size; 
    private int numSets;
        
    //Constructor must recieve a size (intended size sXs for mazeMaker.java)
    public unionSet(int s) {
	size = s; 
	rank = new int[size];
	parent = new int[size];
	for (int i = 0; i < size; i++) {
	    makeSet(i);
	}
	numSets = s;
    }

    //Returns how many sets are left (numSets == 1 means all sets are joined)
    public int numSets() {
	return numSets;
    }

    //Initializes one spot in the array to "default"
    private void makeSet(int x) {
	parent[x] = x; 
	rank[x] = 1;
    }
    
    //Wrapper returns true if the sets joined 
    public boolean union(int x, int y) {
	if (link(find(x), find(y))) {
	    numSets--;
	    return true;
	}
	return false;
    }
    
    //Finds the set with that parent
    public int find(int x) {
	if (x >= 0 && x < size) {
	    if (x != parent[x]) {
		parent[x]  = find(parent[x]);
	    }
	    return parent[x];
	}
	return -1;
    }

    //Joins two sets together. Returns false if already joined or invalid argument
    private boolean link(int x, int y) {
	if (x == y || x >= size || y >= size ) {
	    return false;
	}
	if (parent[x] == parent[y]) {
	    return false;
	}
	if (rank[x] > rank[y]) {
	    parent[y] = x;
	}
	else {
	    parent[x] = y;
	}
	if (rank[x] == rank[y]) {
	    rank[y]++;
	}
	return true;
    }
}