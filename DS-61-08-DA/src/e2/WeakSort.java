package e2;

import java.util.ArrayList;
import java.util.List;

public class WeakSort implements SortingAlgorithm {

    public void function (ArrayList<Task> list, Graph graph){

        ArrayList<Task> aux = new ArrayList<>();

        List<Task> children = graph.Children(list.get(0));

        for(Task task : children){
            if (!(list.contains(task)))  aux.add(task);
        }

        graph.printTask(list.get(0));

        list.remove(0);
        aux.addAll(list);
        graph.SortTasks(aux);

        if (!(list.isEmpty())){
            System.out.print(" - ");
            function (aux, graph);
        }
    }

    @Override
    public void sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        function(sortlist, graph);
    }
}
