package team49;

import java.io.IOException;
import java.util.ArrayList;

public class Patient {
	
	
	//Patient information variables
	public String firstName, lastName, patientID, DOB, phoneNumber, insuranceInformation, pharmacyInformation, 
		   medications, priorImmunizations, priorHealthIssues, bloodPressure, currentAllergies,
		   currentHealthConcerns, physicalExamResults, email, messageFile, currentWeight, currentTemperature,
		   currentHeight, visitSummariesFile;
	int currentAge;
	boolean isNew = true;
	private String password;
	
	// Arraylist for messages
	ArrayList<String> messageList;
	
	ArrayList<String> visitSummariesList;
	

	public Patient(String first, String last, String dateOfBirth, String phone, String emailin, String id, int age, String pharmacy, String insurance, String pass,
			String mFile, String vFile, String med, String pImm, String pIssues) throws IOException {
		
		firstName = first;
		lastName = last;
		DOB = dateOfBirth;
		phoneNumber = phone;
		patientID = id;	
		currentAge = age;
		pharmacyInformation = pharmacy;
		insuranceInformation = insurance;
		password = pass;
		email = emailin;
		messageFile = mFile;
		messageList = new ArrayList<String>();
		visitSummariesFile = vFile;
		visitSummariesList = new ArrayList<String>();
		medications = med;
		priorImmunizations = pImm;
		priorHealthIssues = pIssues;
	}

	//Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[30];
		data[0] = patientID;
		data[1] = password;
		data[2] = firstName;
		data[3] = lastName;
		data[4] = DOB;
		data[5] = Integer.toString(currentAge);
		data[6] = phoneNumber;
		data[7] = insuranceInformation;
		data[8] = pharmacyInformation;
		data[9] = medications;
		data[10] = priorImmunizations;
		data[11] = priorHealthIssues;
		data[12] = currentWeight;
		data[13] = currentTemperature;
		data[14] = bloodPressure;
		data[15] = currentAllergies;
		data[16] = currentHealthConcerns;
		data[17] = physicalExamResults;
		data[18] = email;
		data[19] = messageFile;
		data[20] = currentHeight;
		data[21] = visitSummariesFile;
		
		return data;
	}
	
}