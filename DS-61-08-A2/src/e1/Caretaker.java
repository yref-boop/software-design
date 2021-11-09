package e1;

public class Caretaker extends Staff {

    public Caretaker(String name, String surname, int horcruxes) {
        //pass every value through the constructor
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        category = Category.Caretaker;
    }

    //gets the reward double fo the print functions
    @Override
    double getReward() { return Horcruxes * 65; }
}
