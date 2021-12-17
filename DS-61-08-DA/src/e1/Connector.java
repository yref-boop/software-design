package e1;

import java.util.ArrayList;

public abstract class Connector extends ObjectList<Connector> {

    @Override
    public boolean meetsCondition(int i, ArrayList<ObjectList<?>> list, Ticket ticket) {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}