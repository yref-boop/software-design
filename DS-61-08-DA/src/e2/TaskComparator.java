package e2;

import java.util.Comparator;

class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        if((task1 == null)||(task2==null))
            throw new NullPointerException();
        int code1 = task1.getID();
        int code2 = task2.getID();
        return (code1 - code2);

    }
}