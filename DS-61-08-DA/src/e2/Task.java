package e2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task{

    private final char ID;
    private final static Comparator<Task> comparator = new TaskComparator();
    private LinkedList<Task> childlist;

    Task(char id){
        this.ID = id;
        childlist = new LinkedList<>();
    }

    public char getID(){return this.ID;}

    public void SortTasks (List<Task> tasks){tasks.sort(comparator);}

    public void addChild (Task task){ childlist.add(task);}

    public List<Task> Children (){ return childlist;}

    public boolean checkRelation (Task task) {
        for( Task child : childlist)
            if (task.ID == child.ID) return true;
        return false;
    }

}