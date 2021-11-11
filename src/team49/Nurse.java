package team49;

public class Nurse implements Employee{

	String nurseEmpID; //Format #####
	public String assignedDoctorEmpID;
	String selectedPatient;
	public String firstName;
	public String lastName;
	
	//login information
	//username is empID
	String password;
	
	
	
	public Nurse(String data, String data2, String data3, String data4, String data5, String data6) {
		nurseEmpID = null;
		assignedDoctorEmpID = null;
	}
	
	
	public Nurse(String id) {
		nurseEmpID = id;
	}
	
	
	public void setVitals(Patient patient, double weight, double temperature, String bp, String height) {
		
		patient.currentWeight = weight;
		patient.currentTemperature = temperature;
		patient.currentHeight = height;
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
	


	//Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[3];
		data[0] = nurseEmpID;
		data[1] = password;
		data[2] = assignedDoctorEmpID;
		
		return data;
 	}

}
