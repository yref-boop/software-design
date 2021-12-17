package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Origin extends ObjectList<Origin> {

    public String origin;

    @Override
    public boolean meetsCondition(int i, ArrayList<ObjectList<?>> queue, Ticket ticket) {
        Origin o = (Origin) queue.get(i);
        return Objects.equals(o.origin, ticket.date);
    }
}
