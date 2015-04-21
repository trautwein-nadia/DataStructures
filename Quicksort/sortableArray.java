/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 3: Quicksort
Last Modified: 03-07-2014
sortableArray.java
Quicksort code sorts integers in ascending order
Code status: working/tested
Program compiles fine
*/
//class allows integer input into an array that is sorted with quicksort (median of 3)
public class sortableArray { 
    private int[] A;
    private int capacity;
    private int size;

    //constructor sets array capacity
    public sortableArray() {
	capacity = 10;
	A = new int[capacity];
    }

    //wrapper class for quicksort
    public void sort(){
	quicksort(0, size - 1); 
    }
    
    //recursively sorts smaller and smaller partitions
    private void quicksort(int left, int right) {
	if (left < right) {
	    int key = partition(left, right);
	    quicksort(left, key - 1);
	    quicksort(key + 1, right);
	}
    }

    //uses a right or median pivot, this separates the array into smaller sorted sections
    private int partition(int left, int right) {
	int count = left - 1; //marks region of values less than pivot
	int pivot; 
	if (right - left > 3) { 
	    int pivotIndex = median3(left,right); //returns index
	    pivot = A[pivotIndex]; //pivot is a VALUE
	    swap(pivotIndex,right);
	}
	else {
	    pivot = A[right];
	}
	for (int j = left; j < right; j++) {
	    if (A[j] <= pivot) {
		count++;
		swap(count, j);
	    }
	}
	swap(count+1, right);
	return count + 1;
    }

    /*
    private ? insertionSort(int left, int right) {
	for (int i = left, i <= right) {
	    
	}
    }
    */

    //takes left and right indexes, finds the middle index, and compares their values to 
    //find the median value. Returns median INDEX.
    private int median3(int l, int r) { //left and right are indexes
	int m = (l + r)/2; //m is the middle index
	
	if (A[l] <= A[m] && A[m] <= A[r] || A[r] <= A[m] && A[m] <= A[l]) { //l<m<r || r<m<l
	    return m;
	}
	if (A[r] <= A[l] && A[l] <= A[m] || A[m] <= A[l] && A[l] <= A[r]) { // r<l<m || m<l<r
	    return l;
	}
	return r;
    }

    //makes two values trade places in the array
    private void swap(int i, int n) {
        int temp = A[i];
        A[i] = A[n];
        A[n] = temp;
    }
    
    //resizes the array
    private void resize() {
        capacity = capacity*2;
        int[] temp = new int[capacity];
        for (int i = 0; i <= size; i++) {
            temp[i] = A[i];
        }
        A = temp;
    }

    //inserts the passed value into the array (for initial use)
    public void insert(int n) {
	if (size == capacity - 1) {
            resize();
        }
        A[size] = n;
	size++;
    }

    //converts either a valid or nonvalid heap into a string of characters
    public void print(){ 
        if (size == 0) {
            System.out.println("Array is empty!");
        }
	for (int i = 0; i <= size - 1; i++) {
	    System.out.printf("%09d", A[i]);
	    System.out.println();
	}
    }
}