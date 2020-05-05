package sample;

import java.util.HashMap;

public class Flight {

    private String flightID;
    private Airplane airplane;
    private String planeType;
    HashMap<Seat, Boolean> ticketsPurchased;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return company + ',' + date + ',' + time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Flight(String company, String date, String time) {
        this.company = company;
        this.date = date;
        this.time = time;
    }

    private String company;
    private String departureAirport;
    private String arrivalAirport;
    private String date;
    private String time;

    public Flight() {
    }

    public Flight(String flightID, String planeType, String company, String departureAirport, String arrivalAirport) {
        this.flightID = flightID;
        this.planeType = planeType;
        this.company = company;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
