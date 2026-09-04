# MediCore Hospital Emergency Management System

## Project Description

MediCore is a Java-based Mini Hospital Emergency Management System developed
using fundamental data structures.

The system manages patient records, emergency patients, completed treatments,
and patient visit histories.

## Data Structures Used

### 1. Binary Search Tree

The Binary Search Tree stores patient records using Patient ID as the key.

Operations:

- Insert patient
- Search patient
- Delete patient
- In-order traversal

### 2. Queue

The Emergency Queue manages patients waiting for emergency treatment.

The queue follows the FIFO principle:

First-In, First-Out.

Operations:

- Enqueue
- Dequeue
- Display queue

### 3. Stack

The Treatment Stack stores completed treatment records.

The stack follows the LIFO principle:

Last-In, First-Out.

Operations:

- Push
- Pop
- Display treatment history

### 4. Singly Linked List

Each patient can have a visit history containing previous hospital visits.

Operations:

- Add visit
- Search visit
- Remove visit
- Display visit history

## Project Structure

```text
src
├── model
├── bst
├── queue
├── stack
├── linkedlist
├── service
└── app