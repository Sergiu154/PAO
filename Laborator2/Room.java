package com.lab1;

public class Room {
    private String roomNumber;
    private String roomType;
    private int floor;


    Room(String number, String type, int floor) {

        this.roomType = type;
        this.roomNumber = number;
        this.floor = floor;
    }

    Room() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getFloor() {
        return floor;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    void displayRoom() {

        System.out.println("Room number: " + this.roomNumber);
        System.out.println("Room type: " + this.roomType);
        System.out.println("Floor: " + this.floor);
        System.out.println();

    }
}
