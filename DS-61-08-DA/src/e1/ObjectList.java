package e1;

import java.util.ArrayList;

public abstract class ObjectList extends TicketManager {

    public abstract boolean doesNotMeetCondition(int i, ArrayList<ObjectList> list, Ticket ticket);

    public boolean isNotOperator() {
        return true;
    }

    public boolean operate(Ticket t, int i, ArrayList<ObjectList> queue, Boolean right) {
        return false;
    }
}
