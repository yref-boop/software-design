package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Destination implements Characteristic<Destination> {
    public String destination;

    @Override
    public boolean meetsCondition(Destination d, Ticket ticket) {
        return Objects.equals(d.destination, ticket.destination);
    }

    @Override
    public void filter(Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue) {
        new Filter()
        boolean keep = true;
        for (Object o : queue) {
            if (o.getClass().equals(Destination.class)) {
                keep = new AND().operate(queue.indexOf(o), meetsCondition((Destination) o, element), keep, queue);
                keep = new OR().operate(queue.indexOf(o), meetsCondition((Destination) o, element), keep, queue);
            }
        }
        if (!keep) selection.remove(element);
    }
}