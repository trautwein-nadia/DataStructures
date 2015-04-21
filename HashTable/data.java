/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 5: Hash Table
Last Modified: 04-12-14
data.java
Data implements Record and holds a Key and a String 
This code is working/tested
compiles fine
*/
//Class to define the actual kind of data to be stored in Hashtable
public class data implements Record {
    private int key;
    private String keyValue;

    //Default constructor 
    public data() {
	key = -1;
	keyValue = "";
    }

    //Constructor for inserting a Key number and String of information
    public data(int k, String kV) {
	key = k;
	keyValue = kV;
    }

    //Function to copy a piece of data 
    public Record clone() {
	data x = new data(); 
	x.keyValue = this.keyValue;
	x.key = this.key; 
	return x; 
    }

    //Returns the information associated with the Key
    public String toString() {
	return keyValue;
    }

    //Returns the Key
    public int getID() {
	return key;
    }

}