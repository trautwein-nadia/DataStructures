/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 3: Quicksort
Last Modified: 03-07-2014
p3.java
p3 runs sortableArray code (quicksort)
Code status: working/tested
Program compiles fine
*/

import java.io.*;
import java.util.Scanner; 
//this class uses sortableArray to sort integers and outputs them with leading zeros 
//once output, all numbers will be 9 digits long
public class p3 {
    public static void main(String args[]) {
	sortableArray s = new sortableArray();
	Scanner in = new Scanner(System.in);

	while (in.hasNextInt()) {
	    s.insert(in.nextInt());
	}
	in.close();
	s.sort();
	s.print();
    }
}