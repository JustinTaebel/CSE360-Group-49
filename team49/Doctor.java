package team49;

import java.io.IOException;

public class Doctor implements Employee {
	
	private int maxPatients = 10;
	private int maxNursesPerDoctor = 2;
	String doctorEmpID; //Format D#####
	private String[] assignedPatients = new String[maxPatients];
	private String[] assignedNurses = new String[maxNursesPerDoctor];
	
	//login information
	//username is empID
	String password;
	
	
	public Doctor(String id) throws IOException {
		doctorEmpID = id;
		
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
