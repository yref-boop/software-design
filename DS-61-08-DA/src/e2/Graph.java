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

    private List<Integer> taskToPosition (List<Task> tasks){
        List<Integer> ints = new ArrayList<>();
        for(Task task : tasks) {
            for (LinkedList<Task> list : alist) {
                if (list.get(0) == task) ints.add(alist.indexOf(list));
            }
        }
        return ints;
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

    public void SortTasks (List<Task> tasks){
        tasks.sort(comparator);
    }

    public List<Task> Parents (Task task){
        List<Task> parents = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            for(Task ntask : list){
                if ((ntask == task)&&(list.indexOf(ntask)!=0)) parents.add(list.get(0));
            }
        }
        return parents;
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

    //todo: finnish this function
    public void readInput(List<Character> input){

        Graph graph = new Graph();

        char task1, task2;
        task1 = input.get(0);
        task2 = input.get(6);

        new Task(task1);
        new Task(task2);

        graph.addRelation(1,2);



    }
}