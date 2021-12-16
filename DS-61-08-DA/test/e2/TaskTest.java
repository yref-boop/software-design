package e2;

import org.junit.jupiter.api.Test;

import java.awt.event.HierarchyBoundsAdapter;
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

            //check that they are not inserted twice:
            graph.addTask(A);
            graph.addTask(B);
            graph.addTask(C);
            graph.addTask(D);
            graph.addTask(E);
            graph.addTask(F);
            graph.addTask(G);
            graph.addTask(H);
            graph.addTask(J);

            //check that a null task does not get inserted:
            Task N = null;
            graph.addTask(N);

            return graph;
    }


    @Test
    public void sortHierarchical(){
        System.out.println("Hierarchical sort:");
        Graph graph = newGraph();
        graph.setAlgorithm(new HierarchicalSort());
        graph.sortGraph();
        for (Task task :graph.sortGraph()){
            System.out.print(task.getID() + " - ");
        }
        System.out.println();
    }

    @Test
    public void sortWeak(){
        System.out.println("Weak dependency sort:");
        Graph graph = newGraph();
        graph.setAlgorithm(new WeakSort());
        graph.sortGraph();
        for (Task task :graph.sortGraph()){
            System.out.print(task.getID() + " - ");
        }
        System.out.println();
    }

    @Test
    public void sortStrong(){
        System.out.println("Strong dependency sort:");
        Graph graph = newGraph();
        graph.setAlgorithm(new StrongSort());
        for (Task task :graph.sortGraph()){
            System.out.print(task.getID() + " - ");
        }
        System.out.println();
    }

    @Test
    public void InputTest(){
        Graph graph_in, graph;

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

        GraphInitializator ginny = new GraphInitializator();
        graph_in = ginny.readInput(input);
        graph = newGraph();

    }

    @Test
    public void NullSorts(){
        Graph graph = new Graph();
        graph.setAlgorithm(new StrongSort());
        assertNull(graph.sortGraph());
        graph.setAlgorithm(new WeakSort());
        assertNull(graph.sortGraph());
        graph.setAlgorithm(new HierarchicalSort());
        assertNull(graph.sortGraph());
    }

    @Test
    public void MainTest(){

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

        GraphInitializator ginny = new GraphInitializator();
        graph = ginny.readInput(input);

        Task A = new Task ('A');    //0
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

        StrongSort ss = new StrongSort();

        graph.setAlgorithm(ss);
        List<Task> StrongResult = graph.sortGraph();
        assertEquals(ss, graph.getAlgorithm());


        int i = 0;
        boolean sbool = true;
        while (i < StrongCheck.size()-1){
            if (!(StrongCheck.get(i).getID() == StrongResult.get(i).getID())){
                sbool = false;
                break;
            }
            i++;
        }
        assertTrue(sbool);


        WeakSort ws = new WeakSort();

        graph.setAlgorithm(ws);
        List<Task> WeakResult = graph.sortGraph();
        assertEquals(ws, graph.getAlgorithm());

        int j = 0;
        boolean wbool = true;
        while (j < WeakCheck.size()-1){
            if (!(WeakCheck.get(i).getID() == WeakResult.get(i).getID())){
                wbool = false;
                break;
            }
            j++;
        }
        assertTrue(wbool);


        HierarchicalSort hs = new HierarchicalSort();

        graph.setAlgorithm(hs);
        List<Task> HierarchyResult = graph.sortGraph();
        assertEquals(hs, graph.getAlgorithm());

        int k = 0;
        boolean hbool = true;
        while (k < HierarchyCheck.size()-1){
            if (!(HierarchyCheck.get(i).getID() == HierarchyResult.get(i).getID())){
                hbool = false;
                break;
            }
            k++;
        }
        assertTrue(hbool);

    }
}
