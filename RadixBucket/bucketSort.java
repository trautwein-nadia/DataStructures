/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 4: Radix/bucket sort
Last Modified: March 21, 2014
bucketSort.java
bucketSort uses a radix/bucket sort hybrid to output numbers in order
Code status: working/tested
Program compiles fine
*/
import java.util.*;
//class includes functions to sort data (and other helper functions)
public class bucketSort {
    private ArrayList<Integer> A; 
    private int size; //size of A
    private int maxLength = 9; //maximum length of a digits possible (in an input number)
    private int range = 10; //number of buckets (you count 0)

    public bucketSort() {
	A = new ArrayList<Integer>();
	size = 0;
    }

    //for inserting data into A from p4
    public void insert(int x) {
	A.add(x);
	size++; 
    }
    
    //for outputting data from A (for use in p4)
    public void print() {
	for (int i = 0; i < size; i++) {
	    System.out.printf("%09d", A.get(i));
	    System.out.println();
	}
    }

    //sorts data into buckets, eventually giving desired sorted output to A
    public void radixBucketSort() {
	ArrayList<ArrayList<Integer>>  bucket = new ArrayList<ArrayList<Integer>>();
	for (int i = 0; i < range; i++) { //initializes bucket with "tiny buckets"
	    bucket.add(new ArrayList<Integer>());
	}
	for (int dataIndex = 1; dataIndex <= maxLength; dataIndex++) { //num loop (i)
	    for (int Aindex = 0; Aindex < size; Aindex++) { //loop A to get each num (x)
		int r = (int)(A.get(Aindex)/(Math.pow(10, dataIndex -1))) % 10; //(A[x]/(10^i-1))%10
		bucket.get(r).add(A.get(Aindex)); //put it in proper tiny bucket
	    }
	    A.clear(); 
	    for (int i = 0; i < range; i++) { //loops through bucket
		for (int j = 0; j < bucket.get(i).size(); j++) { //loops through tiny bucket
		    A.add(bucket.get(i).get(j));		   
		}
		bucket.get(i).clear();
	    }
	}
    }
}