package team49;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class GUI extends Application {
	
	Stage window;
	Scene loginPageScene, createAccountScene, doctorSelectPatientScene, doctorScene,
			nurseSelectPatientScene, nurseScene, patientScene;
	Database database = new Database();
	Nurse nurse = new Nurse();
	Doctor doctor = new Doctor();
	String id; //current logged in user
	

	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ---------------------------------- Login Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		// ------------ Asset Definition ------------ //
		Label loginWelcomeLabel = new Label("Welcome!");
		loginWelcomeLabel.setFont(new Font("Arial", 80));
		
		Label loginSignInLabel = new Label("- Please Sign in -");
		loginSignInLabel.setFont(new Font("Arial", 30));
		
		Label loginUsernameLabel = new Label("Username:");
		loginUsernameLabel.setFont(new Font("Arial", 20));
		
		Label loginPasswordLabel = new Label("Password:");
		loginPasswordLabel.setFont(new Font("Arial", 20));
		
		TextField loginUsernameField = new TextField();
		loginUsernameField.setFont(new Font("Arial", 20));
		loginUsernameField.setPromptText("Username");
		
		TextField loginPasswordField = new TextField();
		loginPasswordField.setFont(new Font("Arial", 20));
		loginPasswordField.setPromptText("Password");
		
		Label loginFailed = new Label("Username/Password is incorrect.");
		loginFailed.setTextFill(Color.RED);
		loginFailed.setVisible(false);
		
		Button loginButton = new Button("Login");
		loginButton.setFont(new Font("Arial", 20));
		loginButton.setDefaultButton(true);
		loginButton.setOnAction(e -> {

		
		try {
			id = loginUsernameField.getText();
			database.changeFile(id);
			if(database.checkPassword(loginPasswordField.getText())) {
				if(database.getCurrentFileName().substring(0,1).equals("P")) {
					window.setScene(patientScene);
				}else if(database.getCurrentFileName().substring(0,1).equals("D")) {
					window.setScene(doctorSelectPatientScene);
					doctor.doctorEmpID = id;
				}else if(database.getCurrentFileName().substring(0,1).equals("N")) {
					nurse.nurseEmpID = id;
					window.setScene(nurseSelectPatientScene);
				}
			}else {
				loginFailed.setVisible(true);
			}
		} catch (IOException e1) {
			loginFailed.setVisible(true);
			e1.printStackTrace();
		}

});
		


		Button loginCreateButton = new Button("Create Account");
		loginCreateButton.setFont(new Font("Arial", 20));
		loginCreateButton.setOnAction(e -> {
			window.setScene(createAccountScene);

		});
		
		
		// ------------ Login Grid Pane ------------ //
		GridPane loginGrid = new GridPane();
		loginGrid.setAlignment(Pos.CENTER);
		
		loginGrid.setHgap(20);
		loginGrid.setVgap(20);
		loginGrid.setPadding(new Insets(10, 10, 10, 40));
		
		loginGrid.add(loginUsernameLabel, 1, 2);
		loginGrid.add(loginUsernameField, 2, 2);
		loginGrid.add(loginPasswordLabel, 1, 3);
		loginGrid.add(loginPasswordField, 2, 3);
		loginGrid.add(loginFailed, 2, 1);
		
		
		// ------------ Login Vbox ------------ //
		VBox loginButtonsVBox = new VBox(30);
		loginButtonsVBox.getChildren().addAll(loginButton, loginCreateButton);
		loginButtonsVBox.setAlignment(Pos.CENTER);
		
		VBox loginVBox = new VBox(10);
		loginVBox.setAlignment(Pos.CENTER);
		loginVBox.getChildren().addAll(loginWelcomeLabel, loginSignInLabel, loginGrid, loginButtonsVBox);
		loginVBox.setPadding(new Insets(10, 10, 10, 10));
		
		// ---------- Scene Default ---------- //
		loginPageScene = new Scene(loginVBox, 600, 700);
		window.setScene(loginPageScene);
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ----------------------------- Create Account Page ------------------------------ //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		// ------------ Asset Definition ------------ //
				Label CALabel = new Label("Create An Account:");
				CALabel.setFont(new Font("Arial", 30));
				
				
				Label CAFirstNameLabel = new Label("First Name");
				CAFirstNameLabel.setFont(new Font("Arial", 20));
				
				TextField CAFirstNameField = new TextField();
				CAFirstNameField.setFont(new Font("Arial", 20));
				CAFirstNameField.setPromptText("Enter First Name");
				
				Label CALastNameLabel = new Label("Last Name");
				CALastNameLabel.setFont(new Font("Arial", 20));
				
				TextField CALastNameField = new TextField();
				CALastNameField.setFont(new Font("Arial", 20));
				CALastNameField.setPromptText("Enter Last Name");
				
				Label CADateOfBirthLabel = new Label("Date of Birth");
				CADateOfBirthLabel.setFont(new Font("Arial", 20));
				
				TextField CADateOfBirthField = new TextField();
				CADateOfBirthField.setFont(new Font("Arial", 20));
				CADateOfBirthField.setPromptText("MM/DD/YYYY");
				
				Label CAPhoneNumLabel = new Label("Phone Number");
				CAPhoneNumLabel.setFont(new Font("Arial", 20));

				TextField CAPhoneNumField = new TextField();
				CAPhoneNumField.setFont(new Font("Arial", 20));
				CAPhoneNumField.setPromptText("XXX-XXX-XXXX");
				
				Label CAPasswordLabel = new Label("Password");
				CAPasswordLabel.setFont(new Font("Arial", 20));
				
				TextField CAPasswordField = new TextField();
				CAPasswordField.setFont(new Font("Arial", 20));
				CAPasswordField.setPromptText("Password");
				
				
				
				
				
				//When the Create button is pressed, patient data is written to database. Text file is named in
				//the following format P(PatientID)
				Button CACreateButton = new Button("Create");
				CACreateButton.setFont(new Font("Arial", 20));
				CACreateButton.setMinWidth(300);
				CACreateButton.setDefaultButton(true);
				CACreateButton.setOnAction(e ->{
					
					Patient newPatient = null;
					try {
						newPatient = new Patient(CAFirstNameField.getText(), CALastNameField.getText(), CADateOfBirthField.getText(), 
									CAPhoneNumField.getText(), "P" + CADateOfBirthField.getText().substring(6),
									2021 - Integer.parseInt(CADateOfBirthField.getText().substring(6)), CAPasswordField.getText());
					} catch (NumberFormatException | IOException e2) {
						e2.printStackTrace();
					}
						try {
			
							database.newPatient(newPatient.patientID);
							database.changeFile(newPatient.patientID);
							database.dataWrite(newPatient.generateStorageArray());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						CAFirstNameField.clear();
						CALastNameField.clear();
						CADateOfBirthField.clear();
						CAPhoneNumField.clear();
						CAPasswordField.clear();
						loginFailed.setVisible(false);
						window.setScene(loginPageScene);
				});
				
				
				
				
				
				Button CABackButton = new Button("Back To Login");
				CABackButton.setFont(new Font("Arial", 14));
				CABackButton.setOnAction(e -> {
					loginFailed.setVisible(false);
					window.setScene(loginPageScene);
				});
				
				
				// ------------ CAGrid ------------ //
				GridPane CAGrid = new GridPane();
				CAGrid.setAlignment(Pos.CENTER);
				CAGrid.setHgap(20);
				CAGrid.setVgap(20);
				CAGrid.setPadding(new Insets(10, 10, 10, 40));
				
				CAGrid.add(CAFirstNameLabel, 1, 1);
				CAGrid.add(CAFirstNameField, 2, 1);
				CAGrid.add(CALastNameLabel, 1, 2);
				CAGrid.add(CALastNameField, 2, 2);
				CAGrid.add(CADateOfBirthLabel, 1, 3);
				CAGrid.add(CADateOfBirthField, 2, 3);
				CAGrid.add(CAPhoneNumLabel, 1, 4);
				CAGrid.add(CAPhoneNumField, 2, 4);
				CAGrid.add(CAPasswordLabel, 1, 5);
				CAGrid.add(CAPasswordField, 2, 5);
				
				
				// ------------ CAVBox ------------ //
				VBox CAVBox = new VBox(10);
				CAVBox.setAlignment(Pos.CENTER);
				CAVBox.getChildren().addAll(CALabel, CAGrid, CACreateButton, CABackButton);
				CAVBox.setPadding(new Insets(10, 10, 10, 10));
				
				// ---------- Scene Default ---------- //
				createAccountScene = new Scene(CAVBox, 600, 700);
				
			
				
		
		
		

		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Doctor Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ===================================== Doctor Select Patient ===================================== //
		// ------------ Asset Definition ------------ //
		
		ComboBox<String> doctorPatientListCombo = new ComboBox<String>();
		doctorPatientListCombo.setPromptText("Select Patient");
		File patients = new File("src/team49/Database/");
		File[] currentPatients = patients.listFiles();
		for(int i = 0; i < currentPatients.length; i++) {
			String fileName = currentPatients[i].getName();
			if(fileName.charAt(0) == 80) {
				database.changeFile(fileName.substring(0, 5));
				String patientFirstName = database.getCurrentData()[2];
				String patientLastName = database.getCurrentData()[3];
				doctorPatientListCombo.getItems().addAll(fileName.substring(0, 5) + " - " + patientFirstName + " " + patientLastName);
			}
		}
		database.changeFile(id);

		Button doctorPatientNextButton = new Button("Next");
		doctorPatientNextButton.setFont(new Font("Arial", 14));
		doctorPatientNextButton.setOnAction(e -> {
			// currentPatient = patient
			window.setScene(doctorScene);
		});
		
		Label doctorWelcomeLabel = new Label("Hello Dr." + "(name)" + "- Which patient are you seeing today?"); 
		doctorWelcomeLabel.setFont(new Font("Arial", 20));
		
		// ----------- doctorSelectPatientGrid ---------- //
		VBox doctorSelectPatientVBox = new VBox();
		doctorSelectPatientVBox.setPadding(new Insets(40, 40, 40, 40));
		doctorSelectPatientVBox.getChildren().addAll(doctorWelcomeLabel, doctorPatientListCombo, doctorPatientNextButton);
		
		// ---------- Scene Default ---------- //
		doctorSelectPatientScene = new Scene(doctorSelectPatientVBox, 600, 700);
		
		// ================================= General doctorScene ================================= //
		
		// ---------- Assets ------- //
		Label doctorPatientNameLabel = new Label("            Patient Name");
		doctorPatientNameLabel.setFont(new Font("Arial", 20));
		
		Button doctorExamButton = new Button("Examination");
		doctorExamButton.setFont(new Font("Arial", 16));
		
		Button doctorHistoryButton = new Button("History");
		doctorHistoryButton.setFont(new Font("Arial", 16));
		
		Button doctorContactInfoButton = new Button("Contact Information");
		doctorContactInfoButton.setFont(new Font("Arial", 16));
		
		Button doctorVisitSummaryButton = new Button("Visit Summary");
		doctorVisitSummaryButton.setFont(new Font("Arial", 16));
		
		Button doctorMessagesButton = new Button("Messages");
		doctorMessagesButton.setFont(new Font("Arial", 16));
		
		Button doctorSelectDifPatientButton = new Button("Select A Different Patient");
		doctorSelectDifPatientButton.setFont(new Font("Arial", 20));
		
		// BUTTON FUNCTION AT BOTTOM OF DOCTOR PAGE //
		
		// ------------ doctorMenuVBox ----------- //
		VBox doctorMenuVBox = new VBox();
		doctorMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		doctorMenuVBox.getChildren().addAll(doctorExamButton, doctorHistoryButton, doctorContactInfoButton,
											doctorVisitSummaryButton, doctorMessagesButton);
		
		// ----------- doctorBorder ---------- //
		BorderPane doctorBorder = new BorderPane();
		doctorBorder.setPadding(new Insets(10, 10, 10, 10));
		doctorBorder.setTop(doctorPatientNameLabel);
		doctorBorder.setLeft(doctorMenuVBox);
		doctorBorder.setBottom(doctorSelectDifPatientButton);
		
		// ---------- Scene Default ------------ //
		doctorScene = new Scene(doctorBorder, 600, 700);
		
		// ===================================== Doctor Exam ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorExamLabel = new Label("Examination:");
		doctorExamLabel.setFont(new Font("Arial", 20));
		
		Label doctorExamFindingsLabel = new Label("Physical Test Findings:");
		doctorExamFindingsLabel.setFont(new Font("Arial", 16));
		
		TextField doctorPhysicalField = new TextField();
		doctorPhysicalField.setPromptText("Enter Physical Findings");
		
		Label doctorPrescriptionsLabel = new Label("Prescriptions:");
		doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
		
		TextField doctorPrescriptionsField = new TextField();
		doctorPrescriptionsField.setPromptText("Enter Prescriptions");
		
		Button doctorExamSaveButton = new Button("Save and Continue");
		doctorExamSaveButton.setFont(new Font("Arial", 20));
		
		// -------- doctorExamGrid ------- //
		GridPane doctorExamGrid = new GridPane();
		doctorExamGrid.add(doctorExamFindingsLabel, 0, 0);
		doctorExamGrid.add(doctorPhysicalField, 1, 0);
		doctorExamGrid.add(doctorPrescriptionsLabel, 0, 1);
		doctorExamGrid.add(doctorPrescriptionsField, 1, 1);
		
		// -------- doctorExamVBox ------- //
		VBox doctorExamVBox = new VBox();
		doctorExamVBox.getChildren().addAll(doctorExamLabel, doctorExamGrid, doctorExamSaveButton);
		
		// -------- doctorBorder Manipulation -------- //
		doctorBorder.setCenter(doctorExamVBox);
		
		// ===================================== Doctor History ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorPatientHistoryLabel = new Label("Patient History:");
		doctorPatientHistoryLabel.setFont(new Font("Arial", 20));
		
		Label doctorPriorHealthIssuesLabel = new Label("Prior Health Issues:");
		doctorPriorHealthIssuesLabel.setFont(new Font("Arial", 16));
		
		Label doctorPriorMedicationsLabel = new Label("Prior Medications:");
		doctorPriorMedicationsLabel.setFont(new Font("Arial", 16));
		
		Label doctorImmRecordsLabel = new Label("Immunization Records:");
		doctorImmRecordsLabel.setFont(new Font("Arial", 16));
		
		// -------- doctorHistoryVBox ------- //
		VBox doctorHistoryVBox = new VBox();
		doctorHistoryVBox.getChildren().addAll(doctorPatientHistoryLabel, doctorPriorHealthIssuesLabel,
												doctorPriorMedicationsLabel, doctorImmRecordsLabel);
		
		// ===================================== Doctor Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorContactInfoLabel = new Label("Contact Information:");
		doctorContactInfoLabel.setFont(new Font("Arial", 20));
		
		Label doctorFullNameLabel = new Label("Full Name:");
		doctorFullNameLabel.setFont(new Font("Arial", 16));
		
		Label doctorEmail = new Label("Email:");
		doctorEmail.setFont(new Font("Arial", 16));
		
		Label doctorPhoneNumber = new Label("Phone Number:");
		doctorPhoneNumber.setFont(new Font("Arial", 16));
		
		Label doctorPharmacyContactLabel = new Label("Pharmacy Contact:");
		doctorPharmacyContactLabel.setFont(new Font("Arial", 16));
		
		Label doctorInsuranceContactLabel = new Label("Insurance Contact");
		doctorInsuranceContactLabel.setFont(new Font("Arial", 16));
		
		// -------- doctorContactInfoVBox ------- //
		VBox doctorContactInfoVBox = new VBox();
		doctorContactInfoVBox.getChildren().addAll(doctorContactInfoLabel, doctorFullNameLabel, doctorEmail,
													doctorPhoneNumber, doctorPharmacyContactLabel, doctorInsuranceContactLabel);
		
		// ================================== Doctor Visit Summary ================================= //
		
		// --------- Asset Definition -------- //
		Label doctorVisitSummaryLabel = new Label("Visit Summary:");
		doctorVisitSummaryLabel.setFont(new Font("Arial", 20));
		
		TextField doctorVisitSummaryField = new TextField();
		doctorVisitSummaryField.setPromptText("Enter Summary for this Visit");
		
		Button doctorVisitSummarySaveButton = new Button("Save and Continue");
		doctorVisitSummarySaveButton.setFont(new Font("Arial", 20));
		
		// -------- patientSummariesVBox ------- //
		VBox doctorVisitSummaryVBox = new VBox();
		doctorVisitSummaryVBox.getChildren().addAll(doctorVisitSummaryLabel, doctorVisitSummaryField, doctorVisitSummarySaveButton);
		
		// ===================================== Doctor Messages ===================================== //
		
		
		// --------- Asset Definition -------- //
		Label doctorMessagesLabel = new Label("Messages:");
		doctorMessagesLabel.setFont(new Font("Arial", 20));
		
		Label doctorMessagesText = new Label("Messages to and from patient here");
		doctorMessagesText.setFont(new Font("Arial", 16));
		
		TextField doctorMessageField = new TextField();
		doctorMessageField.setPromptText("Enter Message");
		
		Button doctorSendMessageButton = new Button("Send");
		doctorSendMessageButton.setFont(new Font("Arial", 20));
		doctorSendMessageButton.setOnAction(e -> {
			// Add to messages List
			doctorMessageField.clear();
			// MAKE SURE TO REFRESH MESSAGES LABEL
		});
		
		VBox doctorMessagesVBox = new VBox();
		doctorMessagesVBox.getChildren().addAll(doctorMessagesLabel, doctorMessagesText, doctorMessageField, doctorSendMessageButton);
		
		
		// ================================== Doctor Button Functions ================================= //
		doctorExamButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorExamVBox);
		});
		doctorHistoryButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorHistoryVBox);
		});
		doctorContactInfoButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorContactInfoVBox);
		});
		doctorMessagesButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorMessagesVBox);
		});
		doctorVisitSummaryButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorVisitSummaryVBox);
		});
		doctorExamSaveButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorHistoryVBox);
			// SAVE STUFF HERE
			doctorPhysicalField.setText(doctorPhysicalField.getText());
			doctorPrescriptionsField.setText(doctorPrescriptionsField.getText());
		});
		doctorVisitSummarySaveButton.setOnAction(e -> {
			doctorBorder.setCenter(doctorMessagesVBox);
			// SAVE STUFF HERE
			doctorVisitSummaryField.setText(doctorVisitSummaryField.getText());
		});
		doctorSelectDifPatientButton.setOnAction(e -> {
			window.setScene(doctorSelectPatientScene);
		});
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Nurse Page ----------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ===================================== Nurse Select Patient ===================================== //
		// ------------ Asset Definition ------------ //
		ComboBox<String> nursePatientListCombo = new ComboBox<String>();
		nursePatientListCombo.setPromptText("Select Patient");
		
		File patientsNurse = new File("src/team49/Database/");
		File[] currentPatientsNurse = patientsNurse.listFiles();
		for(int i = 0; i < currentPatientsNurse.length; i++) {
			String fileName = currentPatientsNurse[i].getName();
			if(fileName.charAt(0) == 80) {
				database.changeFile(fileName.substring(0, 5));
				String patientFirstNameNurse = database.getCurrentData()[2];
				String patientLastNameNurse = database.getCurrentData()[3];
				nursePatientListCombo.getItems().addAll(fileName.substring(0, 5) + " - " + patientFirstNameNurse + " " + patientLastNameNurse);
			}
		}
		database.changeFile(id);
		Button nursePatientNextButton = new Button("Next");
		nursePatientNextButton.setFont(new Font("Arial", 14));
		
		
		nursePatientNextButton.setOnAction(e -> {
			nurse.selectedPatient = nursePatientListCombo.getValue(); 
			if(nurse.selectedPatient != null) {
				window.setScene(nurseScene);
				String[] data = new String[2];
				database.changeFile("pageFile");
				data[0] = nurse.selectedPatient;
				data[1] = id;
				try {
					database.dataWrite(data);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//-------------------------------------------------------------------------------------------
		//data gets wiped at this point, so data was saved to database and retrived to avoid data loss
		Database database = new Database("pageFile");
		String[] data = database.getCurrentData();
		
		
		
		
		
		Label nurseWelcomeLabel = new Label("Hello " + "" + " - Which patient are you seeing today?"); 
		nurseWelcomeLabel.setFont(new Font("Arial", 20));
		
		

		// ----------- nurseSelectPatientVBox ---------- //
		VBox nurseSelectPatientVBox = new VBox();
		nurseSelectPatientVBox.setPadding(new Insets(40, 40, 40, 40));
		nurseSelectPatientVBox.getChildren().addAll(nurseWelcomeLabel, nursePatientListCombo, nursePatientNextButton);
		
		// ---------- Scene Default ---------- //
		nurseSelectPatientScene = new Scene(nurseSelectPatientVBox, 600, 700);
		
		// ================================= General nurseScene ================================= //
		// ---------- Assets ------- //
		
		Button nurseVitalsButton = new Button("Vitals");
		nurseVitalsButton.setFont(new Font("Arial", 16));
		
		Button nurseHealthConcernsButton = new Button("Patient Health");
		nurseHealthConcernsButton.setFont(new Font("Arial", 16));
		
		Button nursePatientHistoryButton = new Button("Patient History");
		nursePatientHistoryButton.setFont(new Font("Arial", 16));
		
		Button nurseContactInfoButton = new Button("Contact Information");
		nurseContactInfoButton.setFont(new Font("Arial", 16));
		
		Button nurseMessagesButton = new Button("Messages");
		nurseMessagesButton.setFont(new Font("Arial", 16));
		
		
		// BUTTON FUNCTION AT BOTTOM OF NURSE PAGE //
		
		// ------------ nurseMenuVBox ----------- //
		VBox nurseMenuVBox = new VBox();
		nurseMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseMenuVBox.getChildren().addAll(nurseVitalsButton, nurseHealthConcernsButton, nursePatientHistoryButton,
											nurseContactInfoButton, nurseMessagesButton);
		
		// ----------- nurseBorder ---------- //
		BorderPane nurseBorder = new BorderPane();
		nurseBorder.setPadding(new Insets(10, 10, 10, 10));
		nurseBorder.setLeft(nurseMenuVBox);
		// ---------- Scene Stuff ------------ //
		nurseScene = new Scene(nurseBorder, 600, 700);
		
		// ===================================== Nurse Vitals ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseVitalsLabel = new Label("Enter Vitals:");
		nurseVitalsLabel.setFont(new Font("Arial", 30));
		
		Label nurseWeightLabel = new Label("Weight:");
		nurseWeightLabel.setFont(new Font("Arial", 18));
		
		TextField nurseWeightField = new TextField();
		nurseWeightField.setPromptText("Enter Weight");
		
		Label nurseHeightLabel = new Label("Height:");
		nurseHeightLabel.setFont(new Font("Arial", 18));
		
		TextField nurseHeightField = new TextField();
		nurseHeightField.setPromptText("Enter Height");
		
		Label nurseBodyTempLabel = new Label("Body Temperature:");
		nurseBodyTempLabel.setFont(new Font("Arial", 18));
		
		TextField nurseBodyTempField = new TextField();
		nurseBodyTempField.setPromptText("Enter Body Temperature");
		
		Label nurseOver12Label = new Label("Patient is over 12?");
		nurseOver12Label.setFont(new Font("Arial", 18));
		
		CheckBox nurseOver12Check = new CheckBox();
		
		Label nurseBloodPressureLabel = new Label("Blood Pressure:");
		nurseBloodPressureLabel.setFont(new Font("Arial", 18));
		
		TextField nurseBloodPressureField = new TextField();
		nurseBloodPressureField.setPromptText("Enter Blood Pressure");
		
		Button nurseVitalsSaveButton = new Button("Save and Continue");
		nurseVitalsSaveButton.setFont(new Font("Arial", 20));
		
		
		// ----------- nurseVitalsGrid ---------- //
		GridPane nurseVitalsGrid = new GridPane();
		nurseVitalsGrid.setPadding(new Insets(40, 40, 40, 40));
		nurseVitalsGrid.add(nurseWeightLabel, 0, 0);
		nurseVitalsGrid.add(nurseWeightField, 1, 0);
		nurseVitalsGrid.add(nurseHeightLabel, 0, 1);
		nurseVitalsGrid.add(nurseHeightField, 1, 1);
		nurseVitalsGrid.add(nurseBodyTempLabel, 0, 2);
		nurseVitalsGrid.add(nurseBodyTempField, 1, 2);
		nurseVitalsGrid.add(nurseOver12Label, 0, 3);
		nurseVitalsGrid.add(nurseOver12Check, 1, 3);
		nurseVitalsGrid.add(nurseBloodPressureLabel, 0, 4);
		nurseVitalsGrid.add(nurseBloodPressureField, 1, 4);
		
		
		// ----------- nurseVitalsVBox ---------- //
		VBox nurseVitalsVBox = new VBox();
		nurseVitalsVBox.setPadding(new Insets(40, 40, 40, 40));
		nurseVitalsVBox.getChildren().addAll(nurseVitalsLabel, nurseVitalsGrid, nurseVitalsSaveButton);
		
		// -------- nurseBorder Manipulation -------- //
		nurseBorder.setCenter(nurseVitalsVBox);
		
		
		// ===================================== Nurse Health Concerns ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseHealthConernsLabel = new Label("Patient Health:");
		nurseHealthConernsLabel.setFont(new Font("Arial", 30));
		
		Label nurseAllergiesLabel = new Label("Known Allergies:");
		nurseAllergiesLabel.setFont(new Font("Arial", 18));
		
		TextField nurseAllergiesField = new TextField();
		nurseAllergiesField.setPromptText("Enter known allergies");
		
		Label nurseKnownConcernsLabel = new Label("Known Concerns:");
		nurseKnownConcernsLabel.setFont(new Font("Arial", 18));
		
		TextField nurseKnownConcernsField = new TextField();
		nurseKnownConcernsField.setPromptText("Enter known concerns");
		
		Button nurseConcernsSaveButton = new Button("Save and Continue");
		nurseConcernsSaveButton.setFont(new Font("Arial", 20));
		
		// ----------- nurseConcernsGrid ---------- //
		GridPane nurseConcernsGrid = new GridPane();
		nurseConcernsGrid.add(nurseAllergiesLabel, 0, 0);
		nurseConcernsGrid.add(nurseAllergiesField, 1, 0);
		nurseConcernsGrid.add(nurseKnownConcernsLabel, 0, 1);
		nurseConcernsGrid.add(nurseKnownConcernsField, 1, 1);
		
		// ----------- nurseConcernsVBox ---------- //
		VBox nurseConcernsVBox = new VBox();
		nurseConcernsVBox.setPadding(new Insets(40, 40, 40, 40));
		nurseConcernsVBox.getChildren().addAll(nurseHealthConernsLabel, nurseConcernsGrid, nurseConcernsSaveButton);
		
		// ===================================== Nurse Patient History ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseHistoryLabel = new Label("Patient History:");
		nurseHistoryLabel.setFont(new Font("Arial", 30));
		
		Label nurseHealthIssuesLabel = new Label("Prior Health Issues:");
		nurseHealthIssuesLabel.setFont(new Font("Arial", 18));
		
		Label nurseMedicationsLabel = new Label("Prior Medications:");
		nurseMedicationsLabel.setFont(new Font("Arial", 18));
		
		Label nurseImmRecordsLabel = new Label("Immunization Records:");
		nurseImmRecordsLabel.setFont(new Font("Arial", 18));
		
		
		// ----------- nurseHistoryVBox ---------- //
		VBox nurseHistoryVBox = new VBox();
		nurseHistoryVBox.setPadding(new Insets(40, 40, 40, 40));
		nurseHistoryVBox.getChildren().addAll(nurseHistoryLabel, nurseHealthIssuesLabel, nurseMedicationsLabel,
												nurseImmRecordsLabel);
		
		// ===================================== Nurse Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label nurseContactInfoLabel = new Label("Contact Information:");
		nurseContactInfoLabel.setFont(new Font("Arial", 20));
		
		Label nurseFullNameLabel = new Label("Full Name:");
		nurseFullNameLabel.setFont(new Font("Arial", 16));
		
		Label nurseEmail = new Label("Email:");
		nurseEmail.setFont(new Font("Arial", 16));
		
		Label nursePhoneNumber = new Label("Phone Number:");
		nursePhoneNumber.setFont(new Font("Arial", 16));
		
		Label nursePharmacyContactLabel = new Label("Pharmacy Contact:");
		nursePharmacyContactLabel.setFont(new Font("Arial", 16));
		
		Label nurseInsuranceContactLabel = new Label("Insurance Contact");
		nurseInsuranceContactLabel.setFont(new Font("Arial", 16));
		
		// -------- doctorContactInfoVBox ------- //
		VBox nurseContactInfoVBox = new VBox();
		nurseContactInfoVBox.getChildren().addAll(nurseContactInfoLabel, nurseFullNameLabel, nurseEmail,
													nursePhoneNumber, nursePharmacyContactLabel, nurseInsuranceContactLabel);
		
		// ===================================== Nurse Messages ===================================== //
		
		// --------- Asset Definition -------- //
		Label nurseMessagesLabel = new Label("Messages:");
		nurseMessagesLabel.setFont(new Font("Arial", 20));
		
		Label nurseMessagesText = new Label("Messages to and from patient here");
		nurseMessagesText.setFont(new Font("Arial", 16));
		
		TextField nurseMessageField = new TextField();
		nurseMessageField.setPromptText("Enter Message");
		
		Button nurseSendMessageButton = new Button("Send");
		nurseSendMessageButton.setFont(new Font("Arial", 20));
		nurseSendMessageButton.setOnAction(e -> {
			// Add to messages List
			nurseMessageField.clear();
			// MAKE SURE TO REFRESH MESSAGES LABEL
		});
		
		VBox nurseMessagesVBox = new VBox();
		nurseMessagesVBox.getChildren().addAll(nurseMessagesLabel, nurseMessagesText, nurseMessageField, nurseSendMessageButton);
		
		// ================================== Nurse Button Functions ================================= //
		nurseVitalsButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseVitalsVBox);
		});
		nurseHealthConcernsButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseConcernsVBox);
		});
		nursePatientHistoryButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseHistoryVBox);
		});
		nurseContactInfoButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseContactInfoVBox);
		});
		nurseMessagesButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseMessagesVBox);
		});
		nurseVitalsSaveButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseConcernsVBox);
			// SAVE STUFF
			String[] names = null;
			try {
				names = database.getCurrentData();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			database.changeFile(names[0].substring(0,5));
			
			String[] patientData = null;
			try {
				patientData = database.getCurrentData();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
		
			String weight, height, bodyTemp, bloodPressure;
			weight = nurseWeightField.getText();
			height = nurseHeightField.getText();
			bodyTemp = nurseBodyTempField.getText();
			bloodPressure = nurseBloodPressureField.getText();
			
			try {
				Patient currentPatient = new Patient(patientData[2], patientData[3], patientData[4], patientData[6],
						patientData[0], Integer.parseInt(patientData[4].substring(6)), data[1]);
				Nurse currentNurse = new Nurse(names[1]);
				currentNurse.setVitals(currentPatient, Double.parseDouble(weight), Double.parseDouble(bodyTemp), bloodPressure, height);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			
			
			
			
			nurseWeightField.setPromptText(nurseWeightField.getText());
			nurseHeightField.setPromptText(nurseHeightField.getText());
			nurseBodyTempField.setPromptText(nurseBodyTempField.getText());
			nurseBloodPressureField.setPromptText(nurseBloodPressureField.getText());
			
			
			
			
			
		});
		nurseConcernsSaveButton.setOnAction(e -> {
			nurseBorder.setCenter(nurseHistoryVBox);
			// SAVE STUFF
			nurseAllergiesField.setPromptText(nurseAllergiesField.getText());
			nurseKnownConcernsField.setPromptText(nurseKnownConcernsField.getText());
		});
		

		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// -------------------------------- Patient Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ================================= General patientScene ================================= //
		
		// ---------- Assets ------- //
		Label patientNameLabel = new Label("            Patient Name");
		patientNameLabel.setFont(new Font("Arial", 20));
		
		Button patientContactInfoButton = new Button("Contact Information");
		patientContactInfoButton.setFont(new Font("Arial", 16));
		
		Button patientVisitSummariesButton = new Button("Visit Summaries");
		patientVisitSummariesButton.setFont(new Font("Arial", 16));
		
		Button patientMessagesButton = new Button("Messages");
		patientMessagesButton.setFont(new Font("Arial", 16));
		
		// BUTTON FUNCTION AT BOTTOM OF PATIENT PAGE //
		
		// ------------ nurseMenuVBox ----------- //
		VBox patientMenuVBox = new VBox();
		patientMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		patientMenuVBox.getChildren().addAll(patientContactInfoButton, patientVisitSummariesButton, patientMessagesButton);
		
		// ----------- nurseBorder ---------- //
		BorderPane patientBorder = new BorderPane();
		patientBorder.setPadding(new Insets(10, 10, 10, 10));
		patientBorder.setTop(patientNameLabel);
		patientBorder.setLeft(patientMenuVBox);
		
		// ---------- Scene Default ------------ //
		patientScene = new Scene(patientBorder, 600, 700);
		
		// ===================================== Patient Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label patientContactInfoLabel = new Label("Contact Information:");
		patientContactInfoLabel.setFont(new Font("Arial", 20));
		
		Label patientFullNameLabel = new Label("Full Name:");
		patientFullNameLabel.setFont(new Font("Arial", 16));
		
		TextField patientFullNameField = new TextField("Patient Full Name Here");
		
		Label patientEmailLabel = new Label("Email:");
		patientEmailLabel.setFont(new Font("Arial", 16));
		
		TextField patientEmailField = new TextField("Patient Email Here");
		
		Label patientPhoneNumber = new Label("Phone Number:");
		patientPhoneNumber.setFont(new Font("Arial", 16));
		
		TextField patientPhoneNumberField = new TextField("Patient Phone Number Here");
		
		Label patientPharmacyLabel = new Label("Pharmacy:");
		patientPharmacyLabel.setFont(new Font("Arial", 16));
		
		TextField patientPharmacyField = new TextField("Patient Pharmacy Here");
		
		Label patientInsuranceLabel = new Label("Insurance:");
		patientInsuranceLabel.setFont(new Font("Arial", 16));
		
		TextField patientInsuranceField = new TextField("Patient Insurance Here");
		
		Button patientContactInfoSaveButton = new Button("Save and Continue");
		patientContactInfoSaveButton.setFont(new Font("Arial", 20));
		patientContactInfoSaveButton.setOnAction(e ->{ 
			
		});
		
		// -------- patientContactInfoGrid ------- //
		GridPane patientContactInfoGrid = new GridPane();
		patientContactInfoGrid.add(patientFullNameLabel, 0, 0);
		patientContactInfoGrid.add(patientFullNameField, 1, 0);
		patientContactInfoGrid.add(patientEmailLabel, 0, 1);
		patientContactInfoGrid.add(patientEmailField, 1, 1);
		patientContactInfoGrid.add(patientPhoneNumber, 0, 2);
		patientContactInfoGrid.add(patientPhoneNumberField, 1, 2);
		patientContactInfoGrid.add(patientPharmacyLabel, 0, 3);
		patientContactInfoGrid.add(patientPharmacyField, 1, 3);
		patientContactInfoGrid.add(patientInsuranceLabel, 0, 4);
		patientContactInfoGrid.add(patientInsuranceField, 1, 4);
		
		// -------- patientContactInfoVBox ------- //
		VBox patientContactInfoVBox = new VBox();
		patientContactInfoVBox.getChildren().addAll(patientContactInfoLabel, patientContactInfoGrid, patientContactInfoSaveButton);
		
		// -------- Scene Default -------- //
		patientBorder.setCenter(patientContactInfoVBox);
		
		// ================================== Patient Visit Summaries ================================= //
		
		// --------- Asset Definition -------- //
		Label patientVisitSummariesTitleLabel = new Label("Visit Summaries:");
		patientVisitSummariesTitleLabel.setFont(new Font("Arial", 20));
		
		Label patientVisitSummariesLabel = new Label("Load Visit Summaries Here");
		patientVisitSummariesLabel.setFont(new Font("Arial", 16));
		
		// -------- patientSummariesVBox ------- //
		VBox patientVisitSummariesVBox = new VBox();
		patientVisitSummariesVBox.getChildren().addAll(patientVisitSummariesTitleLabel, patientVisitSummariesLabel);
		
		// ===================================== Patient Messages ===================================== //
		
		// --------- Asset Definition -------- //
		Label patientMessagesLabel = new Label("Messages:");
		patientMessagesLabel.setFont(new Font("Arial", 20));
		
		Label patientMessagesText = new Label("Messages to and from doctors/Nurses here");
		patientMessagesText.setFont(new Font("Arial", 16));
		
		TextField patientMessageField = new TextField();
		patientMessageField.setPromptText("Enter Message");
		
		Button patientSendMessageButton = new Button("Send");
		patientSendMessageButton.setFont(new Font("Arial", 20));
		patientSendMessageButton.setOnAction(e -> {
			// Add to messages List
			patientMessageField.clear();
			// MAKE SURE TO REFRESH MESSAGES LABEL
		});
		
		VBox patientMessagesVBox = new VBox();
		patientMessagesVBox.getChildren().addAll(patientMessagesLabel, patientMessagesText, patientMessageField, patientSendMessageButton);
		
		// ================================== Patient Button Functions ================================= //
		patientContactInfoButton.setOnAction(e -> {
			patientBorder.setCenter(patientContactInfoVBox);
		});
		patientVisitSummariesButton.setOnAction(e -> {
			patientBorder.setCenter(patientVisitSummariesVBox);
		});
		patientMessagesButton.setOnAction(e -> {
			patientBorder.setCenter(patientMessagesVBox);
		});
		patientContactInfoSaveButton.setOnAction(e -> {
			patientBorder.setCenter(patientVisitSummariesVBox);
			// SAVE STUFF
			patientFullNameField.setText(patientFullNameField.getText());
			patientEmailField.setText(patientEmailField.getText());
			patientPhoneNumberField.setText(patientPhoneNumberField.getText());
			patientInsuranceField.setText(patientInsuranceField.getText());
			
		});
		

		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ------------------------------------ Main -------------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		window.show();
	}
	
	
	
}
