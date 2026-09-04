package app;

import java.util.Scanner;

import model.Patient;
import model.TreatmentRecord;
import model.Visit;
import service.HospitalService;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    private static final HospitalService hospital =
            new HospitalService();



public static void main(String[] args) {

    showWelcome();

    runMainMenu();

    scanner.close();
}

private static void showWelcome() {

    System.out.println();

    System.out.println(
            "╔══════════════════════════════════════════════╗");

    System.out.println(
            "║          MEDICORE HOSPITAL SYSTEM           ║");

    System.out.println(
            "║      Emergency Management Platform           ║");

    System.out.println(
            "╚══════════════════════════════════════════════╝");

    System.out.println();
}

private static void runMainMenu() {

    boolean running = true;

    while (running) {

        displayMainMenu();

        int choice =
                readInt("Enter your choice: ");

        switch (choice) {

            case 1:
                registerPatient();
                break;

            case 2:
                searchPatient();
                break;

            case 3:
                deletePatient();
                break;

            case 4:
                displayPatients();
                break;

            case 5:
                addEmergencyPatient();
                break;

            case 6:
                callNextEmergencyPatient();
                break;

            case 7:
                completeTreatment();
                break;

            case 8:
                displayTreatmentHistory();
                break;

            case 9:
                addPatientVisit();
                break;

            case 10:
                searchPatientVisit();
                break;

            case 11:
                removePatientVisit();
                break;

            case 12:
                displayPatientVisitHistory();
                break;

            case 0:
                running = false;

                System.out.println();
                System.out.println(
                        "Thank you for using MediCore Hospital System.");

                break;

            default:
                System.out.println();
                System.out.println(
                        "Invalid option. Please try again.");
        }
    }
}

private static void displayMainMenu() {

    System.out.println();

    System.out.println(
            "╔══════════════════════════════════════════════╗");

    System.out.println(
            "║                 MAIN MENU                    ║");

    System.out.println(
            "╠══════════════════════════════════════════════╣");

    System.out.println(
            "║  1. Register New Patient                    ║");

    System.out.println(
            "║  2. Search Patient                          ║");

    System.out.println(
            "║  3. Delete Patient                          ║");

    System.out.println(
            "║  4. Display All Patients                    ║");

    System.out.println(
            "║  5. Add Patient to Emergency Queue          ║");

    System.out.println(
            "║  6. Call Next Emergency Patient             ║");

    System.out.println(
            "║  7. Complete Treatment                      ║");

    System.out.println(
            "║  8. Display Treatment History               ║");

    System.out.println(
            "║  9. Add Patient Visit                       ║");

    System.out.println(
            "║ 10. Search Patient Visit                    ║");

    System.out.println(
            "║ 11. Remove Patient Visit                    ║");

    System.out.println(
            "║ 12. Display Patient Visit History           ║");

    System.out.println(
            "║  0. Exit                                    ║");

    System.out.println(
            "╚══════════════════════════════════════════════╝");

    System.out.println();
}

private static void registerPatient() {

    System.out.println();

    System.out.println(
            "╔══════════════════════════════════════════════╗");

    System.out.println(
            "║              PATIENT REGISTRATION            ║");

    System.out.println(
            "╚══════════════════════════════════════════════╝");

    int patientId =
            readInt("Enter Patient ID: ");

    String name =
            readText("Enter Patient Name: ");

    int age =
            readInt("Enter Age: ");

    String contact =
            readText("Enter Contact Number: ");

    String condition =
            readText("Enter Medical Condition: ");

    Patient patient =
            new Patient(
                    patientId,
                    name,
                    age,
                    contact,
                    condition
            );

    try {

        hospital.registerPatient(patient);

        System.out.println();
        System.out.println(
                "✓ Patient registered successfully.");

    } catch (IllegalArgumentException e) {

        System.out.println();
        System.out.println(
                "✗ " + e.getMessage());
    }
}

private static void searchPatient() {

    System.out.println();

    System.out.println(
            "========== SEARCH PATIENT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();
        System.out.println(
                "✗ Patient not found.");

        return;
    }

    System.out.println();

    System.out.println(
            "╭──────── PATIENT FOUND ────────╮");

    System.out.println(
            "  Patient ID : "
            + patient.getPatientId());

    System.out.println(
            "  Name       : "
            + patient.getName());

    System.out.println(
            "  Age        : "
            + patient.getAge());

    System.out.println(
            "  Contact    : "
            + patient.getContactNumber());

    System.out.println(
            "  Condition  : "
            + patient.getMedicalCondition());

    System.out.println(
            "╰───────────────────────────────╯");
}

private static void deletePatient() {

    System.out.println();

    System.out.println(
            "========== DELETE PATIENT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();
        System.out.println(
                "✗ Patient not found.");

        return;
    }

    hospital.deletePatient(patientId);

    System.out.println();
    System.out.println(
            "✓ Patient deleted successfully.");
}

