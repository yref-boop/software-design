package e2;

import java.util.ArrayList;
import java.util.List;

public class HierarchicalSort implements SortingAlgorithm {

    public void function (ArrayList<Task> list, Graph graph, ArrayList<Task> hist){

        ArrayList<Task> aux = new ArrayList<>();

        List<Task> children = graph.Children(list.get(0));

        for(Task task : children){
            if ((!(list.contains(task)))&&(!(hist.contains(task))))  aux.add(task);
        }

        graph.SortTasks(aux);

        System.out.print(list.get(0).getID());
        hist.add(list.get(0));

        list.remove(0);
        list.addAll(aux);

        if (!(list.isEmpty())){
            System.out.print(" - ");
            function (list, graph, hist);
        } else System.out.println();
    }

    @Override
    public void sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        ArrayList<Task> hist = new ArrayList<>();

        function(sortlist, graph, hist);
    }
}
