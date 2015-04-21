/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 7: Binary Search Tree
Last Modification: Monday May 5, 2014
bst.java
Code includes functions to make a Binary Search Tree (BST) and modify it
Code status: Working/tested
Compiles fine
*/
//Class contains functions to make a Binary Search Tree
public class bst {
    //Class for the nodes that make up a BST
    protected class LinkNode {
	protected LinkNode left;
        protected LinkNode right;
	protected LinkNode parent;
        protected int data;

	private LinkNode(int d) {
            left = right = parent = null;
            data = d;
        }
    }
    
    LinkNode root;

    //default constructor
    public bst() {
	root = null; 
    }

    //wrapper insert class
    public void insert(int key) {
	insertBST(key);
	System.out.println("inserted " + key + ".");
    }
    
    //inserts a node with data into the tree
    private void insertBST(int key) {
	LinkNode node = new LinkNode(key);
	LinkNode prev = null;
	LinkNode temp = root;

	while (temp != null) {
	    prev = temp;
	    if (node.data < temp.data) {
		temp = temp.left;
	    }
	    else {
		temp = temp.right;
	    }
	}
	node.parent = prev; 
	if (prev == null) {
	    root = node;
	    return;
	}
	if (node.data < prev.data) {
	    prev.left = node;
	}
	else {
	    prev.right = node;
	}
    }

    //wrapper delete class includes printing 
    public void delete(int x) {
	LinkNode n = searchBST(root, x);
	if (n == null) {
	    System.out.println("delete " + x + " - not found.");
	}
	else {
	    delete(n);
	    System.out.println("deleted " + x + ".");
	}
    }

    //deletes a node from the tree
    private void delete(LinkNode n) {
	LinkNode target;
	LinkNode stranded;
	if (n == null) {
	    return;
	}

	if (n.left == null || n.right == null) {
	    target = n; //0 or 1 children
	}
	else {
	    target = successor(n); //2 children
	}
	if (target.left != null) {
	    stranded = target.left;
	}
	else {
	    stranded = target.right;
	}
	if (stranded != null) {
	    stranded.parent = target.parent;
	}
	if (target.parent == null) { 
	    root = stranded;
	}
	else if (target == target.parent.left) {
	    target.parent.left = stranded;
	}
	else {
	    target.parent.right = stranded;
	}
	if (target != n) {
	    n.data = target.data;
	}
    }

    //wrapper for searchBST includes printing
    public void search(int key) {
	LinkNode x = searchBST(root, key);
	if (x == null) {
	    System.out.println(key + " not found.");
	}
	else {
	    System.out.println(x.data + " found.");
	}
    }

    //recursively searches for a node by key value
    private LinkNode searchBST(LinkNode node, int key) {
        if (node != null && node.data == key) {
	    return node;
	}
	else if (node == null) {
	    return node;
	}
	if (key < node.data) {
	    return searchBST(node.left, key);
	}
	else {
	    return searchBST(node.right, key);
	}
    }

    //wrapper class for successor includes printing
    public void successor(int x) {
	LinkNode s = searchBST(root, x);
	LinkNode successorS = successor(s);
	if (s == null) {
	    System.out.println(x + " not in tree.");
	}
	else if (successorS == null) { 
	    System.out.println("no successor for " + x + ".");
	}
	else {
	    System.out.println(x + " successor is " + successorS.data + ".");
	}
    }

    //finds next higher value node in tree
    private LinkNode successor(LinkNode x) {
	if (x == null) {
	    return null;
	}
	if (x.right != null) {
	    return min(x.right);
	}
	LinkNode p = x.parent; 
	while (p != null && x == p.right) {
	    x = p;
	    p = p.parent;
	}
	return p;
    }

    //wrapper class for predecessor includes printing
    public void predecessor(int x) {
	LinkNode p = searchBST(root, x);
	LinkNode predecessorP = predecessor(p);
	if (p == null) {
	    System.out.println(x + " not in tree.");
	}
	else if (predecessorP == null) { 
	    System.out.println("no predecessor for " + x + ".");
	}
	else {
	    System.out.println(x + " predecessor is " + predecessorP.data + ".");
	}
    }

    //finds next lower value node in tree
    private LinkNode predecessor(LinkNode x) {
	if (x == null) {
	    return null;
	}
	if (x.left != null) {
	    return max(x.left);
	}
	LinkNode p = x.parent;
	while (p!= null && x == p.left) {
	    x = p;
	    p = p.parent;
	}
	return p;
    }

    //wrapper class for min includes printing
    public void min() {
	if (root == null) {
	    System.out.println("tree empty");
	}
	else {
	    System.out.println("min is " + min(root).data + ".");
	}
    }

    //returns smallest key value in tree
    private LinkNode min(LinkNode x) {
	if (x == null) {
	    return null;
	}
	while (x.left != null) {
	    x = x.left;
	}
	return x;
    }
    
    //wrapper class for max includes printing
    public void max() {
	if (root == null) {
	    System.out.println("tree empty");
	}
	else {
	    System.out.println("max is " + max(root).data + ".");
	}
    }

    //returns largest key value in tree
    private LinkNode max(LinkNode x) {
        if (x == null) {
            return null;
        }
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }


    //wrapper class for inOrder includes printing
    public void inOrder() {
	if (root == null) {
	    System.out.println("inorder: tree not found, please insert a value");
	}
	else {
	    System.out.println("inorder traversal:");
	    inOrder(root);
	    System.out.println();
	}
    }

    //prints tree in ascending order
    private void inOrder(LinkNode x) {
	if (x != null) {
	    inOrder(x.left);
	    System.out.print(x.data + " ");
	    inOrder(x.right);
	}
    }

    //wrapper class for preOrder includes printing
    public void preOrder() {
	if (root == null) {
            System.out.println("preorder: tree not found, please insert a value");
        }
	else {
	    System.out.println("preorder traversal:");
	    preOrder(root);
	    System.out.println();
	}	
    }
    
    //prints tree in pre-order
    private void preOrder(LinkNode x) {
	if (x != null) {
	    System.out.print(x.data + " ");
	    preOrder(x.left);
	    preOrder(x.right);
	}
    }

    //wrapper class for postorder includes printing
    public void postOrder() {
	if (root == null) {
            System.out.println("postorder: tree not found, please insert a value");
        }
	else {
	    System.out.println("postorder traversal:");
	    postOrder(root);
	    System.out.println();
	}
    }

    //prints tree in post-order
    private void postOrder(LinkNode x) {
	if (x != null) {
	    postOrder(x.left);
	    postOrder(x.right);
	    System.out.print(x.data + " ");
	}
    }
}