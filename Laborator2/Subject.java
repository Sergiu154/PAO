package com.lab1;

public class Subject {

    private Room room;
    private int noOfStudents;
    private Person teacher;

    Subject(Room room, int noOfStudents, Person teacher) {

        this.room = room;
        this.noOfStudents = noOfStudents;
        this.teacher = teacher;

    }

    Subject() {
    }

    public Room getRoom() {
        return room;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    void displaySubject() {

        this.room.displayRoom();
        this.teacher.displayPersonData();
        System.out.println("Nuber of students: " + this.noOfStudents);
        System.out.println("----------------------------------------");

    }
}
