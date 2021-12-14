package e2;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//adjacency list:

//A -> B -> D
//B -> E
//C -> A -> F
//D -> E
//E ->
//F -> E -> J
//G -> H -> F
//H -> J
//J ->


public class TaskTest {

    //todo: implement and correct tests: coverage now: class 100%, method 88%, line 88%, branch84%

    public Graph givenOrphanGraph(){
        Graph graph = new Graph();

        Task A = new Task('A');
        Task B = new Task ('B');
        Task C = new Task ('C');
        Task D = new Task ('D');
        Task E = new Task ('E');
        Task F = new Task ('F');
        Task G = new Task ('G');
        Task H = new Task ('H');
        Task J = new Task ('J');

        graph.addTask(A);
        graph.addTask(B);
        graph.addTask(C);
        graph.addTask(D);
        graph.addTask(E);
        graph.addTask(F);
        graph.addTask(G);
        graph.addTask(H);
        graph.addTask(J);

        return graph;
    }

    public Graph givenGraph(){
        Graph graph = new Graph();

        Task A = new Task('A');     //0
        Task B = new Task ('B');    //1
        Task C = new Task ('C');    //2
        Task D = new Task ('D');    //3
        Task E = new Task ('E');    //4
        Task F = new Task ('F');    //5
        Task G = new Task ('G');    //6
        Task H = new Task ('H');    //7
        Task J = new Task ('J');    //8

        graph.addTask(A);
        graph.addTask(B);
        graph.addTask(C);
        graph.addTask(D);
        graph.addTask(E);
        graph.addTask(F);
        graph.addTask(G);
        graph.addTask(H);
        graph.addTask(J);

        graph.addRelation(0,1);
        graph.addRelation(0,3);
        graph.addRelation(1,4);
        graph.addRelation(2,0);
        graph.addRelation(2,5);
        graph.addRelation(3,4);
        graph.addRelation(5,4);
        graph.addRelation(5,8);
        graph.addRelation(6,5);
        graph.addRelation(6,7);
        graph.addRelation(7,8);

        return graph;
    }

    @Test
    public void EmptyGraphInitialization(){
        Graph graph = new Graph();
        graph.printGraph();
    }

    @Test
    public void orphanGraphInitialization(){
        Graph graph = givenOrphanGraph();
        graph.printGraph();
    }

    @Test
    public void graphInitialization(){
        Graph graph = givenGraph();
        graph.printGraph();
    }

    @Test
    public void checkRelations(){
        Graph graph = givenGraph();

        assertTrue(graph.checkRelation(0,1));
        assertTrue(graph.checkRelation(0,3));
        assertTrue (graph.checkRelation(1,4));
        assertTrue (graph.checkRelation(2,0));
        assertTrue (graph.checkRelation(2,5));
        assertTrue (graph.checkRelation(3,4));
        assertTrue (graph.checkRelation(5,4));
        assertTrue(graph.checkRelation(5,8));
        assertTrue(graph.checkRelation(6,5));
        assertTrue(graph.checkRelation(6,7));
        assertTrue(graph.checkRelation(7,8));

        assertFalse(graph.checkRelation(0,4));
        assertFalse(graph.checkRelation(1,2));
        assertFalse(graph.checkRelation(4,3));

        assertThrows(IndexOutOfBoundsException.class, () -> graph.checkRelation(7,10));
        assertThrows(IndexOutOfBoundsException.class, () -> graph.checkRelation(102,10));
        assertThrows(IndexOutOfBoundsException.class, () -> graph.checkRelation(-435,-1));

    }

    @Test
    public void getAncestors(){
        Graph graph = givenGraph();
        List<Task> ancestors = new ArrayList<>();
    }

