package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Origin implements Characteristic<Origin> {
    public String origin;

    @Override
    public boolean meetsCondition(Origin o, Ticket ticket) {
        return Objects.equals(o.origin, ticket.origin);
    }

    @Override
    public void filter(Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue) {
        boolean keep = true;
        for (Object o : queue) {
            if (o.getClass().equals(Origin.class)) {
                keep = new AND().operate(queue.indexOf(o), meetsCondition((Origin) o, element), keep, queue);
                keep = new OR().operate(queue.indexOf(o), meetsCondition((Origin) o, element), keep, queue);
            }
        }
        if (!keep) selection.remove(element);
    }
}
