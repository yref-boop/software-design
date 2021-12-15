package e1;

import java.util.ArrayList;

public class AND implements Operations {
    @Override
    public boolean operate(int i, boolean meetsCondition, boolean keep, ArrayList<Object> queue) {
        if (i != 0) {
            if (queue.get(i - 1).getClass() == AND.class)
                return keep && meetsCondition;
                else
                return keep;
        }
        else return meetsCondition;
    }
}