private static void displayPatients() {

    System.out.println();

    System.out.println(
            "========== PATIENT RECORDS ==========");

    if (hospital == null) {
        return;
    }

    hospital.displayAllPatients();
}

private static void addEmergencyPatient() {

    System.out.println();

    System.out.println(
            "======= EMERGENCY QUEUE =======");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();
        System.out.println(
                "✗ Patient not found.");

        return;
    }

    hospital.addEmergencyPatient(patient);

    System.out.println();

    System.out.println(
            "✓ Patient added to emergency queue.");
}

private static void displayEmergencyQueue() {

    System.out.println();

    System.out.println(
            "======= EMERGENCY PATIENTS =======");

    hospital.displayEmergencyQueue();
}

private static void callNextEmergencyPatient() {

    System.out.println();

    System.out.println(
            "====== NEXT EMERGENCY PATIENT ======");

    try {

        Patient patient =
                hospital.callNextEmergencyPatient();

        System.out.println();

        System.out.println(
                "✓ Calling patient:");

        System.out.println(
                patient);

    } catch (IllegalStateException e) {

        System.out.println();

        System.out.println(
                "✗ No patients are waiting.");
    }
}

private static void completeTreatment() {

    System.out.println();

    System.out.println(
            "========== COMPLETE TREATMENT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();

        System.out.println(
                "✗ Patient not found.");

        return;
    }

    String treatment =
            readText("Enter Treatment: ");

    String doctor =
            readText("Enter Doctor Name: ");

    String date =
            readText("Enter Completion Date: ");

    TreatmentRecord record =
            new TreatmentRecord(
                    patient.getPatientId(),
                    patient.getName(),
                    treatment,
                    doctor,
                    date
            );

    hospital.completeTreatment(record);

    System.out.println();

    System.out.println(
            "✓ Treatment completed and recorded.");
}

private static void displayTreatmentHistory() {

    System.out.println();

    System.out.println(
            "========== TREATMENT HISTORY ==========");

    hospital.displayTreatmentHistory();
}

private static void addPatientVisit() {

    System.out.println();

    System.out.println(
            "========== ADD PATIENT VISIT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();

        System.out.println(
                "✗ Patient not found.");

        return;
    }

    int visitId =
            readInt("Enter Visit ID: ");

    String date =
            readText("Enter Visit Date: ");

    String doctor =
            readText("Enter Doctor Name: ");

    String diagnosis =
            readText("Enter Diagnosis: ");

    String treatment =
            readText("Enter Treatment: ");

    Visit visit =
            new Visit(
                    visitId,
                    date,
                    doctor,
                    diagnosis,
                    treatment
            );

    hospital.addPatientVisit(
            patientId,
            visit);

    System.out.println();

    System.out.println(
            "✓ Visit added successfully.");
}

private static void searchPatientVisit() {

    System.out.println();

    System.out.println(
            "========== SEARCH VISIT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    int visitId =
            readInt("Enter Visit ID: ");

    Visit visit =
            hospital.searchPatientVisit(
                    patientId,
                    visitId);

    if (visit == null) {

        System.out.println();

        System.out.println(
                "✗ Visit not found.");

        return;
    }

    System.out.println();

    System.out.println(
            "✓ Visit found:");

    System.out.println();

    System.out.println(visit);
}

private static void removePatientVisit() {

    System.out.println();

    System.out.println(
            "========== REMOVE VISIT ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    int visitId =
            readInt("Enter Visit ID: ");

    boolean removed =
            hospital.removePatientVisit(
                    patientId,
                    visitId);

    if (removed) {

        System.out.println();

        System.out.println(
                "✓ Visit removed successfully.");

    } else {

        System.out.println();

        System.out.println(
                "✗ Visit not found.");
    }
}

private static void displayPatientVisitHistory() {

    System.out.println();

    System.out.println(
            "========== PATIENT VISIT HISTORY ==========");

    int patientId =
            readInt("Enter Patient ID: ");

    Patient patient =
            hospital.searchPatient(patientId);

    if (patient == null) {

        System.out.println();

        System.out.println(
                "✗ Patient not found.");

        return;
    }

    System.out.println();

    System.out.println(
            "Patient: "
            + patient.getName());

    System.out.println();

    hospital.displayPatientVisitHistory(
            patientId);
}

private static int readInt(String message) {

    while (true) {

        System.out.print(message);

        String input =
                scanner.nextLine().trim();

        try {

            return Integer.parseInt(input);

        } catch (NumberFormatException e) {

            System.out.println();

            System.out.println(
                    "✗ Please enter a valid number.");
        }
    }
}

private static String readText(String message) {

    while (true) {

        System.out.print(message);

        String input =
                scanner.nextLine().trim();

        if (!input.isEmpty()) {

            return input;
        }

        System.out.println();

        System.out.println(
                "✗ This field cannot be empty.");
    }
}
}