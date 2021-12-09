package e2;


//task works as the Component class
public abstract class Task{

    private char id;

    public Task (char id){
        this.id = id;
    }

    public char getid{
        return id;
    }

    public void setid{
        this.id = id;
    }

}


//BotTask plays the role of leaf
public class BotTask extends Task{

}


//TopTask plays the role of composite
public class TopTask extends Task{

}