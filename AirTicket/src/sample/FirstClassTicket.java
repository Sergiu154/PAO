package sample;

import java.util.List;

public class FirstClassTicket extends Ticket {

    private Boolean menuIncluded;
    private Boolean priority;

    public FirstClassTicket(Ticket t, Boolean menuIncluded, Boolean priority) {
        super(t);
        this.menuIncluded = menuIncluded;
        this.priority = priority;
    }

    public FirstClassTicket(String departureDate, String arrivalDate, Flight flightDetails, String departureLocation, String arrivalLocation, Boolean extraLuggage, double price, Boolean menuIncluded, Boolean priority) {

        super(departureDate, arrivalDate, flightDetails, departureLocation, arrivalLocation, extraLuggage, price);
        this.menuIncluded = menuIncluded;
        this.priority = priority;
    }


    public Boolean getMenuIncluded() {
        return menuIncluded;
    }

    public void setMenuIncluded(Boolean menuIncluded) {
        this.menuIncluded = menuIncluded;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public void printInfo() {
    }

    public List<String> getTicketInfo() {

        List<String> info = super.getTicketInfo();
        info.add("Menu included: " + (menuIncluded ? "Yes" : "No"));
        info.add("Priority Boarding: " + (priority ? "Yes" : "No"));
        return info;


    }
}
