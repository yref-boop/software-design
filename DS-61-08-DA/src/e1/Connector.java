package e1;

import java.util.ArrayList;

public abstract class Connector extends ObjectList {

    @Override
    public boolean doesNotMeetCondition(int i, ArrayList<ObjectList> list, Ticket ticket) {
        return true;
    }

    @Override
    public boolean isNotOperator() {
        return false;
    }

    public boolean notAnymoreClassInList(int i, ArrayList<ObjectList> list, Class<?> c) {
        //if (i < 2) return false;
        for (int j = 0; j < i + 1; j++)
            if (list.get(j).getClass() == c) return false;
        return true;
    }

    public int next(int i, ArrayList<ObjectList> list, Class<?> c) {
        for (int j = i; j >= 0; j--)
            if (list.get(j).getClass() == c) return j;
        return -1;
    }
}