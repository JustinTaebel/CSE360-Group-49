package team49;

public class Doctor implements Employee {
	
	final int maxPatients = 10;
	final int maxNursesPerDoctor = 2;
	String empID; //Format #####
	private Patient[] assignedPatients = new Patient[maxPatients];
	private Nurse[] assignedNurses = new Nurse[maxNursesPerDoctor];
	
	//login information
	//username is empID
	String password;
	
	
	public Doctor(String id) {
		empID = id;
		
	}

	
	public void setExamResults(Patient patient, String examResults) {
		patient.physcialExamResults = examResults;
	}
	
	public String[] generateStorageArray() {
		String[] data = new String[14];
		data[0] = empID;
		data[1] = password;
		data[2] = "Assigned Patients Data Begins";
		data[3] = assignedPatients[0].patientID;
		data[4] = assignedPatients[1].patientID;
		data[5] = assignedPatients[2].patientID;
		data[6] = assignedPatients[3].patientID;
		data[7] = assignedPatients[4].patientID;
		data[8] = assignedPatients[5].patientID;
		data[9] = assignedPatients[6].patientID;
		data[10] = assignedPatients[7].patientID;
		data[11] = assignedPatients[8].patientID;
		data[12] = assignedPatients[9].patientID;
		data[13] = "Assigned Nurses Data Begins";
		data[14] = assignedNurses[0].empID;
		data[15] = assignedNurses[1].empID;
		
		return data;
		
	}
	
	
	/*
	 * Gui methods are intended to be a launch point for different graphical elements
	 */

	//****************************GUI METHODS*****************************************	
	
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