    @Test
    public void getChildren(){
        Graph graph = new Graph();

        Task A = new Task('A');     //0
        Task B = new Task ('B');    //1
        Task C = new Task ('C');    //2
        Task D = new Task ('D');    //3
        Task E = new Task ('E');    //4
        Task F = new Task ('F');    //5
        Task G = new Task ('G');    //6
        Task H = new Task ('H');    //7
        Task J = new Task ('J');    //8

        graph.addTask(A);
        graph.addTask(B);
        graph.addTask(C);
        graph.addTask(D);
        graph.addTask(E);
        graph.addTask(F);
        graph.addTask(G);
        graph.addTask(H);
        graph.addTask(J);

        graph.addRelation(0,1);
        graph.addRelation(0,3);
        graph.addRelation(1,4);
        graph.addRelation(2,0);
        graph.addRelation(2,5);
        graph.addRelation(3,4);
        graph.addRelation(5,4);
        graph.addRelation(5,8);
        graph.addRelation(6,5);
        graph.addRelation(6,7);
        graph.addRelation(7,8);

        List<Task> children = graph.Children(A);

    }

    @Test
    public void sortHierarchical(){
        Graph graph = givenGraph();
        graph.setAlgorithm(new HierarchicalSort());
        graph.sortGraph();

    }

    @Test
    public void sortWeak(){
        Graph graph = givenGraph();
        graph.setAlgorithm(new WeakSort());
        graph.sortGraph();

    }

    @Test
    public void sortStrong(){
        Graph graph = givenGraph();
        graph.setAlgorithm(new StrongSort());
        graph.sortGraph();
    }

    @Test
    public void ParentsTest(){
        Graph graph = new Graph();

        Task A = new Task ('A');    //0
        Task B = new Task ('B');    //1
        Task C = new Task ('C');    //2
        Task D = new Task ('D');    //3
        Task E = new Task ('E');    //4
        Task F = new Task ('F');    //5
        Task G = new Task ('G');    //6
        Task H = new Task ('H');    //7
        Task J = new Task ('J');    //8

        graph.addTask(A);
        graph.addTask(B);
        graph.addTask(C);
        graph.addTask(D);
        graph.addTask(E);
        graph.addTask(F);
        graph.addTask(G);
        graph.addTask(H);
        graph.addTask(J);

        graph.addRelation(0,1);
        graph.addRelation(0,3);
        graph.addRelation(1,4);
        graph.addRelation(2,0);
        graph.addRelation(2,5);
        graph.addRelation(3,4);
        graph.addRelation(5,4);
        graph.addRelation(5,8);
        graph.addRelation(6,5);
        graph.addRelation(6,7);
        graph.addRelation(7,8);

        List<Task> Parents = graph.Parents(F);

    }

    @Test
    public void InputTest(){
        Graph graph = new Graph();

        Character[] chars = {
        'C',' ','-', '>',' ','A','\n',
        'C',' ','-', '>',' ','F','\n',
        'A',' ','-', '>',' ','B','\n',
        'A',' ','-', '>',' ','D','\n',
        'B',' ','-', '>',' ','E','\n',
        'D',' ','-', '>',' ','E','\n',
        'F',' ','-', '>',' ','E','\n',
        'G',' ','-', '>',' ','F','\n',
        'G',' ','-', '>',' ','H','\n',
        'F',' ','-', '>',' ','J','\n',
        'H',' ','-', '>',' ','J','\n'};

        List<Character> input = new ArrayList<>(Arrays.asList(chars));

        graph = graph.readInput(input);

        graph.printGraph();
    }

    @Test
    public void AllSorts(){

        Graph graph = givenGraph();

        assertThrows(NullPointerException.class, graph::sortGraph);

        graph.setAlgorithm(new StrongSort());
        System.out.println(graph.getAlgorithm());
        graph.sortGraph();

        graph.setAlgorithm(new WeakSort());
        System.out.println(graph.getAlgorithm());
        graph.sortGraph();

        graph.setAlgorithm(new HierarchicalSort());
        System.out.println(graph.getAlgorithm());
        graph.sortGraph();

    }
}
