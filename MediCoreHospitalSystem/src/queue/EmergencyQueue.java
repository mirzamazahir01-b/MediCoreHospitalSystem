package queue;

import model.Patient;

public class EmergencyQueue {

    private EmergencyNode front;
    private EmergencyNode rear;

    public void enqueue(Patient patient) {

        EmergencyNode newNode =
                new EmergencyNode(patient);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Patient dequeue() {

        if (front == null) {
            throw new IllegalStateException(
                    "Emergency queue is empty.");
        }

        Patient patient = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    public void display() {

        if (front == null) {
            System.out.println(
                    "Emergency queue is empty.");
            return;
        }

        EmergencyNode current = front;

        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}