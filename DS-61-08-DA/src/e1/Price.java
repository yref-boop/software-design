package e1;

import java.util.ArrayList;
import e1.TicketManager.condition;

public class Price implements Characteristic<Price> {
    public int price;
    public condition con;

    @Override
    public boolean meetsCondition(Price p, Ticket ticket) {
        return (p.con == condition.LessThan && ticket.price < p.price)
            || (p.con == condition.MoreThan && ticket.price > p.price)
            || (p.con == condition.Equal && ticket.price == p.price);
    }

    @Override
    public void filter(Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue) {
        boolean keep = true;
        for (Object o : queue) {
            if (o.getClass().equals(Price.class)) {
                keep = new AND().operate(queue.indexOf(o), meetsCondition((Price) o, element), keep, queue);
                keep = new OR().operate(queue.indexOf(o), meetsCondition((Price) o, element), keep, queue);
            }
        }
        if (!keep) selection.remove(element);
    }
}