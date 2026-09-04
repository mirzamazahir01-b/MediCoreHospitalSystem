package stack;

import model.TreatmentRecord;

public class TreatmentStack {

    private TreatmentNode top;

    public void push(
            TreatmentRecord treatment) {

        TreatmentNode newNode =
                new TreatmentNode(treatment);

        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {

        if (top == null) {
            throw new IllegalStateException(
                    "Treatment stack is empty.");
        }

        TreatmentRecord treatment =
                top.treatment;

        top = top.next;

        return treatment;
    }

    public void display() {

        if (top == null) {
            System.out.println(
                    "Treatment stack is empty.");
            return;
        }

        TreatmentNode current = top;

        while (current != null) {

            System.out.println(
                    current.treatment);

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}