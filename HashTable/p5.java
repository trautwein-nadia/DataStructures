/**
Nadia Trautwein
trautwein.nadia@gmail.com
ntrautwe
Assignment 5: Hash Table
Last Modified: 04-12-14
p5.java
p5 contains a menu with different options that uses a HashTable (hashTable.java)
This code is working/tested
compiles fine
*/

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.lang.NumberFormatException;
import java.lang.Exception;

//Class contains a main and different menu options
public class p5 {
    public static void main(String args[]) {
	hashTable H = new hashTable(178000);
	Scanner in = new Scanner(System.in);
	
	System.out.println("Please enter an option from the menu (by number)");
	System.out.println("1: Insert data from file");
	System.out.println("2: Insert single entry from keyboard");
	System.out.println("3: Delete record");
	System.out.println("4: Search for record");
	System.out.println("5: Clear table");
	System.out.println("6: Save to disk");
	System.out.println("7: Quit");

	while (in.hasNextInt()) {
	    if (in.hasNextInt()) {
		int menu = 0;
		try {
		    menu = Integer.parseInt(in.nextLine());
		}
		catch (NumberFormatException e) {
		}
		//Insert from file
		if (menu == 1) {
		    try{
			System.out.println("READ FROM FILE");
			System.out.println("Please enter the filename");
			String name = in.nextLine();
			Scanner f = new Scanner(new File(name));
			while (f.hasNextLine()) {
			    int k = f.nextInt();
			    String kV = f.nextLine();
			    data input = new data(k, kV);
			    H.insert(input);
			}
			f.close();
		    }
		    catch (Exception e){
		    }
		}
		//Insert from keyboard
		if (menu == 2) {
		    System.out.println("INSERT");
		    System.out.println("Please enter the record all on one line: ");
		    try{
			int k = in.nextInt();
			String kV = in.nextLine();
			data input = new data(k, kV);
			H.insert(input);
		    }
		    catch (NoSuchElementException e) {
		    }
		}
		//Delete
		if (menu == 3) {
		    System.out.println("DELETE");
		    System.out.println("Please enter the key value: ");
		    try {
			H.delete(in.nextInt());
		    }
		    catch (NoSuchElementException e) {
		    }
		}
		//Search
		if (menu == 4) {
		    System.out.println("SEARCH");
		    System.out.println("Please enter the key value:");
		    try {
			Record r = H.search(in.nextInt());
			if (r != null) {
			    System.out.printf("%09d",r.getID());
			    //to string r.getData()
			    System.out.print(" " + r.toString().trim());
			    System.out.println();
			}
			else {
			    System.out.println("Data not found");
			}
		    }
		    catch (NoSuchElementException e) {
		    }
		}
		//Clear table
		if (menu == 5) {
		    System.out.println("CLEARED");
		    H.clearAll();
		}
		//Save to disk
		if (menu == 6) {
		    System.out.println("SAVE TO DISK");
		    System.out.println("Please enter filename to save data to");
		    H.print(in.nextLine());
		}
		//Quit
		if (menu == 7) {
		    System.out.println("QUIT");
		    in.close();
		    System.exit(1);
		}
	    }
	}
    }
}