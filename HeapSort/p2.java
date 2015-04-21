/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 2: Integer Minimum Heap and Priority Queue
Last modification 2-7-15
p2.java
This code tests the functions in intMinHeap.java
Code status: working/tested
This code compiles
*/

//testing main class
public class p2 {
    public static void main(String args[]) {
	intMinHeap heap = new intMinHeap();
	int[] startArray = {5,3,7,1,2,4,9,8,6,10};

	for (int i = 0; i < startArray.length; i++) {
	    heap.heapinsert(startArray[i]);
	}

	System.out.println("Nadia Trautwein");

	System.out.println(heap.toString());

	System.out.println("Extracted: " + heap.extractMin());
	System.out.println("Extracted: " + heap.extractMin());

	System.out.println(heap.toString());

	heap.heapinsert(1);

	System.out.println(heap.toString());

	heap.heapsort();

	System.out.println(heap.toString());

    }
}