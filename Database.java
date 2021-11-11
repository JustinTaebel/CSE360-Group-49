package team49;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Database {
	
	
	private String fileName;
	private File file;
	private FileWriter outFile;
	private Scanner inFile;
	
	
	
	/*
	 * Database should be instantiated at the same time as a the object it is associated with
	 * Doctor, Nurse, and Patient classes are still under development
	 * Author: Zachary Heidemann
	 */
	
	public Database() {
		fileName = null;
	}
	
	// constructor creates text file if one doesn't already exist
	public Database(String patientID) throws IOException {
		fileName = patientID;
		file = new File("src/team49/Database/" + fileName + ".txt");
	}
	
	
	// counts the number of lines in the text file, and returns and integer
	private int countLines() throws FileNotFoundException {
		inFile = new Scanner(new FileReader("src/team49/Database/" + fileName + ".txt"));
		int count = 0;
		while(inFile.hasNextLine()) {
			inFile.nextLine();
			count++;
		}
		inFile.close();
		return count;	
	}
	
	// takes an array as input, and writes its members to the text file
	public void dataWrite(String[] arr) throws IOException {
		clearFile();
		outFile = new FileWriter("src/team49/Database/" + fileName + ".txt");
		int fileLength = countLines();
		for(int ii = 0; ii < arr.length; ii++) {
			outFile.write(arr[ii] + "\n");
		}	
		outFile.close();
	}
	
	// reads current data in text file, assembles an array, and returns said array
	public String[] getCurrentData() throws FileNotFoundException {
		String[] currentData = new String[countLines()];
		inFile = new Scanner(new FileReader("src/team49/Database/" + fileName + ".txt"));
		for(int ii = 0; ii < currentData.length; ii++) {
			currentData[ii] = inFile.nextLine(); 
		}
		inFile.close();
		return currentData;
	}
	
	// selects a specific piece of data based on a given index and returns its string
	private String selectData(int index) throws FileNotFoundException {	
		return getCurrentData()[index];
	}
	
	
	// wipes the file and prepares to update/rewrite data
	private void clearFile() throws IOException {
		outFile = new FileWriter("src/team49/Database/" + fileName + ".txt");
		int fileLength = countLines();
		for (int ii = 0; ii <= fileLength; ii++) {
			outFile.write("");
		}	
		outFile.close();
	}
	
	public boolean checkPassword(String pass) throws FileNotFoundException {
		if (selectData(1).equals(pass)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void changeFile(String id) {
		fileName = id;
	}
	
	public String getCurrentFileName() {
		return fileName;
	}

	

}
