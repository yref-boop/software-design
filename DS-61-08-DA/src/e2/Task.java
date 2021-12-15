package e2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task{

    private final char ID;
    private final static Comparator<Task> comparator = new TaskComparator();
    private LinkedList<Character> childlist;

    Task(char id){
        this.ID = id;
    }

    public char getID(){
        return this.ID;
    }

    public void SortTasks (List<Task> tasks){
        tasks.sort(comparator);
    }

}