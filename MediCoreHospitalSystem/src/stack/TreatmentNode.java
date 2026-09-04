package stack;

import model.TreatmentRecord;

public class TreatmentNode {

    TreatmentRecord treatment;
    TreatmentNode next;

    public TreatmentNode(
            TreatmentRecord treatment) {

        this.treatment = treatment;
    }
}