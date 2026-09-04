package service;

import java.util.HashMap;
import java.util.Map;

import linkedlist.VisitHistory;
import model.Visit;

public class PatientVisitRegistry {

    private final Map<Integer, VisitHistory> histories;

    public PatientVisitRegistry() {

        histories = new HashMap<>();
    }

    public void addVisit(
            int patientId,
            Visit visit) {

        VisitHistory history =
                histories.computeIfAbsent(
                        patientId,
                        id -> new VisitHistory()
                );

        history.addVisit(visit);
    }

    public Visit searchVisit(
            int patientId,
            int visitId) {

        VisitHistory history =
                histories.get(patientId);

        if (history == null) {
            return null;
        }

        return history.searchVisit(visitId);
    }

    public boolean removeVisit(
            int patientId,
            int visitId) {

        VisitHistory history =
                histories.get(patientId);

        if (history == null) {
            return false;
        }

        return history.removeVisit(visitId);
    }

    public void displayPatientHistory(
            int patientId) {

        VisitHistory history =
                histories.get(patientId);

        if (history == null) {

            System.out.println(
                    "No visit history found.");

            return;
        }

        history.displayHistory();
    }
}