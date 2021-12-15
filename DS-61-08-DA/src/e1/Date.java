package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Date implements Characteristic<Date> {
    public String date;

    @Override
    public boolean meetsCondition(Date p, Ticket ticket) {
        return Objects.equals(p.date, ticket.date);
    }

    @Override
    public void filter(Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue) {
        boolean keep = true;
        for (Object o : queue) {
            if (o.getClass().equals(Date.class)) {
                keep = new AND().operate(queue.indexOf(o), meetsCondition((Date) o, element), keep, queue);
                keep = new OR().operate(queue.indexOf(o), meetsCondition((Date) o, element), keep, queue);
            }
        }
        if (!keep) selection.remove(element);
    }
}
