package e2;

import java.util.ArrayList;
import java.util.List;

public class StrongSort implements SortingAlgorithm {

    public void function (ArrayList<Task> list, Graph graph, ArrayList<Task> hist){

        ArrayList<Task> aux = new ArrayList<>();

        List<Task> children = graph.Children(list.get(0));

        graph.printTask(list.get(0));
        hist.add(list.get(0));

        for(Task task : children){
            if ((!(list.contains(task)))&&(!(hist.contains(task)))&&(hist.containsAll(graph.Parents(task))))
                aux.add(task);
        }

        list.remove(0);
        aux.addAll(list);
        graph.SortTasks(aux);

        if (!(aux.isEmpty())){
            System.out.print(" - ");
            function (aux, graph, hist);
        } else System.out.println();
    }



    @Override
    public void sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        ArrayList<Task> hist = new ArrayList<>();

        function(sortlist, graph, hist);
    }
}
