package e1;

import java.util.ArrayList;

public class TicketManager {

    enum type {origin, destination, price, date}
    enum condition {LessThan, MoreThan, Equal, Null}

    public ArrayList<Ticket> tickets = new ArrayList<>();
    public ArrayList<Ticket> selection = new ArrayList<>();
    public ArrayList<Object> queue = new ArrayList<>();

    public void addTicket (String origin, String destination, int price, String date) {
        Ticket t = new Ticket();
        t.setTicket(origin, destination, price, date);
        tickets.add(t);
    }

    public void addOperatorToQueue(int operator) {
        if (queue.size() == 0) return;
        switch (operator) {
            case 0 -> {}
            case 1 -> queue.add(new AND());
            case 2 -> queue.add(new OR());
            default -> throw new IllegalArgumentException("Operator not valid!");
        }
    }

    public void addOrigin (int And1Or2, String content) {
        Origin o = new Origin();
        o.origin = content;
        addOperatorToQueue(And1Or2);
        queue.add(o);
    }

    public void addDestination (int And1Or2, String content) {
        Destination d = new Destination();
        d.destination = content;
        addOperatorToQueue(And1Or2);
        queue.add(d);
    }

    public void addPrice (int And1Or2, condition condition, int price) {
        Price d = new Price();
        d.price = price;
        d.con = condition;
        addOperatorToQueue(And1Or2);
        queue.add(d);
    }

    public void addDate (int And1Or2, String content) {
        Date d = new Date();
        d.date = content;
        addOperatorToQueue(And1Or2);
        queue.add(d);
    }

    public void search() {
        selection = tickets;
        for (int i = selection.size() - 1; i != -1; i--) {
            Ticket o = selection.get(i);
            new Origin().filter(o, selection, queue);
            new Destination().filter(o, selection, queue);
            new Price().filter(o, selection, queue);
            new Date().filter(o, selection, queue);
        }

        for (Ticket o : selection) {
            System.out.print(o.origin + " - " + o.destination + " " + o.price + "€ " + o.date + "\n");
        }
    }


    public void addCriteria(type type, String content)                                  { addCriteria(0, condition.Null, 0, type, content); }
    public void addCriteria(type type, condition condition, int price)                  { addCriteria(0, condition, price, type, ""); }
    public void addCriteria(int And1Or2, type type, String content)                     { addCriteria(And1Or2, condition.Null, 0, type, content); }
    public void addCriteria(int And1Or2, type type, condition condition, int price)     { addCriteria(And1Or2, condition, price, type, ""); }

    private void addCriteria (int And1Or2, condition condition, int price, type type, String content) {
        if ((And1Or2 == 0) && (queue.size() > 0)) And1Or2 = 2;
        switch (type) {
            case origin -> addOrigin(And1Or2, content);
            case destination -> addDestination(And1Or2, content);
            case price -> addPrice(And1Or2, condition, price);
            case date -> addDate(And1Or2, content);
        }
    }

}