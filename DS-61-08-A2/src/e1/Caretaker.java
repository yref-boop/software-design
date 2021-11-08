package e1;

public class Caretaker extends Staff {

    public Caretaker(String name, String surname, int horcruxes) {
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        category = Category.Caretaker;
    }

    @Override
    double getReward() { return Horcruxes * 65; }
}
