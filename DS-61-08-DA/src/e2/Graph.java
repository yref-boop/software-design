package e2;

import java.util.*;

public class Graph{
    ArrayList<LinkedList<Task>> alist;

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

    //make avaliable (push) since all algorithms need to know it (the bottom tasks just need to check if their list is only a head)

    public List<Integer> Ancestors (){
        List<Integer> ancestors = new ArrayList<>();

        for(LinkedList<Task> list : alist){
            if(!(checkAncestors(alist.indexOf(list)))) ancestors.add(alist.indexOf(list));
        }
        return ancestors;
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