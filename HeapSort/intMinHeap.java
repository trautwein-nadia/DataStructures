/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 2: Integer Minimum Heap and Priority Queue
Last modification 2-7-15
intMinHeap.java
This code includes funtions for a minimum heap 
Code status: working/tested
This code compiles 
*/
import java.util.*;

//class contains functions to make a minimum sorted heap of integers
public class intMinHeap {
    
    private int[] A;
    private int size = 0;
    private boolean heap = false;  
    private int capacity;

    //initializes the array to a capacity of 100 (zero slot is not used)
    public intMinHeap() {
	capacity = 100;
	A = new int[capacity + 1];
	heap = true; 
    }

    //returns the index of the child node on the left
    private int left(int i) {
	i = 2*i;
	return i;
    }

    //returns the index of the child node on the right
    private int right(int i) {
	i = (2*i) + 1;
	return i;
    }

    //returns the index of the above node
    private int parent(int i) {
	i = i/2;
	return i;
    }

    //takes passed index values and swaps the data in each index
    private void swap(int i, int n) {
	int temp = A[i];
	A[i] = A[n];
	A[n] = temp;
    }

    //sorts data into a heap starting at the root value passed into it
    public void heapify(int i) {
	if (i < 0 || i > size) {
	    return;
	}
	int n = indexOfSmallest(i, left(i), right(i));
	if (i != n) {
	    swap(i,n);
	    heapify(n);
	}
    }
   
    //takes a parent and its two children and returns the index storing the smallest value
    public int indexOfSmallest(int i, int left, int right) {
	/*if (!heap) { //Steve said better elsewhere?
	    buildheap();
	}
	*/
	int minIndex = i;

	if (size >= left && A[left] < A[minIndex]) { 
	    minIndex = left;
	}
	if (size >= right && A[right] < A[minIndex]) {
	    minIndex = right;
	}
	return minIndex;
    }
    
    //resizes the array 
    public void resize() {
	capacity = capacity*2;
	int[] temp = new int[capacity+1]; 
	for (int i = 1; i <= size; i++) {
	    temp[i] = A[i];
	}
	A = temp; 
    }

    //inserts the passed value into the end of the array
    public void heapinsert(int n) {
	if (!heap) {
	    buildheap();
	}
	if (size == capacity) {
	    resize();
	}
	size++;
	A[size] = n + 1; //data value increased by 1 for use in decreaseKey()
	decreaseKey(size,n);
    }
    
    //floats the last (recetly inserted) value up to its proper position
    public void decreaseKey(int s, int n) { 
	/*if (!heap) { //"okay?" "check bounds" is this not needed? should i be making sure s/n in range?
	    buildheap();
	}
	*/
	// if n+1 <= n
	if (A[s] <= n) { //if used properly, the increment in heapinsert should prevent this
	    return;
	}
	A[s] = n; 
	while (s > 1 && A[parent(s)] > A[s]) { //while parent value is greater than child (while not valid)
	    swap(s, parent(s));
	    s = parent(s);
	}
    }
    
    //returns the minimum value of the heap and removes it
    public int extractMin() {
	if (!heap) {
	    buildheap();
	}
	if (size == 0) {
	    System.err.println("Can't extract from an empty heap");
	    return -1;
	}
	int result = minimum(); 
	A[1] = A[size];
	size--;
	heapify(1);
	return result;
    }
    
    //returns the smallest value of the heap
    public int minimum() {
	if (!heap) {
	    buildheap();
	}
	if (size == 0) {
	    System.out.println("Heap is empty");
	    return -1;
	}
	int result = A[1];
	return result;
    }
    
    //takes an arbitrary array and sorts elements to validate heap property
    public void buildheap() {
	for (int i = size/2; i > 1; i--) {
	    heapify(i);
	}
	heap = true;
    }

    //makes a valid heap into a "readable" order
    public void heapsort() { 
	if (!heap) {
	    buildheap();
	}
	int temp = size;
	while (size > 0) { 
	    swap (1, size);
	    size--;
	    heapify(1);
	}

	size = temp;
	heap = false; 
    }

    //converts either a valid or nonvalid heap into a string of characters 
    public String toString() {
	String s = "";
       
	if (size == 0) {
            s = "Heap: {empty}";
            return s;
        }
	if (!heap) {
	    System.out.print("Not heap: ");
	    for (int i = 1; i <= size; i++) {
		s = s + ", " + A[i];
	    }
	}
	else {
	    System.out.print("Heap: ");
	    for (int i = 1; i <= size; i++) { 
		s = s + ", " + A[i];
	    }
	}
	s = s.substring(2);
	s = "{" + s + "}";
	return s; 
    }
}
