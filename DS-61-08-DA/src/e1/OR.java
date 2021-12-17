package e1;

import java.util.ArrayList;

public class OR extends Connector {

    @Override
    public boolean operate(Ticket t, int i, ArrayList<ObjectList> queue, Boolean right) {
        if (right != null && !right) return false;

        for (; i >= 0; i--) {
            ObjectList o = queue.get(i);
            if (o.getClass() == queue.get(i).getClass()) {
                if (i == 0 || notAnymoreClassInList(i, queue, o.getClass()))
                    return o.doesNotMeetCondition(i, queue, t);
                ObjectList connector = queue.get(i - 1);
                return connector.operate(t, next(i - 1, queue, o.getClass()), queue, o.doesNotMeetCondition(i, queue, t));
            }
        }
        return false;
    }
}

