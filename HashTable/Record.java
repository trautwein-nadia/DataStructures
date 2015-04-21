/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 5: Hash Table
Last Modified: 04-12-14
Record.java
Record is an interface for another class (data) to implement 
This code is working/tested
compiles fine
*/
//Allows data to be stored in a hashtable
public interface Record extends Cloneable{
    public Record clone(); //Copies data
    public int getID(); //Returns the key 
}

