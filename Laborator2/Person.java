package com.lab1;

public class Person {
    private String name;
    private String surname;
    private String age;
    private long ID;
    private String type;

    Person(String name, String surname, String age, long ID, String type) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ID = ID;
        this.type = type;

    }

    Person() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public long getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    void displayPersonData() {

        System.out.println("Name: " + this.name + ' ' + this.surname);
        System.out.println("Age: " + this.age);
        System.out.println("ID: " + this.ID);
        System.out.println("Type: " + this.type);
        System.out.println();
    }

    public boolean changeType() {

        if (this.type.equals("teacher")) {

            type = "doctor";
            return true;

        }
        return false;
    }
}
