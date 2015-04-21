/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 8: Breadth-First Search
Last Modification: May 17, 2014
p8.java
Converts maze input and stores in an ArrayList that is passed to bfs.java for solving
Code Status: working/tested
Compiles fine
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;
		
//p8 contains main for getting/converting valid maze input
public class p8 {
    public static void main(String args[]) {
	ArrayList<Integer> input = new ArrayList<Integer>();
	Scanner in = new Scanner(System.in);
	
	while (in.hasNext()) {
	    String s = in.next().toLowerCase();
	    for (int i = 0; i < s.length(); i++) {
		int x;
		if (Character.isLetter(s.charAt(i))) {
		    x = Integer.valueOf(Integer.parseInt(s.valueOf(s.charAt(i)), 16));
		}
		else {
		    x = Integer.valueOf(s.charAt(i));
		}
		input.add(x);
	    }
	}
	bfs B = new bfs(input);
    }//end main
}//end class