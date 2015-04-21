/**                                                                           
Nadia Trautwein                                                               
trautwein.nadia@gmail.com                                                     
ntrautwe                                                                      
Assignment 7: Binary Search Tree                                              
Last Modification: Saturday May 3, 2014                                       
p7.java
Code includes functions to implement a Binary Search Tree (bst.java)
Code status: Working/tested                                          
Compiles fine                                                                 
*/
import java.util.Scanner;
import java.lang.Integer;

//class uses bst.java to make a functioning binary search tree
public class p7 {
    public static void main(String args[]) {
	bst tree = new bst();
	Scanner in = new Scanner(System.in);

	
	while (in.hasNextLine()) {
	    String line = in.nextLine();

	    if (line.charAt(0) != '#') {
		if (line.equals("min")) {
		    tree.min();
		}
		else if (line.equals("max")) {
		    tree.max();
		}
		else if (line.equals("preorder")) {
		    tree.preOrder();
		}
		else if (line.equals("postorder")) {
		    tree.postOrder();
		}
		else if (line.equals("inorder")) {
		    tree.inOrder();
		}
		else {
		    String[] data = line.split(" ");
		    String s = data[0];
		    int key = Integer.parseInt(data[1]);

		    if (s.equals("delete")) {
			tree.delete(key);
		    }
		    else if (s.equals("search")) {
			tree.search(key);
		    }
		    else if (s.equals("insert")) {
			tree.insert(key);
		    }
		    else if (s.equals("predecessor")) {
			tree.predecessor(key);
		    }
		    else if (s.equals("successor")) {
			tree.successor(key);
		    }
		}
	    }
	}//end while input
    } //end main
} //end class