package e1;

public class Ticket {
    String origin, destination, date;
    int price;

    public void setTicket(String origin, String destination, int price, String date) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

    @Override
    public String toString() {
        return (origin + " - " + destination + " " + price + "€ " + date + "\n");
    }
}