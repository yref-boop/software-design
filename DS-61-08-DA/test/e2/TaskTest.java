package e2;

import org.junit.Assert;
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

    public Graph givenOrphanGraph(){
        Graph graph = new Graph();

        Task A = new Task ('A');
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

    public Graph newGraph(){
            Graph graph = new Graph();

            Task A = new Task ('A');     //0
            Task B = new Task ('B');    //1
            Task C = new Task ('C');    //2
            Task D = new Task ('D');    //3
            Task E = new Task ('E');    //4
            Task F = new Task ('F');    //5
            Task G = new Task ('G');    //6
            Task H = new Task ('H');    //7
            Task J = new Task ('J');    //8

            A.addChild(B);
            A.addChild(D);
            B.addChild(E);
            C.addChild(A);
            C.addChild(F);
            D.addChild(E);
            F.addChild(E);
            F.addChild(J);
            G.addChild(F);
            G.addChild(H);
            H.addChild(J);

            graph.addTask(A);
            graph.addTask(B);
            graph.addTask(C);
            graph.addTask(D);
            graph.addTask(E);
            graph.addTask(F);
            graph.addTask(G);
            graph.addTask(H);
            graph.addTask(J);

            graph.printGraph();

            return graph;
    }

    /*public Graph givenGraph(){
        Graph graph = new Graph();

        Task A = new Task ('A');     //0
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

        graph.addRelation(A,B);
        graph.addRelation(A,D);
        graph.addRelation(B,E);
        graph.addRelation(C,A);
        graph.addRelation(C,F);
        graph.addRelation(D,E);
        graph.addRelation(F,E);
        graph.addRelation(F,J);
        graph.addRelation(G,F);
        graph.addRelation(G,H);
        graph.addRelation(H,J);

        return graph;
    }*/

    @Test
    public void EmptyGraphInitialization(){
        Graph graph = new Graph();
    }

    @Test
    public void orphanGraphInitialization(){
        Graph graph = givenOrphanGraph();
    }

    @Test
    public void graphInitialization(){
        Graph graph = newGraph();
    }

    @Test
    public void getAncestors(){
        Graph graph = newGraph();
        List<Task> ancestors = new ArrayList<>();
    }
/*
    @Test
    public void getChildren(){
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

        graph.addRelation(A,B);
        graph.addRelation(A,D);
        graph.addRelation(B,E);
        graph.addRelation(C,A);
        graph.addRelation(C,F);
        graph.addRelation(D,E);
        graph.addRelation(F,E);
        graph.addRelation(F,J);
        graph.addRelation(G,F);
        graph.addRelation(G,H);
        graph.addRelation(H,J);

        List<Task> children = graph.Children(A);

    }*/

    @Test
    public void sortHierarchical(){
        Graph graph = newGraph();
        graph.setAlgorithm(new HierarchicalSort());
        graph.sortGraph();

    }

    @Test
    public void sortWeak(){
        Graph graph = newGraph();
        graph.setAlgorithm(new WeakSort());
        graph.sortGraph();

    }

    @Test
    public void sortStrong(){
        Graph graph = newGraph();
        graph.setAlgorithm(new StrongSort());
        graph.sortGraph();
    }

    /*

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

        graph.addRelation(A,B);
        graph.addRelation(A,D);
        graph.addRelation(B,E);
        graph.addRelation(C,A);
        graph.addRelation(C,F);
        graph.addRelation(D,E);
        graph.addRelation(F,E);
        graph.addRelation(F,J);
        graph.addRelation(G,F);
        graph.addRelation(G,H);
        graph.addRelation(H,J);

        List<Task> Parents = graph.Parents(F);

    }*/

    @Test
    public void InputTest(){
        Graph graph;

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

        GraphInitializator granny = new GraphInitializator();
        graph = granny.readInput(input);
    }

    @Test
    public void AllSorts(){

        Graph graph;

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

        GraphInitializator granny = new GraphInitializator();
        graph = granny.readInput(input);

        graph.printGraph();

        Task A = new Task ('A');     //0
        Task B = new Task ('B');    //1
        Task C = new Task ('C');    //2
        Task D = new Task ('D');    //3
        Task E = new Task ('E');    //4
        Task F = new Task ('F');    //5
        Task G = new Task ('G');    //6
        Task H = new Task ('H');    //7
        Task J = new Task ('J');    //8

        A.addChild(B);
        A.addChild(D);
        B.addChild(E);
        C.addChild(A);
        C.addChild(F);
        D.addChild(E);
        F.addChild(E);
        F.addChild(J);
        G.addChild(F);
        G.addChild(H);
        H.addChild(J);

        List<Task> StrongCheck = new ArrayList<>();
        StrongCheck.add(C);
        StrongCheck.add(A);
        StrongCheck.add(B);
        StrongCheck.add(D);
        StrongCheck.add(G);
        StrongCheck.add(F);
        StrongCheck.add(E);
        StrongCheck.add(H);
        StrongCheck.add(J);

        List<Task> WeakCheck = new ArrayList<>();
        WeakCheck.add(C);
        WeakCheck.add(A);
        WeakCheck.add(B);
        WeakCheck.add(D);
        WeakCheck.add(E);
        WeakCheck.add(F);
        WeakCheck.add(G);
        WeakCheck.add(H);
        WeakCheck.add(J);

        List<Task> HierarchyCheck = new ArrayList<>();
        HierarchyCheck.add(C);
        HierarchyCheck.add(G);
        HierarchyCheck.add(A);
        HierarchyCheck.add(F);
        HierarchyCheck.add(H);
        HierarchyCheck.add(B);
        HierarchyCheck.add(D);
        HierarchyCheck.add(E);
        HierarchyCheck.add(J);

        assertThrows(NullPointerException.class, graph::sortGraph);

        graph.setAlgorithm(new StrongSort());
        System.out.println(graph.getAlgorithm());
        assertEquals(StrongCheck,graph.sortGraph());

        graph.setAlgorithm(new WeakSort());
        System.out.println(graph.getAlgorithm());
        assertEquals(WeakCheck,graph.sortGraph());

        graph.setAlgorithm(new HierarchicalSort());
        System.out.println(graph.getAlgorithm());
        assertEquals(HierarchyCheck,graph.sortGraph());

    }
}
