package team49;

public class Nurse implements Employee{

	String empID; //Format #####
	Doctor currentAssignedDoctor;
	
	//login information
	//username is empID
	String password;
	
	private Patient[] assignedPatients = new Patient[currentAssignedDoctor.maxPatients];
	
	public Nurse(String id, Doctor assignedDoctor, String passwordString) {
		empID = id;
		currentAssignedDoctor = assignedDoctor;
		password = passwordString;
	}
	
	
	public void setVitals(Patient patient, double weight, double temperature, String bp) {
		
		patient.currentWeight = weight;
		patient.currentTemperature = temperature;
		if(patient.currentAge > 12) {
			patient.bloodPressure = bp;
		}else {
			patient.bloodPressure = null;
		}		
	}

	public void setHealthConcernsAllergies(Patient patient, String allergies, String healthConcerns){

		patient.currentAllergies = allergies;
		patient.currentHealthConcerns = healthConcerns;
	}
	


	public String[] generateStorageArray() {
		String[] data = new String[3];
		data[0] = empID;
		data[1] = currentAssignedDoctor.empID;
		data[2] = password;
		
		return data;
 	}

	
	/*
	 * Gui methods are intended to be a launch point for different graphical elements
	 */

	//**************************************GUI METHODS************************************************
	public void viewPatientHistory(Patient patient) {
		// TODO Auto-generated method stub
		
	}




	public void viewPatientContactInformation(Patient patient) {
		// TODO Auto-generated method stub
		
	}
	


	public void viewPreviousExamination(Patient patient) {
		// TODO Auto-generated method stub
		
	}
}
