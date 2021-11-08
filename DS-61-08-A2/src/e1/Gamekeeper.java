package e1;

public class Gamekeeper extends Staff {

    public Gamekeeper(String name, String surname, int horcruxes) {
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        category = Category.Gamekeeper;
    }

    @Override
    double getReward() { return Horcruxes * 75; }
}
