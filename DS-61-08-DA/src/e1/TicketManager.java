package e1;

import java.util.ArrayList;

public class TicketManager {

    enum type {origin, destination, price, date}
    enum condition {LessThan, MoreThan, Equal, Null}
    enum connector {OR, AND, Null}

    private final ArrayList<Ticket> tickets = new ArrayList<>();
    private final ArrayList<Object> queue = new ArrayList<>();

    public void addTicket (String origin, String destination, int price, String date) {
        Ticket t = new Ticket();
        t.setTicket(origin, destination, price, date);
        tickets.add(t);
    }

    private void addOperatorToQueue(connector connector) {
        if (queue.size() == 0) return;
        switch (connector.toString()) {
            case "Null" -> {}
            case "OR" -> queue.add(new OR());
            case "AND" -> queue.add(new AND());
            default -> throw new IllegalArgumentException("Operator not valid!");
        }
    }

    private void addOrigin (connector connector, String content) {
        Origin o = new Origin();
        o.origin = content;
        addOperatorToQueue(connector);
        queue.add(o);
    }

    private void addDestination (connector connector, String content) {
        Destination d = new Destination();
        d.destination = content;
        addOperatorToQueue(connector);
        queue.add(d);
    }

    private void addPrice (connector connector, condition condition, int price) {
        Price d = new Price();
        d.price = price;
        d.con = condition;
        addOperatorToQueue(connector);
        queue.add(d);
    }

    private void addDate (connector connector, String content) {
        Date d = new Date();
        d.date = content;
        addOperatorToQueue(connector);
        queue.add(d);
    }

    public ArrayList<Ticket> search() {
        ArrayList<Ticket> selection = tickets;
        for (int i = 0; i < selection.size(); i++) {
            Ticket o = selection.get(i);
            new Origin().filter(o, selection, queue);
            new Destination().filter(o, selection, queue);
            new Price().filter(o, selection, queue);
            new Date().filter(o, selection, queue);
        }
        return selection;
    }

    public String ticketsToString(ArrayList<Ticket> list) {
        if (list.isEmpty()) return "";
        StringBuilder output = new StringBuilder();
        for (Ticket t : list)
            output.append(t.toString());
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }


    public void addCriteria(type type, String content)                                          { addCriteria(connector.Null, condition.Null, 0, type, content); }
    public void addCriteria(type type, condition condition, int price)                          { addCriteria(connector.Null, condition, price, type, ""); }
    public void addCriteria(connector connector, type type, String content)                     { addCriteria(connector, condition.Null, 0, type, content); }
    public void addCriteria(connector connector, type type, condition condition, int price)     { addCriteria(connector, condition, price, type, ""); }

    private void addCriteria (connector c, condition condition, int price, type type, String content) {
        //if ((c == connector.Null) && (queue.size() > 0)) c = connector.OR;
        if (type == TicketManager.type.price && price <= 0) throw new IllegalArgumentException("Price must be positive");
        switch (type) {
            case origin -> addOrigin(c, content);
            case destination -> addDestination(c, content);
            case price -> addPrice(c, condition, price);
            case date -> addDate(c, content);
        }
    }

}