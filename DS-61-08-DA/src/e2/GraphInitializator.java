package e2;

import java.util.ArrayList;
import java.util.List;

public class GraphInitializator {
    private void readOne(List<Character> input, Graph graph){

        char ch1, ch2;
        ch1 = input.get(0);
        ch2 = input.get(5);

        boolean exists = false;
        for (Task tasks : graph.getAlist()){
            if (tasks.getID() == ch1) {
                tasks.addChild();
                exists = true;
                break;
            }
        }
        if (exists)

            Task t1 = new Task(ch1);
        Task t2 = new Task(task2);

        t1.addChild(t2);

        graph.addTask(t1);
        graph.addTask(t2);
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
