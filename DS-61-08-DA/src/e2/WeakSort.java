package e2;

import java.util.ArrayList;
import java.util.List;

public class WeakSort implements SortingAlgorithm {

    public List<Task> function (ArrayList<Task> list, ArrayList<Task> hist){

        ArrayList<Task> aux = new ArrayList<>();

        List<Task> children = list.get(0).Children();

        for(Task task : children){
            if ((!(list.contains(task)))&&(!(hist.contains(task))))  aux.add(task);
        }

        System.out.print(list.get(0).getID());
        hist.add(list.get(0));

        list.remove(0);
        aux.addAll(list);
        if (!(aux.isEmpty())) aux.get(0).SortTasks(aux);

        if (!(aux.isEmpty())){
            System.out.print(" - ");
            function (aux, hist);
        } else System.out.println();
        return hist;
    }

    @Override
    public List<Task> sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        ArrayList<Task> done = new ArrayList<>();

        return function(sortlist, done);
    }
}
