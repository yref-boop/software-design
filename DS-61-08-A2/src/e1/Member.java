package e1;

public class Member {

    enum Category {Student, Ghost, Teacher, Gamekeeper, Caretaker}

    public String Name;
    public String Surname;
    public int Horcruxes;
    public Category category;

    String getCategory() { return category.toString() + " "; }
    String getName() { return Name; }
    String getSurname() { return Surname; }
    int getHorcruxes() { return Horcruxes; }
    double getReward() { return 0.0; }
}