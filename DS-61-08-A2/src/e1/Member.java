package e1;

public class Member {

    //category enum for all the members
    enum Category {Student, Ghost, Teacher, Gamekeeper, Caretaker}

    //data for all the members
    public String Name;
    public String Surname;
    public int Horcruxes;
    public Category category;

    //default functions for all the members
    String getCategory() { return category.toString() + " "; }
    String getName() { return Name; }
    String getSurname() { return Surname; }
    int getHorcruxes() { return Horcruxes; }
    double getReward() { return 0.0; }
}