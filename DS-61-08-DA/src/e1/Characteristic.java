package e1;

import java.util.ArrayList;

public interface Characteristic<ClassType> {
   boolean meetsCondition(ClassType p, Ticket ticket);
   void filter (Ticket element, ArrayList<Ticket> selection, ArrayList<Object> queue);
}
