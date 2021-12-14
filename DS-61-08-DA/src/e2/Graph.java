package e2;
import java.util.*;

public class Graph{
    ArrayList<LinkedList<Task>> alist;
    private final static Comparator<Task> comparator = new TaskComparator();
    private SortingAlgorithm algorithm;

    Graph(){
        alist = new ArrayList<>();
    }

    public void printGraph(){
        for(LinkedList<Task> currentList : alist){
            for (Task task : currentList){
                System.out.print(task.getID() + " -> ");
            }
            System.out.print("\n");
        }
    }

    public void addTask (Task task) {
        LinkedList<Task> currentList = new LinkedList<>();

        if(taskToPos (task) == -1){ currentList.add(task); alist.add(currentList);}

    }

    public void addRelation (Task source, Task destination) {
        int s_pos = taskToPos(source);
        int d_pos = taskToPos(destination);

        Task destinationTask = alist.get(d_pos).get(0);
        alist.get(s_pos).add(destinationTask);
    }

    public boolean checkRelation (int source, int destination) {
        if(source == destination) return false;
        LinkedList<Task> currentList = alist.get(source);
        Task destinationTask = alist.get(destination).get(0);
        for(Task task : currentList){
            if(task.getID() == destinationTask.getID()) return true;
        }
        return false;
    }

    public boolean checkAncestors (int destination){
        for(LinkedList<Task> list : alist){
            if(checkRelation(alist.indexOf(list), destination)) return true;
        }
        return false;
    }

    private int taskToPos (Task task){
        for (LinkedList<Task> list : alist) {
            if ((list != null)&&(list.get(0).getID() == task.getID()))return alist.indexOf(list);
        }
        return -1;
    }

    private List<Task> posToTask (List<Integer> list){
        List<Task> tasks = new ArrayList<>();
        for (int n : list){
            tasks.add(alist.get(n).get(0));
        }
        return tasks;
    }

    public List<Task> Ancestors (){
        List<Integer> ancestors = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            if(!(checkAncestors(alist.indexOf(list)))) ancestors.add(alist.indexOf(list));
        }
        return posToTask(ancestors);
    }

    public void SortTasks (List<Task> tasks){tasks.sort(comparator);}

    public List<Task> Parents (Task task){
        List<Task> parents = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            for(Task ntask : list){
                if ((ntask.getID() == task.getID())&&(list.indexOf(ntask)!=0)) parents.add(list.get(0));
            }
        }
        return parents;
    }

    public List<Task> Children(Task task){
        List<Task> children = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            if(list.get(0).getID() == task.getID()) {
                for(Task tasks : list){
                    if(task.getID() != tasks.getID()) children.add(tasks);}}
        }
        return children;
    }

    public SortingAlgorithm getAlgorithm(){return algorithm;}

    public void setAlgorithm (SortingAlgorithm algorithm){this.algorithm = algorithm;}

    public void sortGraph(){algorithm.sort(this);}
}