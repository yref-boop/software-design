package e1;

public class Ghost extends Resident {

    House Hou;

    public Ghost(String name, String surname, String house, int horcruxes) {
        Name = name;
        Surname = surname;
        Horcruxes = horcruxes;
        Hou = House.valueOf(house);
        category = Category.Ghost;
    }

    @Override
    String getCategory() { return category.toString() + " of " + Hou.toString() + " "; }

    @Override
    double getReward() {
        int r = Horcruxes * 80;

        if (Hou == House.Slytherin) r *= 2;

        return r;
    }
}
