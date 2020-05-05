package sample;

import java.util.ArrayList;
import java.util.List;

public class Ticket implements Comparable<Ticket> {


    private String departureDate;
    private String arrivalDate;
    private Flight flightDetails;
    private String departureLocation;
    private String arrivalLocation;
    private Boolean oneWay;
    private int ticketNums;

    public int getTicketNums() {
        return ticketNums;
    }

    public void setTicketNums(int ticketNums) {
        this.ticketNums = ticketNums;
    }

    private Boolean extraLuggage;
    private double price;

    public Ticket(String departureDate, String arrivalDate, String departureLocation, String arrivalLocation, Boolean oneWay, Boolean extraLuggage) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.oneWay = oneWay;
        this.extraLuggage = extraLuggage;
    }

    @Override
    public String toString() {
        return departureDate + "," +
                arrivalDate + ',' +
                departureLocation + ',' +
                arrivalLocation + ',' +
                oneWay;
    }

    public Boolean getOneWay() {
        return oneWay;
    }

    public void setOneWay(Boolean oneWay) {
        this.oneWay = oneWay;
    }

    @Override
    public int compareTo(Ticket o) {

        return departureDate.compareTo(o.departureDate);
    }

    public Ticket(String departureDate, String arrivalDate, String departureLocation, String arrivalLocation, Boolean oneWay) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.oneWay = oneWay;
    }

    public Ticket() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ticket(String departureDate, String arrivalDate, Flight flighDetails, String departureLocation, String arrivalLocation, Boolean extraLuggage, double price) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightDetails = flighDetails;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.extraLuggage = extraLuggage;
        this.price = price;

    }

    public Ticket(Ticket t) {
        this.departureDate = t.departureDate;
        this.arrivalDate = t.arrivalDate;
        this.flightDetails = t.flightDetails;
        this.departureLocation = t.departureLocation;
        this.arrivalLocation = t.arrivalLocation;
        this.extraLuggage = t.extraLuggage;
        this.price = t.price;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public Boolean getExtraLuggage() {
        return extraLuggage;
    }

    public void setExtraLuggage(Boolean extraLuggage) {
        this.extraLuggage = extraLuggage;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Flight getFlighDetails() {
        return flightDetails;
    }

    public void setFlighDetails(Flight flighDetails) {
        this.flightDetails = flighDetails;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public List<String> getTicketInfo() {

        List<String> info = new ArrayList<>();
        info.add("Departure: " + this.getDepartureDate() + " " + this.getDepartureLocation());
        if (this.getArrivalDate() != null)
            info.add("Arrival: " + this.getArrivalDate() + " " + this.getArrivalLocation());

        return info;


    }
}
