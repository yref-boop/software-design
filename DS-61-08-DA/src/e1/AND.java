package e1;

import java.util.ArrayList;

public class AND extends Connector {

    @Override
    public boolean operate(Ticket t, int i, ArrayList<ObjectList<?>> queue, Boolean right) {
        if (right != null && right) return true;

        for (; i >= 0; i--) {
            ObjectList<?> o = queue.get(i);
            if (o.getClass() == queue.get(i).getClass()) {
                if (i == 0 || !queue.get(i - 1).isOperator()) return !o.meetsCondition(i, queue, t);
                ObjectList<?> connector = queue.get(i - 1);
                return connector.operate(t, i - 2, queue, !o.meetsCondition(i, queue, t));
            }
        }
        return false;
    }
}
