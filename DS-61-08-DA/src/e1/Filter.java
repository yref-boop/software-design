package e1;

import java.util.ArrayList;

public class Filter implements Characteristic<Object> {

    public Object object;

    @Override
    public boolean meetsCondition(Object p, Ticket ticket) {
        return false;
    }

    @Override
    public void filter(Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue) {
        boolean keep = true;
        for (Object o : queue) {
            if (o.getClass().equals(object.class)) {
                keep = new AND().operate(queue.indexOf(o), meetsCondition((Object) o, element), keep, queue);
                keep = new OR().operate(queue.indexOf(o), meetsCondition((Object) o, element), keep, queue);
            }
        }
        if (!keep) selection.remove(element);
    }
}
