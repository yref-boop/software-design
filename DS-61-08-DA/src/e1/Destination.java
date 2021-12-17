package e1;

import java.util.ArrayList;
import java.util.Objects;

public class Destination extends ObjectList {

    public String destination;

    @Override
    public boolean doesNotMeetCondition(int i, ArrayList<ObjectList> queue, Ticket ticket) {
        Destination d = (Destination) queue.get(i);
        return !Objects.equals(d.destination, ticket.destination);
    }
}