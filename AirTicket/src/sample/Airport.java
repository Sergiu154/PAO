package sample;

import java.util.List;

public class Airport {

    private String location;
    private String name;
    private List<Flight> availableFlights;

    public Airport() {
    }

    public Airport(String location, String name, List<Flight> availableFlighs) {
        this.location = location;
        this.name = name;
        this.availableFlights = availableFlighs;
    }

    public Airport(String location, String name) {
        this.location = location;
        this.name = name;
    }

    @Override
    public String toString() {

        return location + ',' + name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getAvailableFlighs() {
        return availableFlights;
    }

    public void setAvailableFlighs(List<Flight> availableFlighs) {
        this.availableFlights = availableFlighs;
    }
}
