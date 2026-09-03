package model;

public class Patient {

    private final int patientId;
    private final String name;
    private final int age;
    private final String contactNumber;
    private final String medicalCondition;

    public Patient(
            int patientId,
            String name,
            int age,
            String contactNumber,
            String medicalCondition) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    @Override
    public String toString() {
        return String.format(
            "Patient ID: %d | Name: %s | Age: %d | Contact: %s | Condition: %s",
            patientId,
            name,
            age,
            contactNumber,
            medicalCondition
        );
    }
}