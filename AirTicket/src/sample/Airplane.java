package sample;

public class Airplane {

    private int capacity;
    private String typeOfAirplane;

    public Airplane() {
    }

    public Airplane(int capacity, String typeOfAirplane) {
        this.capacity = capacity;
        this.typeOfAirplane = typeOfAirplane;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTypeOfAirplane() {
        return typeOfAirplane;
    }

    public void setTypeOfAirplane(String typeOfAirplane) {
        this.typeOfAirplane = typeOfAirplane;
    }
}
