package sample;

public class DiscountTicket extends Ticket {

    private double discount;
    private String discountCard;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(String discountCard) {
        this.discountCard = discountCard;
    }
}
