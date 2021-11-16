package team49;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
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
import javafx.scene.text.TextAlignment;
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
	Doctor currentDoctor;
	String text;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// --------------------------------- Doctor Page ---------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		// ===================================== Doctor Select Patient ===================================== //
		// ------------ Asset Definition ------------ //
		ComboBox<String> doctorPatientListCombo = new ComboBox<String>();
		doctorPatientListCombo.setPromptText("Select Patient");

		Button doctorPatientNextButton = new Button("Next");
		doctorPatientNextButton.setFont(new Font("Arial", 14));
		
		Label doctorWelcomeLabel1 = new Label("Hello Dr. (name) - Which patient are you seeing today?"); 
		doctorWelcomeLabel1.setFont(new Font("Arial", 20));
		
		Label doctorWelcomeLabel2 = new Label("Hello Dr. (name) - Which patient are you seeing today?"); 
		doctorWelcomeLabel2.setFont(new Font("Arial", 20));
		
		// ----------- doctorSelectPatientGrid ---------- //
		TabPane doctorPatientTab = new TabPane();
		Tab tabPatient = new Tab();
	    tabPatient.setText("Patients");
		// ----------- doctorSelectPatientGrid ---------- //
		VBox doctorSelectPatientVBox = new VBox();
		GridPane doctorSelectPatient = new GridPane();
		doctorSelectPatient.setPadding(new Insets(10, 10, 10, 10));
		doctorSelectPatientVBox.setPadding(new Insets(10, 10, 10, 10));
		doctorSelectPatient.setVgap(10);
		doctorSelectPatient.add(doctorWelcomeLabel1, 0, 0);
		doctorSelectPatient.add(doctorPatientListCombo, 0, 1);
		doctorSelectPatient.add(doctorPatientNextButton, 0, 55);
		tabPatient.setContent(doctorSelectPatient);
		doctorPatientTab.getTabs().addAll(tabPatient);
		doctorSelectPatientVBox.getChildren().addAll(doctorWelcomeLabel1, doctorPatientTab);
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
		doctorExamSaveButton.setDefaultButton(true);
		
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
		
		// ===================================== Doctor Patient History ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorPatientHistoryLabel = new Label("Patient History: ");
		doctorPatientHistoryLabel.setFont(new Font("Arial", 20));
		
		Label doctorPriorHealthIssuesLabel = new Label("Prior Health Issues: ");
		doctorPriorHealthIssuesLabel.setFont(new Font("Arial", 16));

		Label doctorPriorHealthIssuesText = new Label("-");
		doctorPriorHealthIssuesText.setFont(new Font("Arial", 16));
		
		Label doctorPriorMedicationsLabel = new Label("Prior Medications: ");
		doctorPriorMedicationsLabel.setFont(new Font("Arial", 16));
		
		Label doctorPriorMedicationsText = new Label("-");
		doctorPriorMedicationsText.setFont(new Font("Arial", 16));
		
		Label doctorImmRecordsLabel = new Label("Immunization Records: ");
		doctorImmRecordsLabel.setFont(new Font("Arial", 16));
		
		Label doctorImmRecordsText = new Label("-");
		doctorImmRecordsText.setFont(new Font("Arial", 16));
		
		// -------- doctorHistoryVBox ------- //
		VBox doctorHistoryVBox = new VBox();
		doctorHistoryVBox.setSpacing(10);
		doctorHistoryVBox.getChildren().addAll(doctorPatientHistoryLabel, doctorPriorHealthIssuesLabel, doctorPriorHealthIssuesText,
												doctorPriorMedicationsLabel, doctorPriorMedicationsText, doctorImmRecordsLabel, doctorImmRecordsText);
		tabDocHistory.setContent(doctorHistoryVBox);
		// ===================================== Doctor Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label doctorFullNameLabel = new Label("Full Name: ");
		doctorFullNameLabel.setFont(new Font("Arial", 16));
		
		Label doctorFullNameText = new Label("-");
		doctorFullNameText.setFont(new Font("Arial", 16));
		
		Label doctorEmailLabel = new Label("Email: ");
		doctorEmailLabel.setFont(new Font("Arial", 16));
		
		Label doctorEmailText = new Label("-");
		doctorEmailText.setFont(new Font("Arial", 16));
		
		Label doctorPhoneNumberLabel = new Label("Phone Number: ");
		doctorPhoneNumberLabel.setFont(new Font("Arial", 16));
		
		Label doctorPhoneNumberText = new Label("-");
		doctorPhoneNumberText.setFont(new Font("Arial", 16));
		
		Label doctorPharmacyLabel = new Label("Pharmacy Contact: ");
		doctorPharmacyLabel.setFont(new Font("Arial", 16));
		
		Label doctorPharmacyText = new Label("-");
		doctorPharmacyText.setFont(new Font("Arial", 16));
		
		Label doctorInsuranceLabel = new Label("Insurance Contact: ");
		doctorInsuranceLabel.setFont(new Font("Arial", 16));
		
		Label doctorInsuranceText = new Label("-");
		doctorInsuranceText.setFont(new Font("Arial", 16));
		
		// -------- DoctorContactInfoHBox's -------- //
		HBox docName = new HBox();
		docName.getChildren().addAll(doctorFullNameLabel,doctorFullNameText);
		HBox docEmail = new HBox();
		docEmail.getChildren().addAll(doctorEmailLabel,doctorEmailText);
		HBox docPhone = new HBox();
		docPhone.getChildren().addAll(doctorPhoneNumberLabel,doctorPhoneNumberText);
		HBox docPharmacy = new HBox();
		docPharmacy.getChildren().addAll(doctorPharmacyLabel,doctorPharmacyText);
		HBox docInsurance = new HBox();
		docInsurance.getChildren().addAll(doctorInsuranceLabel,doctorInsuranceText);
		
		// -------- doctorContactInfoVBox ------- //
		VBox doctorContactInfoVBox = new VBox();
		doctorContactInfoVBox.setSpacing(40);
		doctorContactInfoVBox.getChildren().addAll(docName, docEmail, docPhone, docPharmacy, docInsurance);
		tabDocContact.setContent(doctorContactInfoVBox);
		
		// ================================== Doctor Visit Summary ================================= //
		
		// --------- Asset Definition -------- //
		Label doctorVisitSummaryLabel = new Label("Visit Summaries:");
		doctorVisitSummaryLabel.setFont(new Font("Arial", 20));
		
		Label doctorVisitSummaryText = new Label("---");
		doctorVisitSummaryText.setFont(new Font("Arial", 14));
		
		TextArea doctorVisitSummaryField = new TextArea();
		doctorVisitSummaryField.setPromptText("Eg. 03/24/15: Summary Here");
		
		Button doctorVisitSummarySaveButton = new Button("Save");
		doctorVisitSummarySaveButton.setFont(new Font("Arial", 20));
		doctorVisitSummarySaveButton.setDefaultButton(true);
		
		// -------- DoctorSummariesVBox ------- //
		VBox doctorVisitSummaryVBox = new VBox();
		doctorVisitSummaryVBox.getChildren().addAll(doctorVisitSummaryLabel, doctorVisitSummaryText);
		BorderPane doctorSummaryBorder = new BorderPane();
		
		// -------- DoctorVisitSummaryBorder ------- //
		doctorSummaryBorder.setPadding(new Insets(5, 0, 30, 0));
		doctorSummaryBorder.setTop(doctorVisitSummaryVBox);
		doctorSummaryBorder.setCenter(doctorVisitSummaryField);
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
		// Almost the same as patientSendMessageButton
		doctorSendMessageButton.setDefaultButton(true);
		doctorSendMessageButton.setOnAction(e -> {
			currentPatient.messageList.add("Dr. " + currentDoctor.lastName + ": " + doctorMessageField.getText());
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			doctorMessagesText.setText(text);
			doctorMessageField.clear();
			
			// Save patientMessage File
			database.changeFile(currentPatient.messageFile);
			String[] temp = new String[currentPatient.messageList.size()]; // convert messages arraylist to array before passing
			currentPatient.messageList.toArray(temp);
			try {
				database.dataWrite(temp);
			} catch (IOException e1) {
				System.out.println("Error saving patient messages for doctor");
			}
			
		});
		
		VBox doctorMessagesVBox = new VBox();
		doctorMessagesVBox.setSpacing(50);
		doctorMessagesVBox.getChildren().addAll(doctorMessagesText, doctorMessageField, doctorSendMessageButton);
		tabDocMessages.setContent(doctorMessagesVBox);
		
		// ================================== Doctor Tab Functions ================================= //

		tabDocHistory.setOnSelectionChanged(e -> {
			doctorPriorHealthIssuesText.setText(currentPatient.priorHealthIssues);
			doctorPriorMedicationsText.setText(currentPatient.medications);
			doctorImmRecordsText.setText(currentPatient.priorImmunizations);
		});
	
		tabDocContact.setOnSelectionChanged(e -> {
			doctorFullNameText.setText(currentPatient.firstName + " " + currentPatient.lastName);
			doctorEmailText.setText(currentPatient.email);
			doctorPhoneNumberText.setText(currentPatient.phoneNumber);
			doctorPharmacyText.setText(currentPatient.pharmacyInformation);
			doctorInsuranceText.setText(currentPatient.insuranceInformation);
		});
		
		tabDocMessages.setOnSelectionChanged(e -> {
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			doctorMessagesText.setText(text);
		});

		// ================================== Doctor Button Functions ================================= //
		
		doctorExamSaveButton.setOnAction(e -> {
			//doctorBorder.setCenter(doctorHistoryVBox);
			// SAVE STUFF HERE
			currentPatient.physicalExamResults = doctorPhysicalArea.getText();
			currentPatient.medications = currentPatient.medications + " " + doctorPrescriptionsArea.getText();
			
			// Save to file
			try {
				database.changeFile(currentPatient.patientID);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in doctorExamSaveButton");
			}
			
		});
		doctorVisitSummarySaveButton.setOnAction(e -> {
			// SAVE STUFF HERE
			currentPatient.visitSummariesList.add(doctorVisitSummaryField.getText());
			text = "";
			for (int i = 0; i < currentPatient.visitSummariesList.size(); i++) {
				text += currentPatient.visitSummariesList.get(i) + "\n";
			}
			doctorVisitSummaryText.setText(text);
			doctorVisitSummaryField.clear();
			
			
			// Save Visit Summary File
			database.changeFile(currentPatient.visitSummariesFile);
			String[] temp = new String[currentPatient.visitSummariesList.size()]; // convert to arraylist to array before passing
			currentPatient.visitSummariesList.toArray(temp);
			try {
				database.dataWrite(temp);
			} catch (IOException e1) {
				System.out.println("Error saving visit summaries");
			}
		});
		
		doctorSelectDifPatientButton.setOnAction(e -> {
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			doctorMessagesText.setText(text);
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

		Button nursePatientNextButton = new Button("Next");
		nursePatientNextButton.setFont(new Font("Arial", 14));
		
		Label nurseWelcomeLabel1 = new Label("Hello (name) - Which patient are you seeing today?"); 
		nurseWelcomeLabel1.setFont(new Font("Arial", 20));
		
		Label nurseWelcomeLabel2 = new Label("Hello (name) - Which patient are you seeing today?"); 
		nurseWelcomeLabel2.setFont(new Font("Arial", 20));
		
		GridPane nurseSelectPatient = new GridPane();
		nurseSelectPatient.setPadding(new Insets(10, 10, 10, 10));
		nurseSelectPatient.setVgap(10);
		nurseSelectPatient.add(nursePatientListCombo, 0, 1);
		nurseSelectPatient.add(nursePatientNextButton, 0, 55);
		
		// ----------- nurseSelectPatientVBox ---------- //
		VBox nurseSelectPatientVBox = new VBox();
		nurseSelectPatientVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseSelectPatientVBox.getChildren().addAll(nurseWelcomeLabel1, nurseWelcomeLabel2,nurseSelectPatient);
				
		// ---------- Scene Default ---------- //
		nurseSelectPatientScene = new Scene(nurseSelectPatientVBox, 600, 700);
		
		// ================================= General nurseScene ================================= //
		TabPane nurseTabs = new TabPane();
		Tab tabNurseVitals = new Tab();
		tabNurseVitals.setText("Vitals");
		Tab tabNurseHistory = new Tab();
		tabNurseHistory.setText("Patient History");
		Tab tabNurseConcerns = new Tab();
		tabNurseConcerns.setText("Patient Health");
		Tab tabNurseContact = new Tab();
		tabNurseContact.setText("Contact Info");
		Tab tabNurseMessages = new Tab();
		tabNurseMessages.setText("Messages");
		nurseTabs.getTabs().addAll(tabNurseVitals, tabNurseConcerns, tabNurseHistory, tabNurseContact,tabNurseMessages);
		
		VBox nurseMenuVBox = new VBox();
		nurseMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseMenuVBox.getChildren().addAll(nurseTabs);
		
		// ---------- Assets ------- //
		Label nursePatientNameLabel = new Label("Patient Name");
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
		
		// ----------- nurseBorder ---------- //
		
		BorderPane nurseBorder = new BorderPane();
		nurseBorder.setPadding(new Insets(10, 10, 10, 10));
		nurseBorder.setTop(nursePatientNameLabel);
		nurseBorder.setCenter(nurseMenuVBox);
		nurseBorder.setBottom(nurseSelectDifPatientButton);
		
		// ---------- Scene Stuff ------------ //
		nurseScene = new Scene(nurseBorder, 600, 700);
		
		// ===================================== Nurse Vitals ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseVitalsLabel = new Label("Enter Patients Vitals:");
		nurseVitalsLabel.setFont(new Font("Arial", 30));
		
		Label nurseWeightLabel = new Label("Weight (lbs):");
		nurseWeightLabel.setFont(new Font("Arial", 18));
		
		TextField nurseWeightField = new TextField();
		nurseWeightField.setPromptText("Enter Weight");
		
		Label nurseHeightLabel = new Label("Height (ft'in):");
		nurseHeightLabel.setFont(new Font("Arial", 18));
		
		TextField nurseHeightField = new TextField();
		nurseHeightField.setPromptText("Enter Height");
		
		Label nurseBodyTempLabel = new Label("Body Temperature:");
		nurseBodyTempLabel.setFont(new Font("Arial", 18));
		
		TextField nurseBodyTempField = new TextField();
		nurseBodyTempField.setPromptText("Enter Body Temperature");
		
		
		Label nurseBloodPressureLabel = new Label("Blood Pressure:");
		nurseBloodPressureLabel.setFont(new Font("Arial", 18));
		
		TextField nurseBloodPressureField = new TextField();
		nurseBloodPressureField.setPromptText("Enter Blood Pressure");
		
		Button nurseVitalsSaveButton = new Button("Save");
		nurseVitalsSaveButton.setFont(new Font("Arial", 20));
		nurseVitalsSaveButton.setDefaultButton(true);
		
		
		// ----------- nurseVitalsGrid ---------- //
		GridPane nurseVitalsGrid = new GridPane();
		nurseVitalsGrid.setPadding(new Insets(10, 10, 10, 10));
		nurseVitalsGrid.add(nurseWeightLabel, 0, 0);
		nurseVitalsGrid.add(nurseWeightField, 1, 0);
		nurseVitalsGrid.add(nurseHeightLabel, 0, 1);
		nurseVitalsGrid.add(nurseHeightField, 1, 1);
		nurseVitalsGrid.add(nurseBodyTempLabel, 0, 2);
		nurseVitalsGrid.add(nurseBodyTempField, 1, 2);
		nurseVitalsGrid.add(nurseBloodPressureLabel, 0, 3);
		nurseVitalsGrid.add(nurseBloodPressureField, 1, 3);
		
		
		// ----------- nurseVitalsVBox ---------- //
		VBox nurseVitalsVBox = new VBox();
		nurseVitalsVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseVitalsVBox.getChildren().addAll(nurseVitalsLabel, nurseVitalsGrid, nurseVitalsSaveButton);
		tabNurseVitals.setContent(nurseVitalsVBox);
		
		
		// ===================================== Nurse Health Concerns ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseHealthConernsLabel = new Label("Patient Health Concerns:");
		nurseHealthConernsLabel.setFont(new Font("Arial", 30));
		
		Label nurseAllergiesLabel = new Label("Known Allergies:");
		nurseAllergiesLabel.setFont(new Font("Arial", 18));
		
		TextField nurseAllergiesField = new TextField();
		nurseAllergiesField.setPromptText("Enter known allergies");
		
		Label nurseKnownConcernsLabel = new Label("Known Concerns:");
		nurseKnownConcernsLabel.setFont(new Font("Arial", 18));
		
		TextField nurseKnownConcernsField = new TextField();
		nurseKnownConcernsField.setPromptText("Enter known concerns");
		
		Button nurseConcernsSaveButton = new Button("Save");
		nurseConcernsSaveButton.setFont(new Font("Arial", 20));
		nurseConcernsSaveButton.setDefaultButton(true);
		
		// ----------- nurseConcernsGrid ---------- //
		GridPane nurseConcernsGrid = new GridPane();
		nurseConcernsGrid.add(nurseAllergiesLabel, 0, 0);
		nurseConcernsGrid.add(nurseAllergiesField, 1, 0);
		nurseConcernsGrid.add(nurseKnownConcernsLabel, 0, 1);
		nurseConcernsGrid.add(nurseKnownConcernsField, 1, 1);
		
		// ----------- nurseConcernsVBox ---------- //
		VBox nurseConcernsVBox = new VBox();
		nurseConcernsVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseConcernsVBox.setSpacing(40);
		nurseConcernsVBox.getChildren().addAll(nurseHealthConernsLabel, nurseConcernsGrid, nurseConcernsSaveButton);
		tabNurseConcerns.setContent(nurseConcernsVBox);
		
		// ===================================== Nurse Patient History ===================================== //
		
		// ------------ Asset Definition ------------ //
		
		Label nurseHistoryLabel = new Label("Patients Health History:");
		nurseHistoryLabel.setFont(new Font("Arial", 30));
		
		Label nurseHealthIssuesLabel = new Label("Prior Health Issues:");
		nurseHealthIssuesLabel.setFont(new Font("Arial", 18));
		
		Label nurseHealthIssuesText = new Label("---");
		nurseHealthIssuesText.setFont(new Font("Arial", 14));
		
		Label nurseMedicationsLabel = new Label("Prior Medications:");
		nurseMedicationsLabel.setFont(new Font("Arial", 18));
		
		Label nurseMedicationsText = new Label("---");
		nurseMedicationsText.setFont(new Font("Arial", 14));
		
		Label nurseImmRecordsLabel = new Label("Immunization Records:");
		nurseImmRecordsLabel.setFont(new Font("Arial", 18));
		
		Label nurseImmRecordsText = new Label("---");
		nurseImmRecordsText.setFont(new Font("Arial", 14));
		
		
		// ----------- nurseHistoryVBox ---------- //
		VBox nurseHistoryVBox = new VBox();
		nurseHistoryVBox.setPadding(new Insets(10, 10, 10, 10));
		nurseHistoryVBox.setSpacing(10);
		nurseHistoryVBox.getChildren().addAll(nurseHistoryLabel, nurseHealthIssuesLabel, nurseHealthIssuesText, nurseMedicationsLabel,
				nurseMedicationsText, nurseImmRecordsLabel, nurseImmRecordsText);
		tabNurseHistory.setContent(nurseHistoryVBox);
		
		// ===================================== Nurse Contact Info ===================================== //
		
		// --------- Asset Definition -------- //
		Label nurseContactInfoLabel = new Label("Patient Contact Information: ");
		nurseContactInfoLabel.setFont(new Font("Arial", 20));
		
		Label nurseFullNameLabel = new Label("Full Name: ");
		nurseFullNameLabel.setFont(new Font("Arial", 16));
		
		Label nurseFullNameText = new Label("-");
		nurseFullNameText.setFont(new Font("Arial", 16));
		
		Label nurseEmailLabel = new Label("Email: ");
		nurseEmailLabel.setFont(new Font("Arial", 16));
		
		Label nurseEmailText = new Label("-");
		nurseEmailText.setFont(new Font("Arial", 16));
		
		Label nursePhoneNumberLabel = new Label("Phone Number: ");
		nursePhoneNumberLabel.setFont(new Font("Arial", 16));
		
		Label nursePhoneNumberText = new Label("-");
		nursePhoneNumberText.setFont(new Font("Arial", 16));
		
		Label nursePharmacyLabel = new Label("Pharmacy Address: ");
		nursePharmacyLabel.setFont(new Font("Arial", 16));
		
		Label nursePharmacyText = new Label("-");
		nursePharmacyText.setFont(new Font("Arial", 16));
		
		Label nurseInsuranceLabel = new Label("Insurance Contact: ");
		nurseInsuranceLabel.setFont(new Font("Arial", 16));
		
		Label nurseInsuranceText = new Label("-");
		nurseInsuranceText.setFont(new Font("Arial", 16));
		
		// -------- nurseContactInfoGrid -------- //
		GridPane nurseContactInfoGrid = new GridPane();
		nurseContactInfoGrid.add(nurseFullNameLabel, 0, 0);
		nurseContactInfoGrid.add(nurseFullNameText, 1, 0);
		nurseContactInfoGrid.add(nurseEmailLabel, 0, 1);
		nurseContactInfoGrid.add(nurseEmailText, 1, 1);
		nurseContactInfoGrid.add(nursePhoneNumberLabel, 0, 2);
		nurseContactInfoGrid.add(nursePhoneNumberText, 1, 2);
		nurseContactInfoGrid.add(nursePharmacyLabel, 0, 3);
		nurseContactInfoGrid.add(nursePharmacyText, 1, 3);
		nurseContactInfoGrid.add(nurseInsuranceLabel, 0, 4);
		nurseContactInfoGrid.add(nurseInsuranceText, 1, 4);
		
		// -------- nurseContactInfoVBox -------- //
		VBox nurseContactInfoVBox = new VBox();
		nurseContactInfoVBox.getChildren().addAll(nurseContactInfoLabel, nurseContactInfoGrid);
		tabNurseContact.setContent(nurseContactInfoVBox);
		
		// ===================================== Nurse Messages ===================================== //
		
		// --------- Asset Definition -------- //
		Label nurseMessagesLabel = new Label("Messages:");
		nurseMessagesLabel.setFont(new Font("Arial", 20));
		
		Label nurseMessagesText = new Label("No Messages");
		nurseMessagesText.setFont(new Font("Arial", 16));
		
		TextArea nurseMessageField = new TextArea();
		nurseMessageField.setPromptText("Enter Message");
		
		Button nurseSendMessageButton = new Button("Send");
		nurseSendMessageButton.setFont(new Font("Arial", 20));
		// Almost the same as patientSendMessageButton
		nurseSendMessageButton.setDefaultButton(true);
		nurseSendMessageButton.setOnAction(e -> {
			currentPatient.messageList.add("Nurse " + currentNurse.lastName + ": " + nurseMessageField.getText());
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			nurseMessagesText.setText(text);
			nurseMessageField.clear();
			
			// Save patientMessage File
			database.changeFile(currentPatient.messageFile);
			String[] temp = new String[currentPatient.messageList.size()]; // convert messages arraylist to array before passing
			currentPatient.messageList.toArray(temp);
			try {
				database.dataWrite(temp);
			} catch (IOException e1) {
				System.out.println("Error saving patient messages for nurse");
			}
			
		});
		
		VBox nurseMessagesVBox = new VBox();
		nurseMessagesVBox.getChildren().addAll(nurseMessagesLabel, nurseMessagesText, nurseMessageField, nurseSendMessageButton);
		tabNurseMessages.setContent(nurseMessagesVBox);
		
		// ================================== Nurse Tab Functions ================================= //
		tabNurseHistory.setOnSelectionChanged(e -> {
			nurseHealthIssuesText.setText(currentPatient.priorHealthIssues);
			nurseMedicationsText.setText(currentPatient.medications);
			nurseImmRecordsText.setText(currentPatient.priorImmunizations);
		});
		
		tabNurseContact.setOnSelectionChanged(e -> {
			nurseFullNameText.setText(currentPatient.firstName + " " + currentPatient.lastName);
			nurseEmailText.setText(currentPatient.email);
			nursePhoneNumberText.setText(currentPatient.phoneNumber);
			nursePharmacyText.setText(currentPatient.pharmacyInformation);
			nurseInsuranceText.setText(currentPatient.insuranceInformation);
		});
		
		tabNurseMessages.setOnSelectionChanged(e -> {
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			nurseMessagesText.setText(text);
		});
		
		// ================================== Nurse Button Functions ================================= //
		nurseVitalsSaveButton.setOnAction(e -> {
			// SAVE STUFF
			currentPatient.currentWeight = nurseWeightField.getText();
			currentPatient.currentHeight = nurseHeightField.getText();
			currentPatient.currentTemperature = nurseBodyTempField.getText();
			currentPatient.bloodPressure = nurseBloodPressureField.getText();
			
			// Save to file
			try {
				database.changeFile(currentPatient.patientID);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in nurseVitalsSaveButton");
			}
			
		});
		
		nurseConcernsSaveButton.setOnAction(e -> {
			// SAVE STUFF
			currentPatient.currentAllergies = nurseAllergiesField.getText();
			currentPatient.currentHealthConcerns = nurseKnownConcernsField.getText();
			
			// Save to file
			try {
				database.changeFile(currentPatient.patientID);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in nurseConcernsSaveButton");
			}
		});
		
		nurseSelectDifPatientButton.setOnAction(e -> {
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			nurseMessagesText.setText(text);
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
		
		// BUTTON FUNCTION AT BOTTOM OF PATIENT PAGE //
		
		// ------------ nurseMenuVBox ----------- //
		VBox patientMenuVBox = new VBox();
		patientMenuVBox.setPadding(new Insets(10, 10, 10, 10));
		
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
		patientContactInfoSaveButton.setDefaultButton(true);
		
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
		
		Label patientVisitSummariesText = new Label("---");
		patientVisitSummariesText.setFont(new Font("Arial", 14));
		
		// -------- patientSummariesVBox ------- //
		VBox patientVisitSummariesVBox = new VBox();
		patientVisitSummariesVBox.getChildren().addAll(patientVisitSummariesTitleLabel, patientVisitSummariesText);
		
		// ===================================== Patient Messages ===================================== //
		
		// --------- Asset Definition -------- //
		Label patientMessagesLabel = new Label("Messages:");
		patientMessagesLabel.setFont(new Font("Arial", 20));
		
		Label patientMessagesText = new Label("No Messages");
		patientMessagesText.setFont(new Font("Arial", 16));
		
		TextField patientMessageField = new TextField();
		patientMessageField.setPromptText("Enter Message");
		
		Button patientSendMessageButton = new Button("Send");
		patientSendMessageButton.setFont(new Font("Arial", 20));
		patientSendMessageButton.setDefaultButton(true);
		patientSendMessageButton.setOnAction(e -> {
			currentPatient.messageList.add(currentPatient.firstName + " " + currentPatient.lastName + ": " + patientMessageField.getText());
			text = "";
			for (int i = 0; i < currentPatient.messageList.size(); i++) {
				text += currentPatient.messageList.get(i) + "\n";
			}
			patientMessagesText.setText(text);
			patientMessageField.clear();
			
			// Save patientMessage File
			database.changeFile(currentPatient.messageFile);
			String[] temp = new String[currentPatient.messageList.size()]; // convert messages arraylist to array before passing
			currentPatient.messageList.toArray(temp);
			try {
				database.dataWrite(temp);
			} catch (IOException e1) {
				System.out.println("Error saving patient messages");
			}
			
		});
		
		VBox patientMessagesVBox = new VBox();
		patientMessagesVBox.getChildren().addAll(patientMessagesLabel, patientMessagesText, patientMessageField, patientSendMessageButton);
		
		// ================================== Patient Button and Tab Functions ================================= //
		// Set up patientTabs
		TabPane patientTabs = new TabPane();
		Tab patientContactInfoTab = new Tab();
		patientContactInfoTab.setText("Contact Information");
		Tab patientVisitSummaryTab = new Tab();
		patientVisitSummaryTab.setText("Visit Summaries");
		Tab patientMessagesTab = new Tab();
		patientMessagesTab.setText("Messages");
		
		patientTabs.getTabs().addAll(patientContactInfoTab, patientVisitSummaryTab, patientMessagesTab);
		
		patientBorder.setCenter(patientTabs);
		
		// Tab Functions \\
		patientContactInfoTab.setContent(patientContactInfoVBox);
		
		patientVisitSummaryTab.setOnSelectionChanged(e ->{
			patientVisitSummaryTab.setContent(patientVisitSummariesVBox);
			text = "";
			for (int ii = 0; ii < currentPatient.visitSummariesList.size(); ii++) {
				text += currentPatient.visitSummariesList.get(ii) + "\n";
			}
			patientVisitSummariesText.setText(text);
		});
		
		
		patientMessagesTab.setOnSelectionChanged(e -> {
			patientMessagesTab.setContent(patientMessagesVBox);
			currentPatient.messageList.add(currentPatient.firstName + " " + currentPatient.lastName + ": " + patientMessageField.getText());
			text = "";
			for (int ii = 0; ii < currentPatient.messageList.size(); ii++) {
				text += currentPatient.messageList.get(ii) + "\n";
			}
			patientMessagesText.setText(text);
			patientMessageField.clear();
		});
		
		
		patientContactInfoSaveButton.setOnAction(e -> {
			// SAVE STUFF
			patientFullNameField.setText(patientFullNameField.getText());
			patientEmailField.setText(patientEmailField.getText());
			patientPhoneNumberField.setText(patientPhoneNumberField.getText());
			patientInsuranceField.setText(patientInsuranceField.getText());
			// Save to file
			try {
				database.changeFile(currentPatient.patientID);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in patientContactInfoSaveButton");
			}
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
					if (database.getCurrentFileName().substring(0,1).equals("P")) { // ---------- Patient LOGIN
						String[] data = database.getCurrentData();
						try {
							// Create patient and load data into it
							currentPatient = new Patient(data[2], data[3], data[4], data[6], data[18], data[0], Integer.parseInt(data[5]), data[8], data[7], data[1],
									data[19], data[21], data[9], data[10], data[11]);
							// Update text on Patient page contact info
							patientNameLabel.setText(currentPatient.firstName + " " + currentPatient.lastName);
							patientFullNameField.setText(currentPatient.firstName + " " + currentPatient.lastName);
							patientEmailField.setText(currentPatient.email);
							patientPhoneNumberField.setText(currentPatient.phoneNumber);
							patientPharmacyField.setText(currentPatient.pharmacyInformation);
							patientInsuranceField.setText(currentPatient.insuranceInformation);
							
							// Load patient messages and visitSummaries
							try {
								database.changeFile(currentPatient.messageFile);
								data = database.getCurrentData();
								for(int i = 0; i < data.length; i++) {
									currentPatient.messageList.add(data[i]);
								}
								
								database.changeFile(currentPatient.visitSummariesFile);
								data = database.getCurrentData();
								for(int i = 0; i < data.length; i++) {
									currentPatient.visitSummariesList.add(data[i]);
								}
							} catch (FileNotFoundException e1) {
								System.out.println("Error loading patient messages");
							}
							
						} catch (NumberFormatException | IOException e1) {
							System.out.println("Error loading in patient information in GUI");
						}
						window.setScene(patientScene);
						
						
					} else if (database.getCurrentFileName().substring(0,1).equals("D")) { // -------- DOCTOR LOGIN
						String[] data = database.getCurrentData();
						// Create doctor and load data into it
						currentDoctor = new Doctor(data[0], data[1], data[2], data[3], data[4]);
						// Update doctor page text
						doctorWelcomeLabel1.setText("Hello, " + currentDoctor.lastName);
						doctorWelcomeLabel2.setText("Which patient are you seeing today?");
						// Extract the currentDoctor's patients and put them into its ArrayList
						database.changeFile(currentDoctor.patientFile);
						data = database.getCurrentData();
						for (int i = 0; i < data.length; i++) {
							doctorPatientListCombo.getItems().add(data[i]);
						}
						
						window.setScene(doctorSelectPatientScene);
						
					} else if (database.getCurrentFileName().substring(0,1).equals("N")) { // ---------- NURSE LOGIN
						String[] data = database.getCurrentData();
						// Create nurse and load data into it
						currentNurse = new Nurse(data[0], data[1], data[2], data[3], data[4], data[5]);
						// Update nurse page text
						nurseWelcomeLabel1.setText("Hello, " + currentNurse.firstName + " " + currentNurse.lastName);
						nurseWelcomeLabel2.setText("Which patient are you seeing today?");
						// Extract the currentNurse's patients and put them into its ArrayList
						database.changeFile(currentNurse.patientFile);
						data = database.getCurrentData();
						for (int i = 0; i < data.length; i++) {
							nursePatientListCombo.getItems().add(data[i]);
						}
						
						window.setScene(nurseSelectPatientScene);
					}
				} else {
					System.out.println("NoPass");
					loginWrongInfoLabel.setText("Incorrect Username or Password.");
				}
			} catch (FileNotFoundException e1) {
				System.out.println("Error in login section - Check if user has patients file");
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
							2021 - Integer.parseInt(CADateOfBirthField.getText().substring(6)), CAPharmacyField.getText(), CAInsuranceField.getText(),CAPasswordField.getText(),
							"P" + CAFirstNameField.getText().substring(0, 1) + CALastNameField.getText() + CADateOfBirthField.getText().substring(6) + "Messages",
							CADateOfBirthField.getText().substring(6) + "VisitSummaries", "null", "null", "null");
			} catch (NumberFormatException | IOException e2) {
				e2.printStackTrace();
			}
				try {
					// create and save patient and patientmessages file
					database.changeFile(newPatient.patientID);
					database.dataWrite(newPatient.generateStorageArray());
					database.changeFile(newPatient.messageFile);
					String[] temp = new String[newPatient.messageList.size()]; // convert messages arraylist to array before passing
					newPatient.messageList.toArray(temp);
					database.dataWrite(temp);
					// create and save patient visit summaries
					database.changeFile(newPatient.visitSummariesFile);
					temp = new String[newPatient.visitSummariesList.size()]; // convert visitSummaries arraylist to array before passing
					newPatient.visitSummariesList.toArray(temp);
					database.dataWrite(temp);
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
				
				
			
				
		// --------------------- SPECIAL BUTTON FUNCTIONS --------------------- //
		

		// Save button information at the bottom so that all objects have been instantiated
		patientContactInfoSaveButton.setOnAction(e -> {
			currentPatient.email = patientEmailField.getText();
			currentPatient.phoneNumber = patientPhoneNumberField.getText();
			currentPatient.pharmacyInformation = patientPharmacyField.getText();
			currentPatient.insuranceInformation = patientInsuranceField.getText();
			// Save info
			try {
				database.changeFile(currentPatient.patientID);
				database.dataWrite(currentPatient.generateStorageArray());
			} catch (IOException e1) {
				System.out.println("Error in datawrite Patient");
			}
			
		});
		
		// Nurse patient next button for selecting current patient
		nursePatientNextButton.setOnAction(e -> {
			if (nursePatientListCombo.getValue() != null) {
				database.changeFile(nursePatientListCombo.getValue());
			}
			String[] data;
			try {
				data = database.getCurrentData();
				try {
					currentPatient = new Patient(data[2], data[3], data[4], data[6], data[18], data[0], Integer.parseInt(data[5]), data[8], data[7], data[1],
							data[19], data[21], data[9], data[10], data[11]);
				} catch (NumberFormatException | IOException e1) {
					System.out.println("Error loading into currentPatient in nursePatientNextButton");
				}
				// Load patient's messages for nurse
				database.changeFile(currentPatient.messageFile);
				try {
					data = database.getCurrentData();
					for(int i = 0; i < data.length; i++) {
						currentPatient.messageList.add(data[i]);
					}
				} catch (FileNotFoundException e1) {
					System.out.println("Error loading patient messages for nurse");
				}
			} catch (FileNotFoundException e2) {
				System.out.println("Error loading patient data in nursePatientNextButton");
			}
			
			// Change labels for patient info
			nursePatientNameLabel.setText("Nurse " + currentNurse.lastName + ": " + " Seeing " + currentPatient.firstName + " " + currentPatient.lastName);		
			
			
			window.setScene(nurseScene);
		});
		
		// Doctor patient next button for selecting current patient
		doctorPatientNextButton.setOnAction(e -> {
			if (doctorPatientListCombo.getValue() != null) {
				database.changeFile(doctorPatientListCombo.getValue());
			}
			String[] data;
			try {
				data = database.getCurrentData();
				try {
					currentPatient = new Patient(data[2], data[3], data[4], data[6], data[18], data[0], Integer.parseInt(data[5]), data[8], data[7], data[1],
							data[19], data[21], data[9], data[10], data[11]);
				} catch (NumberFormatException | IOException e1) {
					System.out.println("Error loading into currentPatient in doctorPatientNextButton");
				}
				// Load patient's messages for nurse
				database.changeFile(currentPatient.messageFile);
				data = database.getCurrentData();
				for(int i = 0; i < data.length; i++) {
					currentPatient.messageList.add(data[i]);
				}
				// Load patients visitSummaries for doctor
				database.changeFile(currentPatient.visitSummariesFile);
				data = database.getCurrentData();
				for(int i = 0; i < data.length; i++) {
					currentPatient.visitSummariesList.add(data[i]);
				}
			} catch (FileNotFoundException e2) {
				System.out.println("Error loading patient data in doctorPatientNextButton");
			}
			
			// Change labels for patient info
			doctorPatientNameLabel.setText("Doctor " + currentDoctor.lastName + ": " + " Seeing " + currentPatient.firstName + " " + currentPatient.lastName);
			
			// Visit Summaries
			text = "";
			for (int i = 0; i < currentPatient.visitSummariesList.size(); i++) {
				text += currentPatient.visitSummariesList.get(i) + "\n";
			}
			doctorVisitSummaryText.setText(text);
			
			
			window.setScene(doctorScene);
		});
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		// ------------------------------------ Main -------------------------------------- //
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		window.show();
	}
	
	
}