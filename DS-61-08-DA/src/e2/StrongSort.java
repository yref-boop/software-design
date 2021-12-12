package e2;

import java.util.ArrayList;
import java.util.List;

public class StrongSort implements SortingAlgorithm {

    public void function (ArrayList<Task> list, Graph graph){

        ArrayList<Task> aux = new ArrayList<>();

        List<Task> children = graph.Children(list.get(0));

        for(Task task : children){
            if (!(list.contains(task)))  aux.add(task);
        }

        graph.SortTasks(aux);

        graph.printTask(list.get(0));
        list.remove(0);
        list.addAll(aux);

        if (!(list.isEmpty())){
            System.out.print(" - ");
            function (list, graph);
        }
    }

    @Override
    public void sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        function(sortlist, graph);
    }
}
