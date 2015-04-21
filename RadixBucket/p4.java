/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 4: Radix/bucket sort
Last Modified: March 21, 2014
p4.java
p4 runs bucketSort code (radix/bucket sort)
Code status: working/tested
Program compiles fine
*/
import java.io.*;
import java.util.Scanner;
//this class uses bucketSort to sort integers and outputs them with leading zeros
//once output, all numbers will be 9 digits long
public class p4 {
    public static void main(String args[]) {
        bucketSort s = new bucketSort();
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            s.insert(in.nextInt());
        }
        in.close();

	s.radixBucketSort();
	//s.print();
    }
}
