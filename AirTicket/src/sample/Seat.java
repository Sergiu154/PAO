package sample;


import java.util.Objects;

public class Seat {

    private String seatNumber;
    private Boolean typeofSeat;

    public Seat() {
    }

    public Seat(String seatNumber, Boolean typeofSeat) {
        this.seatNumber = seatNumber;
        this.typeofSeat = typeofSeat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, typeofSeat);
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Boolean getTypeofSeat() {
        return typeofSeat;
    }

    public void setTypeofSeat(Boolean typeofSeat) {
        this.typeofSeat = typeofSeat;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Seat))
            return false;

        Seat seat = (Seat) obj;

        return seat.typeofSeat == typeofSeat && seatNumber.equals(seat.seatNumber);


    }
}
