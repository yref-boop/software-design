package e2;

public class TopTask extends Task{
    private List<Taks> tasks = new ArrayList<>();

    public TopTask(char id) {super(id);}
    public void add(Task task) {tasks.add(task)};
    public void remove (Task task) {tasks.remove (task)};
    public Task getTask(int i) {return tasks.get(i);}
    
}
