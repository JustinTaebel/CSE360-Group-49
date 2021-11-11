package team49;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Database {
	
	final private int maxPatientsSupported = 20;
	private String fileName;
	private File file;
	private FileWriter outFile;
	private Scanner inFile;
	private String[] currentPatientIDs = new String[maxPatientsSupported];
	final private String[] currentDoctors = {"D32452","D44421"};
	final private String[] currentNurses = {"N99891", "N11111", "N19943", "N20001"};
	public int patientArrayStart = 3; //inclusive, this is the assigned patients location in doctor data file
	public int patientArrayEnd = 13;	 //exclusive
	
	
	/* NOTES
	 * Database class handles writing patient, doctor and nurse data to a text file.
	 * The dataWrite() function expects array of data in the **correct order** (correct order can be found in each respective 
	 * class).
	 * **Only one database object is necessary as the open file can be changed on the fly**
	 * Author: Zachary Heidemann
	 */
	
	public Database() {
		fileName = null;

	}
	
	
	public Database(String patientID) throws IOException {
		//constructor creates text file if one doesn't already exist
		//Create account calls this constructor to create a new patient file
		fileName = patientID;
		file = new File("src/team49/Database/" + fileName + ".txt");
	}
	
	
	//counts the number of lines in the text file, and returns and integer
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
	
	
	public void dataWrite(String[] arr) throws IOException {
		//takes an array as input, and writes its members to the text file
		clearFile();
		outFile = new FileWriter("src/team49/Database/" + fileName + ".txt");
		int fileLength = countLines();
		for(int ii = 0; ii < arr.length; ii++) {
			outFile.write(arr[ii] + "\n");
		}	
		outFile.close();
	}
	
	
	public String[] getCurrentData() throws FileNotFoundException {
		//reads current data in text file, assembles an array, and returns said array
		String[] currentData = new String[countLines()];
		inFile = new Scanner(new FileReader("src/team49/Database/" + fileName + ".txt"));
		for(int ii = 0; ii < currentData.length; ii++) {
			currentData[ii] = inFile.nextLine(); 
		}
		inFile.close();
		return currentData;
	}
	
	
	private String selectData(int index) throws FileNotFoundException {	
		//selects a specific piece of data based on a given index and returns its string
		return getCurrentData()[index];
	}
	
	
	
	private void clearFile() throws IOException {
		//wipes the file and prepares to update/rewrite data
		outFile = new FileWriter("src/team49/Database/" + fileName + ".txt");
		int fileLength = countLines();
		for(int ii = 0; ii <= fileLength; ii++) {
			outFile.write("");
		}	
		outFile.close();
	}
	
	public boolean checkPassword(String pass) throws FileNotFoundException {
		//checks password against current open file
		if(selectData(1).equals(pass)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void changeFile(String id) {
		fileName = id;
	}
	
	public String getCurrentFileName() {
		//returns the current open file
		return fileName;
	}
	
	public String[] getCurrentPatients() {
		return currentPatientIDs;
	}
	
	public boolean newPatient(String patientID) {
		//adds new patient ID to array of patient IDs
		//necessary for simple patient data retrieval
		for(int i = 0; i < currentPatientIDs.length; i++) {
			if (currentPatientIDs[i] == null) {
				currentPatientIDs[i] = patientID;
				return true;
			}
		}
		return false;
	}


	

}
