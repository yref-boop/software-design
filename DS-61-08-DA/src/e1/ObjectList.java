package e1;

import java.util.ArrayList;

public abstract class ObjectList <type> extends TicketManager {

    public abstract boolean meetsCondition(int i, ArrayList<ObjectList<?>> list, Ticket ticket);

    public boolean isOperator () {
        return false;
    }

    public boolean operate(Ticket t, int i, ArrayList<ObjectList<?>> queue, Boolean right) {
        return false;
    }
}
