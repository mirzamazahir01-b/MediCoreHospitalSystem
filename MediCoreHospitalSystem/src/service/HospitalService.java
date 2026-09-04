package service;

import bst.PatientBST;
import linkedlist.VisitHistory;
import model.Patient;
import model.TreatmentRecord;
import model.Visit;
import queue.EmergencyQueue;
import stack.TreatmentStack;

public class HospitalService {

    private final PatientBST patientBST;
    private final EmergencyQueue emergencyQueue;
    private final TreatmentStack treatmentStack;
    private final PatientVisitRegistry visitRegistry;

    public HospitalService() {
        patientBST = new PatientBST();
        emergencyQueue = new EmergencyQueue();
        treatmentStack = new TreatmentStack();
        visitRegistry = new PatientVisitRegistry();
    }

    // ==============================
    // PATIENT MANAGEMENT
    // ==============================

    public void registerPatient(Patient patient) {
        patientBST.insert(patient);
    }

    public Patient searchPatient(int patientId) {
        return patientBST.search(patientId);
    }

    public void deletePatient(int patientId) {
        patientBST.delete(patientId);
    }

    public void displayAllPatients() {
        patientBST.displayInOrder();
    }

    // ==============================
    // EMERGENCY QUEUE
    // ==============================

    public void addEmergencyPatient(Patient patient) {
        emergencyQueue.enqueue(patient);
    }

    public Patient callNextEmergencyPatient() {
        return emergencyQueue.dequeue();
    }

    public void displayEmergencyQueue() {
        emergencyQueue.display();
    }

    // ==============================
    // TREATMENT HISTORY
    // ==============================

    public void completeTreatment(
            TreatmentRecord treatment) {

        treatmentStack.push(treatment);
    }

    public TreatmentRecord undoLastTreatment() {
        return treatmentStack.pop();
    }

    public void displayTreatmentHistory() {
        treatmentStack.display();
    }
    
 // ==========================================
    // PATIENT VISIT REGISTRY
    // ==========================================

    public void addPatientVisit(
            int patientId,
            Visit visit) {

        visitRegistry.addVisit(
                patientId,
                visit);
    }

    public Visit searchPatientVisit(
            int patientId,
            int visitId) {

        return visitRegistry.searchVisit(
                patientId,
                visitId);
    }

    public boolean removePatientVisit(
            int patientId,
            int visitId) {

        return visitRegistry.removeVisit(
                patientId,
                visitId);
    }

    public void displayPatientVisitHistory(
            int patientId) {

        visitRegistry.displayPatientHistory(
                patientId);
    }

    // ==============================
    // PATIENT VISIT HISTORY
    // ==============================

    public VisitHistory createVisitHistory() {
        return new VisitHistory();
    }

    public void addVisit(
            VisitHistory history,
            Visit visit) {

        history.addVisit(visit);
    }

    public Visit searchVisit(
            VisitHistory history,
            int visitId) {

        return history.searchVisit(visitId);
    }

    public boolean removeVisit(
            VisitHistory history,
            int visitId) {

        return history.removeVisit(visitId);
    }

    public void displayVisitHistory(
            VisitHistory history) {

        history.displayHistory();
    }
}