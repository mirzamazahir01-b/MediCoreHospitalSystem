package bst;

import model.Patient;

public class PatientBST {

    private PatientNode root;

    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(
            PatientNode current,
            Patient patient) {

        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {

            current.left = insertRecursive(
                    current.left,
                    patient);

        } else if (patient.getPatientId() > current.patient.getPatientId()) {

            current.right = insertRecursive(
                    current.right,
                    patient);

        } else {
            throw new IllegalArgumentException(
                    "Patient ID already exists: "
                    + patient.getPatientId());
        }

        return current;
    }

    public Patient search(int patientId) {
        PatientNode result = searchRecursive(root, patientId);

        return result == null ? null : result.patient;
    }

    private PatientNode searchRecursive(
            PatientNode current,
            int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private PatientNode deleteRecursive(
            PatientNode current,
            int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(
                    current.left,
                    patientId);

        } else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(
                    current.right,
                    patientId);

        } else {

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            Patient successor = findMinimum(
                    current.right);

            current.patient = successor;

            current.right = deleteRecursive(
                    current.right,
                    successor.getPatientId());
        }

        return current;
    }

    private Patient findMinimum(PatientNode node) {

        PatientNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current.patient;
    }

    public void displayInOrder() {
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(
            PatientNode current) {

        if (current == null) {
            return;
        }

        displayInOrderRecursive(current.left);

        System.out.println(current.patient);

        displayInOrderRecursive(current.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}