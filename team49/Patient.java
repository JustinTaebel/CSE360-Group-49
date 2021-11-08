package team49;





public class Patient {
	
	//This is the amount of data members that need to be stored in text file
	final int arraySize = 18;
	
	//Patient information variables
	String firstName;
	String lastName;
	String patientID;  						//Format: P#####
	String DOB;								//Format: Year-Month-Day
	String phoneNumber;
	String insuranceInformation;
	String pharmacyInformation;	
	int currentAge;
	String currentMedications;
	String immunizations;
	String currentHealthIssues;
	
	
	//login information
	String username;
	private String password;
	
	//Patient data from EnterVitals() in nurse class
	double currentWeight; 			 		//pounds
	double currentTemperature; 		 		//Fahrenheit
	String bloodPressure;					 //Systolic/Diastolic  Ex: "120/80"
	
	//Patient data from setHealthConcernsAllergies() in nurse class
	String currentAllergies;
	String currentHealthConcerns;
	

	//Patient data from setExamResults in doctor class
	String physcialExamResults;
	
	//Array for storing messages in patient inbox 
	//**TODO**
	String[] messages = new String[10];

	private String currentImmunizations;
	
	
	public Patient(String first, String last, String dateOfBirth, String phone, String id, int age) {
		
		firstName = first;
		lastName = last;
		DOB = dateOfBirth;
		phoneNumber = phone;
		patientID = id;	
		currentAge = age;
		username = lastName.substring(0, 4) + firstName.substring(0, 4) + DOB.substring(0, 4);
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
	public void setPassword(String pass) {
		password = pass;
	}
	public void sendPatientMessage(String empID) {
		//TODO
		
	}


	public String[] generateStorageArray() {
		String[] data = new String[arraySize];
		data[0] = patientID;
		data[1] = firstName;
		data[2] = lastName;
		data[3] = username;
		data[4] = password;
		data[5] = DOB;
		data[6] = Integer.toString(currentAge);
		data[7] = phoneNumber;
		data[8] = insuranceInformation;
		data[9] = pharmacyInformation;
		data[10] = currentMedications;
		data[11] = currentImmunizations;
		data[12] = currentHealthIssues;
		data[13] = Double.toString(currentWeight);
		data[14] = Double.toString(currentTemperature);
		data[15] = bloodPressure;
		data[16] = currentAllergies;
		data[17] = currentHealthConcerns;
		data[18] = physcialExamResults;
		
		return data;
	}
	
}
