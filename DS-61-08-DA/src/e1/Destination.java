package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Destination extends ObjectList<Destination> {

    public String destination;

    @Override
    public boolean meetsCondition(int i, ArrayList<ObjectList<?>> queue, Ticket ticket) {
        Destination d = (Destination) queue.get(i);
        return Objects.equals(d.destination, ticket.destination);
    }
}