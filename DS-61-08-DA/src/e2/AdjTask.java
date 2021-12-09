import java.util.*;


package e2;





public class Graph{
    ArrayList<LinkedList<Task>> alist;

    Graph(){
        alist = new ArrayList<>();
    }

    public void addTask (Task task) {
        LinkedList<Taks> currentList = new LinkedList<>();
        currentList.add(task);
        alist.add(currentList);
    }
    public void addRelation (int source, int destination) {
        Task destinationTask = alist.get(destination).get(0);
        alist.get(source).add(destinationTask);

    }
    public void checkRelation (int source, int destination) {
        LinkedList<Task> currentList = alist.get(source);
        Task destinationTask = alist.get(destination).get(0);
        for(Task task : currentList){
            if(node == destinationTask) return true;
            return false;
        }
    }

    public void checkAncestors (int destination){
        alist.foreach(task) -> {if(checkRelation(alist.get(indexOf(task)),alist.get(destination)));
        else return false;}
        return true;
    }

    //make avaliable (push) since all algorithms need to know it (the bottom tasks just need to check if their list is only a head)

    public void Ancestors (){
        ArrayList <Task> ancestors = new ArrayList<>();
        alist.foreach(task) -> {if (checkAncestors(alist.indexOf(task)));
            else ancestors.add(alist.get(alist.indexOf(tak)));
        }
    }

    public void print(){
        for(LinkedList<Task> currentList : alist){
            for (Task task : currentList){
                System.out.print(task.ID + " -> ");
            }
        }
        System.out.println();
    }
}