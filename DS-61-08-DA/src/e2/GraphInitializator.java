package e2;

import java.util.ArrayList;
import java.util.List;

public class GraphInitializator {
    private void readOne(List<Character> input, Graph graph){

        char ch1, ch2;
        ch1 = input.get(0);
        ch2 = input.get(5);

        boolean exists1 = false;
        boolean exists2 = false;

        Task X = null;
        Task Y = null;

        for (Task tasks : graph.getAlist()){
            if (tasks.getID() == ch1) {
                exists1 = true;
                X = tasks;
                break;
            }
        }
        for (Task tasks : graph.getAlist()){
            if (tasks.getID() == ch2) {
                exists2 = true;
                Y = tasks;
                break;
            }
        }
        if (exists1 && exists2) X.addChild(Y);
        if (exists1 && !exists2){
            Y = new Task(ch2);
            graph.addTask(Y);
            X.addChild(Y);
        }
        if(!exists1 && exists2){
            X = new Task(ch1);
            graph.addTask(X);
            X.addChild(Y);
        }
        if(!exists1 && !exists2){
            X = new Task(ch1);
            Y = new Task(ch2);
            graph.addTask(X);
            graph.addTask(Y);
            X.addChild(Y);
        }
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
