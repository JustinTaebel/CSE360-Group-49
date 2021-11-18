package team49;

public class Doctor {
	
	
	//login information
	String doctorEmpID, password, firstName, lastName, patientFile;
	
	
	public Doctor(String id, String pass, String first, String last, String pFile){
		doctorEmpID = id;
		password = pass;
		firstName = first;
		lastName = last;
		patientFile = pFile;
		
	}

	
	// Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[10];
		data[0] = doctorEmpID;
		data[1] = password;
		data[2] = firstName;
		data[3] = lastName;
		data[4] = patientFile;
		
		return data;
		
	}
	

}