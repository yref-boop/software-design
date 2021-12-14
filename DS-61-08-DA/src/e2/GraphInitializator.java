package e2;

import java.util.ArrayList;
import java.util.List;

public class GraphInitializator {
    private void readOne(List<Character> input, Graph graph){

        char task1, task2;
        task1 = input.get(0);
        task2 = input.get(5);

        Task t1 = new Task(task1);
        Task t2 = new Task(task2);

        graph.addTask(t1);
        graph.addTask(t2);

        graph.addRelation(t1, t2);

    }

    public Graph readInput (List<Character> input) {

        Graph graph = new Graph();
        int i = 0;
        int size = input.size();
        List<Character> aux = new ArrayList<>();

        while (i < size) {


            if (input.get(i) != '\n') {
                aux.add(input.get(i));
            } else {
                readOne(aux, graph);
                aux.clear();
            }
            i++;
        }
        return graph;
    }
}
