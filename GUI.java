package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


// GUI/Main for CSE360 Hospital Project Implementation

public class GUI extends Application {
	
	Stage window;
	Scene loginPageScene, createAccountScene, createAccountExtensionScene, doctorSelectPatientScene, doctorScene,
			nurseSelectPatientScene, nurseScene, patientScene;
	Database database = new Database();
	Patient currentPatient;
	Nurse currentNurse;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Nurse Page ----------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ===================================== Nurse Select Patient ===================================== //
		// ------------ Asset Definition ------------ //
		ComboBox<String> nursePatientListCombo = new ComboBox<String>();
		nursePatientListCombo.setPromptText("Select Patient");
		// for patient in patientList:
		// doctorPatientListCombo.add(patient.getName());
		nursePatientListCombo.getItems().addAll("George Person");

		Button nursePatientNextButton = new Button("Next");
		nursePatientNextButton.setFont(new Font("Arial", 14));
		nursePatientNextButton.setOnAction(e -> {
			// currentPatient = patient
			window.setScene(nurseScene);
		});
		
		Label nurseWelcomeLabel1 = new Label("Hello (name) - Which patient are you seeing today?"); 
		nurseWelcomeLabel1.setFont(new Font("Arial", 20));
		
		Label nurseWelcomeLabel2 = new Label("Hello (name) - Which patient are you seeing today?"); 
		nurseWelcomeLabel2.setFont(new Font("Arial", 20));
		
		// ----------- nurseSelectPatientVBox ---------- //
		VBox nurseSelectPatientVBox = new VBox();
		nurseSelectPatientVBox.setPadding(new Insets(40, 40, 40, 40));
		nurseSelectPatientVBox.getChildren().addAll(nurseWelcomeLabel1, nurseWelcomeLabel2, nursePatientListCombo, nursePatientNextButton);
		
		// ---------- Scene Default ---------- //
		nurseSelectPatientScene = new Scene(nurseSelectPatientVBox, 600, 700);
		
		// ================================= General nurseScene ================================= //
		
		// ---------- Assets ------- //
		Label nursePatientNameLabel = new Label("            Patient Name");
		nursePatientNameLabel.setFont(new Font("Arial", 20));
		
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
		
		Button nurseSelectDifPatientButton = new Button("Select A Different Patient");
		nurseSelectDifPatientButton.setFont(new Font("Arial", 20));
		
		// BUTTON FUNCTION AT BOTTOM OF NURSE PAGE //
		
		// ------------ nurseMenuVBox ----------- //
		VBox nurseMenuVBox = new VBox();
		nurseMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseMenuVBox.getChildren().addAll(nurseVitalsButton, nurseHealthConcernsButton, nursePatientHistoryButton,
											nurseContactInfoButton, nurseMessagesButton);
		
		// ----------- nurseBorder ---------- //
		BorderPane nurseBorder = new BorderPane();
		nurseBorder.setPadding(new Insets(10, 10, 10, 10));
		nurseBorder.setTop(nursePatientNameLabel);
		nurseBorder.setLeft(nurseMenuVBox);
		nurseBorder.setBottom(nurseSelectDifPatientButton);
		
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
			// SAVE STUFFF
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
		
