package e2;
import java.util.*;

public class Graph{
    ArrayList<LinkedList<Task>> alist;
    private SortingAlgorithm algorithm;

    Graph(){alist = new ArrayList<>();}

    public void addTask (Task task) {
        LinkedList<Task> currentList = new LinkedList<>();
        if(taskToPos (task) == -1){
            currentList.add(task);
            alist.add(currentList);
        }
    }

    public void addRelation (Task source, Task destination) {
        int s_pos = taskToPos(source);
        int d_pos = taskToPos(destination);
        Task destinationTask = alist.get(d_pos).get(0);
        alist.get(s_pos).add(destinationTask);
    }

    private boolean checkRelation (int source, int destination) {
        if(source == destination) return false;
        LinkedList<Task> currentList = alist.get(source);
        Task destinationTask = alist.get(destination).get(0);
        for(Task task : currentList)
            if(task.getID() == destinationTask.getID()) return true;
        return false;
    }

    private int taskToPos (Task task){
        for (LinkedList<Task> list : alist)
            if ((list != null) && (list.get(0).getID() == task.getID()))return alist.indexOf(list);
        return -1;
    }

    public List<Task> Ancestors (){
        List<Task> ancestors = new ArrayList<>();
        boolean anc = true;

        for(LinkedList<Task> list : alist){
            for(LinkedList<Task> tlist : alist){
                if(checkRelation(alist.indexOf(tlist), alist.indexOf(list))) {anc = true; break;}
                else anc = false;
            }
            if(!anc) ancestors.add(alist.get(alist.indexOf(list)).get(0));
        }
        return (ancestors);
    }

    public List<Task> Parents (Task task){
        List<Task> parents = new ArrayList<>();

        for(LinkedList<Task> list : alist)
            for(Task ntask : list)
                if ((ntask.getID() == task.getID())&&(list.indexOf(ntask)!=0)) parents.add(list.get(0));
        return parents;
    }

    public List<Task> Children(Task task){
        List<Task> children = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            if(list.get(0).getID() == task.getID()) {
                for(Task tasks : list)
                    if(task.getID() != tasks.getID()) children.add(tasks);
            }
        }
        return children;
    }

    public SortingAlgorithm getAlgorithm(){return algorithm;}

    public void setAlgorithm (SortingAlgorithm algorithm){this.algorithm = algorithm;}

    public void sortGraph(){algorithm.sort(this);}
}