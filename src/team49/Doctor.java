package team49;

import java.io.IOException;

public class Doctor implements Employee {
	
	private int maxPatients = 10;
	private int maxNursesPerDoctor = 2;
	
	private String[] assignedPatients = new String[maxPatients];
	private String[] assignedNurses = new String[maxNursesPerDoctor];
	

	
	String doctorEmpID; //Format D#####  (empId is doctors username)
	String password;
	
	public Doctor() {
		doctorEmpID = null;
	}
	public Doctor(String[] data, int patientArrayStart, int patientArrayEnd) throws IOException {
		//Constructor loads doctor data from database, and places it in the correct variables/arrays
		doctorEmpID = data[0];
		password = data[1];
		for(int i = patientArrayStart; i < patientArrayEnd; i++) {
			assignedPatients[i - patientArrayStart] = data[i];
		}
		assignedNurses[0] = data[14];
		assignedNurses[1] = data[15];
	}	
	
	


	public void setExamResults(Patient patient, String examResults) {
		patient.physicalExamResults = examResults;
	}
	public String[] getAssignedPatients() {
		return assignedPatients;
	}

	public String[] getAssignedNurses() {
		return assignedNurses;
	}
	
	
	public void addPatient(String id, int index) {
		assignedPatients[index] = id;
	}
	
	
	
	//Data Storage Format
	public String[] generateStorageArray() {
		String[] data = new String[14];
		data[0] = doctorEmpID;
		data[1] = password;
		data[2] = "Assigned Patients Data Begins";  //list begin
		data[3] = assignedPatients[0];
		data[4] = assignedPatients[1];
		data[5] = assignedPatients[2];
		data[6] = assignedPatients[3];
		data[7] = assignedPatients[4];
		data[8] = assignedPatients[5];
		data[9] = assignedPatients[6];
		data[10] = assignedPatients[7];
		data[11] = assignedPatients[8];
		data[12] = assignedPatients[9];
		data[13] = "Assigned Nurses Data Begins";  //list end
		data[14] = assignedNurses[0];
		data[15] = assignedNurses[1];
		
		return data;
		
	}
	

}
