package e2;

import java.util.ArrayList;
import java.util.LinkedList;

public class WeakSort implements SortingAlgorithm {

    public void function (ArrayList<Task> list, Graph graph){

        LinkedList<Task> aux = new LinkedList<>();

    }

    @Override
    public void sort(Graph graph) {
        ArrayList<Task> sortlist = new ArrayList<>(graph.Ancestors());
        function(sortlist, graph);
    }
}
