package team49;

import java.io.IOException;

public class Patient {
	
	//This is the amount of data members that need to be stored in text file
	final int arraySize = 19;
	
	//Patient information variables
	public String firstName, lastName, patientID, DOB, phoneNumber, insuranceInformation, pharmacyInformation, 
		   currentMedications, immunizations, currentHealthIssues, bloodPressure, currentAllergies,
		   currentHealthConcerns, physicalExamResults, currentHeight;
	int currentAge;
	public String email;
	boolean isNew = true;
	private String password;
	double currentWeight, currentTemperature;
	
	//Array for storing messages in patient inbox 
	String[] messages = new String[10];
	

	public Patient(String first, String last, String dateOfBirth, String phone, String id, String eml, int age, String pass, String data2, String data3) throws IOException {
		
		firstName = first;
		lastName = last;
		DOB = dateOfBirth;
		phoneNumber = phone;
		patientID = id;	
		currentAge = age;
		password = pass;
		email = eml;
		
	}
	

	public void setCurrentMedications(String medications) {
		currentMedications = medications;
	}
	public void setImmunizations(String immune) {
		immunizations = immune;
	}
	public void setCurrentHealthIssues(String healthIssues) {
		currentHealthIssues = healthIssues;
	}
	public void sendPatientMessage(String empID) {
		//TODO
		
	}


	
	//Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[arraySize];
		data[0] = patientID;
		data[1] = password;
		data[2] = firstName;
		data[3] = lastName;
		data[4] = DOB;
		data[5] = Integer.toString(currentAge);
		data[6] = phoneNumber;
		data[7] = insuranceInformation;
		data[8] = pharmacyInformation;
		data[9] = currentMedications;
		data[10] = immunizations;
		data[11] = currentHealthIssues;
		data[12] = Double.toString(currentWeight);
		data[13] = Double.toString(currentTemperature);
		data[14] = bloodPressure;
		data[15] = currentAllergies;
		data[16] = currentHealthConcerns;
		data[17] = physicalExamResults;
		data[18] = currentHeight;
		return data;
	}
	
}
