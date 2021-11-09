package e1;

public class Gamekeeper extends Staff {

    public Gamekeeper(String name, String surname, int horcruxes) {
        //pass every value through the constructor
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        category = Category.Gamekeeper;
    }

    //gets the reward double fo the print functions
    @Override
    double getReward() { return Horcruxes * 75; }
}
