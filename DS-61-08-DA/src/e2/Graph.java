package e2;

import java.util.*;

public class Graph{
    ArrayList<LinkedList<Task>> alist;
    public final static Comparator<Task> comparator = new TaskComparator();
    private SortingAlgorithm algorithm;


    Graph(){
        alist = new ArrayList<>();
    }

    public void addTask (Task task) {
        LinkedList<Task> currentList = new LinkedList<>();
        currentList.add(task);
        alist.add(currentList);
    }
    public void addRelation (int source, int destination) {
        Task destinationTask = alist.get(destination).get(0);
        alist.get(source).add(destinationTask);

    }
    public boolean checkRelation (int source, int destination) {
        if(source == destination) return false;
        LinkedList<Task> currentList = alist.get(source);
        Task destinationTask = alist.get(destination).get(0);
        for(Task task : currentList){
            if(task == destinationTask) return true;
        }
        return false;
    }

    public boolean checkAncestors (int destination){
        for(LinkedList<Task> list : alist){
            if(checkRelation(alist.indexOf(list), destination)) return true;
        }
        return false;
    }

    public List<Integer> taskToInt (List<Task> tasks){
        List<Integer> ints = new ArrayList<>();
        for(Task task : tasks) {
            for (LinkedList<Task> list : alist) {
                if (list.get(0) == task) ints.add(alist.indexOf(list));
            }
        }
        return ints;
    }

    public List<Task> intToTask (List<Integer> list){
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
        return intToTask(ancestors);
    }

    public List<Task> SortTasks (List<Task> tasks){
        tasks.sort(comparator);
        return tasks;
    }

    public void printTask (Task task){
        System.out.print(task.ID);
    }

    public List<Task> Children(Task task){
        List<Task> children = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            if(list.get(0) == task) {
                for(Task tasks : list){
                    if(task != tasks) children.add(tasks);}}
        }
        return children;
    }

    public SortingAlgorithm getAlgorithm(){
        return algorithm;
    }

    public void setAlgorithm (SortingAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public void sortGraph(){
        algorithm.sort(this);
    }

    public void printGraph(){
        for(LinkedList<Task> currentList : alist){
            for (Task task : currentList){
                System.out.print(task.ID + " -> ");
            }
            System.out.print("\n");
        }
    }
}