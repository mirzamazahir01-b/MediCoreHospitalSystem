package model;

public class TreatmentRecord {

    private final int patientId;
    private final String patientName;
    private final String treatment;
    private final String doctorName;
    private final String completionDate;

    public TreatmentRecord(
            int patientId,
            String patientName,
            String treatment,
            String doctorName,
            String completionDate) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.doctorName = doctorName;
        this.completionDate = completionDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    @Override
    public String toString() {
        return String.format(
            "Patient ID: %d | Patient: %s | Treatment: %s | Doctor: %s | Completed: %s",
            patientId,
            patientName,
            treatment,
            doctorName,
            completionDate
        );
    }
}
