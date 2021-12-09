package e2;

//this interface plays the Strategy role

public interface SortingAlgorithm {
    void sort (Task t) ;
}

//the following classes are the concrete strategy role

public class WeakSort implements SortingAlgorithm {
    @Override
    public void sort(Task t) {

    }
}

public class StrongSort implements SortingAlgorthm{
    @Override
    public void sort(Task t){

    }
}

public class HierarchicalSort implements SortingAlgorithm {
    @Override
    public void sort(Task t) {

    }
}
