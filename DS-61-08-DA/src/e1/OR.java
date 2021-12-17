package e1;

import java.util.ArrayList;

public class OR extends Connector {

    @Override
    public boolean operate(Ticket t, int i, ArrayList<ObjectList<?>> queue, boolean right) {
        if (right) return true;

        for (int j = i; j > 0; j--) {
            ObjectList<?> o = queue.get(j);
            if (o.getClass() == queue.get(i + 1).getClass()) {
                if (!queue.get(j - 1).isOperator()) return o.meetsCondition(j, queue, t);
                ObjectList<?> connector = queue.get(j - 1);
                return connector.operate(t, j, queue, o.meetsCondition(j, queue, t));
            }
        }
        return false;
    }
}

