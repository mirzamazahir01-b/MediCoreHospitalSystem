package queue;

import model.Patient;

public class EmergencyNode {

    Patient patient;
    EmergencyNode next;

    public EmergencyNode(Patient patient) {
        this.patient = patient;
    }
}
