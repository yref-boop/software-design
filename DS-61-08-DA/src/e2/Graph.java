package e2;
import java.util.*;

public class Graph{
    private List<Task> alist;
    private SortingAlgorithm algorithm;

    Graph(){ alist = new ArrayList<>();}

    public List<Task> getAlist() { return alist; }

    public void addTask (Task task) {
        if(taskToPos (task) == -1){
            alist.add(task);
        }
    }

    private int taskToPos (Task task){
        for (Task tasks : alist)
            if ((tasks != null) && (tasks.getID() == task.getID())) return alist.indexOf(tasks);
        return -1;
    }

    public List<Task> Ancestors (){
        List<Task> ancestors = new ArrayList<>();
        boolean anc = true;

        for(Task task1 : alist){
            for(Task task2 : alist) {
                if (task2.checkRelation(task1)) {
                    anc = true;
                    break;
                } else anc = false;
            }
            if(!anc) ancestors.add(task1);
        }
        return (ancestors);
    }

    public List<Task> Parents (Task task){
        List<Task> parents = new ArrayList<>();

        for(Task tasks : alist)
            for (Task child : tasks.Children())
                if (child.getID() == task.getID())
                    parents.add(tasks);

        return parents;
    }

    public void printGraph(){
        for (Task tasks : alist){
            System.out.print(tasks.getID() + " -> ");
            for (Task child : tasks.Children())
                System.out.print(child.getID() + " -> ");
            System.out.println("");
        }
    }

    public SortingAlgorithm getAlgorithm() { return algorithm; }

    public void setAlgorithm (SortingAlgorithm algorithm){ this.algorithm = algorithm; }

    public List<Task> sortGraph(){ return algorithm.sort(this); }
}