package team49;

public class Nurse implements Employee{
	
	//login information
	String nurseEmpID, assignedDoctorEmpID, password, firstName, lastName, patientFile;
	
	
	public Nurse(String id, String passwordString, String assignedDoctor, String first, String last, String pFile) {
		nurseEmpID = id;
		password = passwordString;
		assignedDoctorEmpID = assignedDoctor;
		firstName = first;
		lastName = last;
		patientFile = pFile;
	}

	// Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[10];
		data[0] = nurseEmpID;
		data[1] = password;
		data[2] = assignedDoctorEmpID;
		data[3] = firstName;
		data[4] = lastName;
		data[5] = patientFile;
		
		
		
		return data;
 	}

}

