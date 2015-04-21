/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 5: Hash Table
Last Modified: 04-12-14
hashTable.java
hashTable is a data structure that stores information associated with a Key 
This code is working/tested
compiles fine
*/

import java.util.*;
import java.io.*;

//Class contains functions to store data information 
public class hashTable{
    private int size = 100; //default size
    private ArrayList<LinkedList<Record>> A; 
    private final double C = (Math.sqrt(5)-1)/2; 

    //default constructor (uses default size)
    public hashTable() {
	A = new ArrayList<LinkedList<Record>>(size);
	for (int i = 0; i < size; i++) {
	    A.add(new LinkedList<Record>());
	}
    }

    //constructor for if a size is specified 
    public hashTable(int n) {
	size = n;
	A = new ArrayList<LinkedList<Record>>(size);
	for (int i = 0; i < size; i++) { 
	    A.add(new LinkedList<Record>());
	}
    }

    //Writes hashTable to a specified file
    public void print(String s) {
	try{
	    Record r;
	    PrintWriter p = new PrintWriter(s);
	    for (int j = 0; j < size; j++) {
		//Iterator<Record> i = A[j].iterator();
		Iterator<Record> i = A.get(j).iterator();
		while (i.hasNext()) {
		    r = i.next();
		    p.printf("%09d", r.getID());
		    p.print(" ");
		    p.print(r.toString());
		    p.println();
		}
	    }
	    p.close();
	}
	catch (FileNotFoundException e) {
	    System.out.println("File not found");
	}
	catch (IOException e) {
	    System.out.println("IOexception");
	}
    }

    //inserts one Record (data) into the table
    public void insert(Record rec) {
	int h = hash(rec);
	A.get(h).add(rec.clone());
    }
    
    //deletes one specified Record (data) from the table
    public void delete(int key) {
	if (find(key) != null) {
	    Record r;
	    Boolean found = false;
	    //Iterator<Record> i = A[hash(key)].iterator();
	    Iterator<Record> i = A.get(hash(key)).iterator();
	    while(i.hasNext() && !found) {
		r = i.next();
		if (r.getID() == key){
		    found = true;
		}
	    }
	    i.remove(); 
	}
    }

    //Clears the entire table
    public void clearAll() {
	A = new ArrayList<LinkedList<Record>>(size);
	for (int i = 0; i < size; i++) {
	    A.add(new LinkedList<Record>());
	}
    }
    
    //Finds and returns data associated with specified key (uses private find function)
    public Record search(int key) {
	if (find(key) != null) {
	    return find(key);
	}
	else {
	    return null;
	}
    }

    //finds and returns the data in the table
    private Record find(int key) {
	Record r = null;
	Boolean found = false;
	Iterator<Record> i = A.get(hash(key)).iterator();
	while(i.hasNext() && !found) {
	    r = i.next();
	    if (r.getID() == key){
		found = true;
	    }
	}
	if (r == null) {
	    return null;
	}
	else {
	    return r.clone();
	} 
    }

    //calls hash that takes an integer (for ease of use coding)
    private int hash(Record rec) {
	return hash(rec.getID());
    }

    //takes key value associated with data and returns appropriate array index
    private int hash(int k) {
	return (int)Math.floor(size*((k*C - Math.floor(k*C))));
    }

}