		nurseSelectDifPatientButton.setOnAction(e -> {
			window.setScene(nurseSelectPatientScene);
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
		
		Label loginWrongInfoLabel = new Label("");
		loginWrongInfoLabel.setFont(new Font("Arial", 20));
		
		Button loginButton = new Button("Login");
		loginButton.setFont(new Font("Arial", 20));
		loginButton.setDefaultButton(true);
		loginButton.setOnAction(e -> {

			database.changeFile(loginUsernameField.getText());
			try {
				if (database.checkPassword(loginPasswordField.getText())) {
					if (database.getCurrentFileName().substring(0,1).equals("P")) {
						String[] data = database.getCurrentData();
						try {
							// Create patient and load data into it
							currentPatient = new Patient(data[2], data[3], data[4], data[6], data[18], data[0], Integer.parseInt(data[5]), data[8], data[7], data[1]);
							// Update text on Patient page contact info
							patientNameLabel.setText(currentPatient.firstName + " " + currentPatient.lastName);
							patientFullNameField.setText(currentPatient.firstName + " " + currentPatient.lastName);
							patientEmailField.setText(currentPatient.email);
							patientPhoneNumberField.setText(currentPatient.phoneNumber);
							patientPharmacyField.setText(currentPatient.pharmacyInformation);
							patientInsuranceField.setText(currentPatient.insuranceInformation);
							
						} catch (NumberFormatException | IOException e1) {
							System.out.println("Error loading in patient information in GUI");
						}
						window.setScene(patientScene);
						
					} else if (database.getCurrentFileName().substring(0,1).equals("D")) {
						window.setScene(doctorSelectPatientScene);
						
					} else if (database.getCurrentFileName().substring(0,1).equals("N")) {
						String[] data = database.getCurrentData();
						// Create nurse and load data into it
						currentNurse = new Nurse(data[0], data[1], data[2], data[3], data[4], data[5]);
						System.out.println(currentNurse.assignedDoctorEmpID);
						// Update nurse page text
						nurseWelcomeLabel1.setText("Hello, " + currentNurse.firstName + " " + currentNurse.lastName);
						nurseWelcomeLabel2.setText("Which patient are you seeing today?");
						
						
						window.setScene(nurseSelectPatientScene);
					}
				} else {
					System.out.println("NoPass");
					loginWrongInfoLabel.setText("Incorrect Username or Password.");
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				loginWrongInfoLabel.setText("Incorrect Username or Password.");
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
		
		loginGrid.add(loginUsernameLabel, 1, 1);
		loginGrid.add(loginUsernameField, 2, 1);
		loginGrid.add(loginPasswordLabel, 1, 2);
		loginGrid.add(loginPasswordField, 2, 2);
		
		
		// ------------ Login Vbox ------------ //
		VBox loginButtonsVBox = new VBox(30);
		loginButtonsVBox.getChildren().addAll(loginButton, loginCreateButton);
		loginButtonsVBox.setAlignment(Pos.CENTER);
		
		VBox loginVBox = new VBox(10);
		loginVBox.setAlignment(Pos.CENTER);
		loginVBox.getChildren().addAll(loginWelcomeLabel, loginSignInLabel, loginGrid, loginButtonsVBox, loginWrongInfoLabel);
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
		CAFirstNameLabel.setFont(new Font("Arial", 16));
		
		TextField CAFirstNameField = new TextField();
		CAFirstNameField.setFont(new Font("Arial", 16));
		CAFirstNameField.setPromptText("Enter First Name");
		
		Label CALastNameLabel = new Label("Last Name");
		CALastNameLabel.setFont(new Font("Arial", 16));
		
		TextField CALastNameField = new TextField();
		CALastNameField.setFont(new Font("Arial", 16));
		CALastNameField.setPromptText("Enter Last Name");
		
		Label CADateOfBirthLabel = new Label("Date of Birth");
		CADateOfBirthLabel.setFont(new Font("Arial", 16));
		
		TextField CADateOfBirthField = new TextField();
		CADateOfBirthField.setFont(new Font("Arial", 16));
		CADateOfBirthField.setPromptText("MM/DD/YYYY");
		
		Label CAPhoneNumLabel = new Label("Phone Number");
		CAPhoneNumLabel.setFont(new Font("Arial", 16));

		TextField CAPhoneNumField = new TextField();
		CAPhoneNumField.setFont(new Font("Arial", 16));
		CAPhoneNumField.setPromptText("XXX-XXX-XXXX");
		
		Label CAPasswordLabel = new Label("Password");
		CAPasswordLabel.setFont(new Font("Arial", 16));
		
		TextField CAPasswordField = new TextField();
		CAPasswordField.setFont(new Font("Arial", 16));
		CAPasswordField.setPromptText("Password");
		
		Label CAPharmacyLabel = new Label("Pharmacy Address:");
		CAPharmacyLabel.setFont(new Font("Arial", 16));

		TextField CAPharmacyField = new TextField();
		CAPharmacyField.setFont(new Font("Arial", 16));
		CAPharmacyField.setPromptText("Enter Pharmacy Address");
		
		Label CAInsuranceLabel = new Label("Insurance Name:");
		CAInsuranceLabel.setFont(new Font("Arial", 16));

		TextField CAInsuranceField = new TextField();
		CAInsuranceField.setFont(new Font("Arial", 16));
		CAInsuranceField.setPromptText("Enter Insurance Name");
		
		Label CAEmailLabel = new Label("Email:");
		CAEmailLabel.setFont(new Font("Arial", 16));

		TextField CAEmailField = new TextField();
		CAEmailField.setFont(new Font("Arial", 16));
		CAEmailField.setPromptText("Enter email");
		
		Label CAShowUsername = new Label("");
		CAShowUsername.setFont(new Font("Arial", 24));
		

		
		//When the Create button is pressed, patient data is written to database. Text file is named in
		//the following format P(PatientID)
		
		// this is pain

	
		Button CACreateButton = new Button("Create");
		CACreateButton.setFont(new Font("Arial", 20));
		CACreateButton.setMinWidth(300);
		CACreateButton.setDefaultButton(true);
		
		CACreateButton.setOnAction(e ->{

			Patient newPatient = null;
			try {
				newPatient = new Patient(CAFirstNameField.getText(), CALastNameField.getText(), CADateOfBirthField.getText(), 
							CAPhoneNumField.getText(), CAEmailField.getText(), "P" + CAFirstNameField.getText().substring(0, 1) + CALastNameField.getText() + CADateOfBirthField.getText().substring(6),
							2021 - Integer.parseInt(CADateOfBirthField.getText().substring(6)), CAPharmacyField.getText(), CAInsuranceField.getText(),CAPasswordField.getText());
			} catch (NumberFormatException | IOException e2) {
				e2.printStackTrace();
			}
				try {
					database.changeFile(newPatient.patientID);
					database.dataWrite(newPatient.generateStorageArray());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				CAShowUsername.setText("Account Created!\n"
						+ "Your Username is: P" + CAFirstNameField.getText().substring(0, 1) + CALastNameField.getText() + CADateOfBirthField.getText().substring(6)
						+ "\n Remember it!");
				CAFirstNameField.clear();
				CALastNameField.clear();
				CADateOfBirthField.clear();
				CAPhoneNumField.clear();
				CAPasswordField.clear();
				CAInsuranceField.clear();
				CAPharmacyField.clear();
				CAEmailField.clear();
		});
				
				
				Button CABackButton = new Button("Back To Login");
				CABackButton.setFont(new Font("Arial", 14));
				CABackButton.setOnAction(e -> {
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
				CAGrid.add(CAEmailLabel, 1, 5);
				CAGrid.add(CAEmailField, 2, 5);
				CAGrid.add(CAPharmacyLabel, 1, 6);
				CAGrid.add(CAPharmacyField, 2, 6);
				CAGrid.add(CAInsuranceLabel, 1, 7);
				CAGrid.add(CAInsuranceField, 2, 7);
				CAGrid.add(CAPasswordLabel, 1, 8);
				CAGrid.add(CAPasswordField, 2, 8);
				
				
				// ------------ CAVBox ------------ //
				VBox CAVBox = new VBox(10);
				CAVBox.setAlignment(Pos.CENTER);
				CAVBox.getChildren().addAll(CALabel, CAGrid, CACreateButton, CABackButton, CAShowUsername);
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
			// for patient in patientList:
			// doctorPatientListCombo.add(patient.getName());
			doctorPatientListCombo.getItems().addAll("George Person");

			Button doctorPatientNextButton = new Button("Next");
			doctorPatientNextButton.setFont(new Font("Arial", 14));
			doctorPatientNextButton.setOnAction(e -> {
				// currentPatient = patient
				window.setScene(doctorScene);
			});
			
			Label doctorWelcomeLabel = new Label("Hello Dr. (name) - Which patient are you seeing today?"); 
			doctorWelcomeLabel.setFont(new Font("Arial", 20));
				
			TabPane doctorPatientTab = new TabPane();
			Tab tabPatient = new Tab();
		    tabPatient.setText("Patients");
			// ----------- doctorSelectPatientGrid ---------- //
			VBox doctorSelectPatientVBox = new VBox();
			GridPane doctorSelectPatient = new GridPane();
			doctorSelectPatient.setPadding(new Insets(10, 10, 10, 10));
			doctorSelectPatientVBox.setPadding(new Insets(10, 10, 10, 10));
			doctorSelectPatient.setVgap(10);
			doctorSelectPatient.add(doctorWelcomeLabel, 0, 0);
			doctorSelectPatient.add(doctorPatientListCombo, 0, 1);
			doctorSelectPatient.add(doctorPatientNextButton, 0, 55);
			tabPatient.setContent(doctorSelectPatient);
			doctorPatientTab.getTabs().addAll(tabPatient);
			doctorSelectPatientVBox.getChildren().addAll(doctorWelcomeLabel, doctorPatientTab);
			// ---------- Scene Default ---------- //
			doctorSelectPatientScene = new Scene(doctorSelectPatientVBox, 600, 700);
				
			// ================================= General doctorScene ================================= //
				
			// ---------- Assets ------- //
			Label doctorPatientNameLabel = new Label("Patient Name");
			doctorPatientNameLabel.setFont(new Font("Arial", 20));
				
			Button doctorSelectDifPatientButton = new Button("Select A Different Patient");
			doctorSelectDifPatientButton.setFont(new Font("Arial", 20));
				
			TabPane doctorTabs = new TabPane();
			Tab tabDocExam = new Tab();
			tabDocExam.setText("Examination");
			Tab tabDocHistory = new Tab();
			tabDocHistory.setText("History");
			Tab tabDocContact = new Tab();
			tabDocContact.setText("Contact Info");
			Tab tabDocMessages = new Tab();
			tabDocMessages.setText("Messages");
			Tab tabDocSummary = new Tab();
			tabDocSummary.setText("Visit Summary");
			doctorTabs.getTabs().addAll(tabDocExam, tabDocSummary, tabDocHistory, tabDocContact, tabDocMessages);
				
			// BUTTON FUNCTION AT BOTTOM OF DOCTOR PAGE //
				
			// ------------ doctorMenuVBox ----------- //
			VBox doctorMenuVBox = new VBox();
			doctorMenuVBox.setPadding(new Insets(10, 10, 10, 10));
			doctorMenuVBox.getChildren().addAll(doctorTabs);
				
			// ----------- doctorBorder ---------- //
			BorderPane doctorBorder = new BorderPane();
			doctorBorder.setPadding(new Insets(10, 10, 10, 10));
			doctorBorder.setTop(doctorPatientNameLabel);
			doctorBorder.setCenter(doctorTabs);
			doctorBorder.setBottom(doctorSelectDifPatientButton);
				
			// ---------- Scene Default ------------ //
			doctorScene = new Scene(doctorBorder, 600, 700);
				
			// ===================================== Doctor Exam ===================================== //
				
			// --------- Asset Definition -------- //
			Label doctorExamFindingsLabel = new Label("Physical Test Findings:");
			doctorExamFindingsLabel.setFont(new Font("Arial", 16));
				
			TextArea doctorPhysicalArea = new TextArea();
			doctorPhysicalArea.setText("Enter Physical FIndings");
			doctorPhysicalArea.setPrefWidth(350);
				
			Label doctorPrescriptionsLabel = new Label("Prescriptions:");
			doctorPrescriptionsLabel.setFont(new Font("Arial", 16));
				
			TextArea doctorPrescriptionsArea = new TextArea();
			doctorPrescriptionsArea.setText("Enter Prescriptions");
			doctorPrescriptionsArea.setPrefWidth(350);
				
			Button doctorExamSaveButton = new Button("Save");
			doctorExamSaveButton.setFont(new Font("Arial", 20));
				
			// -------- doctorExamGrid ------- //
			GridPane doctorExamGrid = new GridPane();
			doctorExamGrid.setVgap(10);
			doctorExamGrid.add(doctorExamFindingsLabel, 0, 0);
			doctorExamGrid.add(doctorPhysicalArea, 1, 0);
			doctorExamGrid.add(doctorPrescriptionsLabel, 0, 1);
			doctorExamGrid.add(doctorPrescriptionsArea, 1, 1);
			doctorExamGrid.add(doctorExamSaveButton, 0, 4);
				
			// -------- doctorExamVBox ------- //
			VBox doctorExamVBox = new VBox();
			doctorExamVBox.getChildren().addAll(doctorExamGrid);
			tabDocExam.setContent(doctorExamVBox);

			// ===================================== Doctor History ===================================== //
				
			// --------- Asset Definition -------- //
			Label doctorPriorHealthIssuesLabel = new Label("Prior Health Issues:");
			doctorPriorHealthIssuesLabel.setFont(new Font("Arial", 16));
				
			Label doctorPriorMedicationsLabel = new Label("Prior Medications:");
			doctorPriorMedicationsLabel.setFont(new Font("Arial", 16));
				
			Label doctorImmRecordsLabel = new Label("Immunization Records:");
			doctorImmRecordsLabel.setFont(new Font("Arial", 16));
				
			// -------- doctorHistoryVBox ------- //
			VBox doctorHistoryVBox = new VBox();
			doctorHistoryVBox.setSpacing(150);
			doctorHistoryVBox.getChildren().addAll(doctorPriorHealthIssuesLabel,
														doctorPriorMedicationsLabel, doctorImmRecordsLabel);
			tabDocHistory.setContent(doctorHistoryVBox);
				
			// ===================================== Doctor Contact Info ===================================== //
				
			// --------- Asset Definition -------- //
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
			doctorContactInfoVBox.setSpacing(90);
			doctorContactInfoVBox.getChildren().addAll(doctorFullNameLabel, doctorEmail,
															doctorPhoneNumber, doctorPharmacyContactLabel, doctorInsuranceContactLabel);
			tabDocContact.setContent(doctorContactInfoVBox);
				
			// ================================== Doctor Visit Summary ================================= //
				
			// --------- Asset Definition -------- //
			TextField doctorVisitSummaryField = new TextField();
			doctorVisitSummaryField.setPromptText("Enter Summary for this Visit");
			TextArea doctorVisitSummaryArea = new TextArea();
			doctorVisitSummaryArea.setText("Enter Prescriptions");
				
			Button doctorVisitSummarySaveButton = new Button("Save");
			doctorVisitSummarySaveButton.setFont(new Font("Arial", 20));
				
			// -------- patientSummariesVBox ------- //
			BorderPane doctorSummaryBorder = new BorderPane();
			doctorSummaryBorder.setPadding(new Insets(5, 0, 30, 0));
			doctorSummaryBorder.setTop(doctorVisitSummaryArea);
			doctorSummaryBorder.setBottom(doctorVisitSummarySaveButton);
				
			tabDocSummary.setContent(doctorSummaryBorder);
				
			// ===================================== Doctor Messages ===================================== //
				
				
			// --------- Asset Definition -------- //
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
			doctorMessagesVBox.setSpacing(50);
			doctorMessagesVBox.getChildren().addAll(doctorMessagesText, doctorMessageField, doctorSendMessageButton);
			tabDocMessages.setContent(doctorMessagesVBox);
			
			// ================================== Doctor Button Functions ================================= //
			doctorExamSaveButton.setOnAction(e -> {
				// SAVE STUFF HERE
				doctorPhysicalArea.setText(doctorPhysicalArea.getText());
				doctorPrescriptionsArea.setText(doctorPrescriptionsArea.getText());
			});
			doctorVisitSummarySaveButton.setOnAction(e -> {
				// SAVE STUFF HERE
				doctorVisitSummaryArea.setText(doctorVisitSummaryArea.getText());
			});
			doctorSelectDifPatientButton.setOnAction(e -> {
				window.setScene(doctorSelectPatientScene);
			});
		

		// Save button information at the bottom so that all objects have been instantiated
		patientContactInfoSaveButton.setOnAction(e -> {
			currentPatient.email = patientEmailField.getText();
			currentPatient.phoneNumber = patientPhoneNumberField.getText();
			currentPatient.pharmacyInformation = patientPharmacyField.getText();
			currentPatient.insuranceInformation = patientInsuranceField.getText();
			database.changeFile(currentPatient.patientID);
			try {
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in datawrite Patient");
			}
			patientBorder.setCenter(patientVisitSummariesVBox);
			
		});
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ------------------------------------ Main -------------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		window.show();
	}
	
	
	
}